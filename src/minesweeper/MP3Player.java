package src.minesweeper;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.management.PlatformLoggingMXBean;

public class MP3Player {
    public static void playMP3(String filePath) throws IOException {
            try {
                FileInputStream fileInputStream = new FileInputStream(filePath);

                AdvancedPlayer player = new AdvancedPlayer(fileInputStream);
                player.play();

            } catch (JavaLayerException | FileNotFoundException e) {
                e.printStackTrace();
            }
    }
}
