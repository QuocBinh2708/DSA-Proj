package src.minesweeper;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.decoder.Bitstream;
import javazoom.jl.decoder.Header;
import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class LoopingPlayer {

    private String filename;
    private Player player;
    private Thread playerThread;
    private boolean loop;
    private boolean paused;
    private int pausedFrame;

    public LoopingPlayer(String filename) {
        this.filename = filename;
        this.loop = true;
        this.paused = false;
        this.pausedFrame = 0;
    }

    public void play() {
        playerThread = new Thread(() -> {
            while (loop) {
                try (FileInputStream fis = new FileInputStream(filename);
                     BufferedInputStream bis = new BufferedInputStream(fis)) {
                    Bitstream bitstream = new Bitstream(bis);
                    if (pausedFrame > 0) {
                        bitstream.closeFrame();
                        Header header = bitstream.readFrame();
                        for (int i = 0; i < pausedFrame; i++) {
                            header = bitstream.readFrame();
                            bitstream.closeFrame();
                        }
                    }
                    player = new Player(bis);
                    player.play();
                } catch (JavaLayerException | IOException e) {
                    e.printStackTrace();
                    break;
                }
                synchronized (this) {
                    while (paused) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        });
        playerThread.start();
    }

    public void stop() {
        this.loop = false;
        resume(); // Ensure any paused state is cleared to stop the loop
        if (player != null) {
            player.close();
        }
        try {
            if (playerThread != null) {
                playerThread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void pause() {
        if (!paused && player != null) {
            paused = true;
            pausedFrame = getCurrentFrame();
            player.close();
        }
    }

    public synchronized void resume() {
        if (paused) {
            paused = false;
            notifyAll();
        }
    }

    public boolean isPaused() {
        return paused;
    }

    private int getCurrentFrame() {
        //this method is the crucial part for pausing the music.
        //It will return the value(frame) of the music is playing, in order to be paused or resume.
        //But due to the complexity, right now i will not implement the code, 
        //instead it will return 0, so the music will start playing from the beginning.
        return 0;
    }
}
