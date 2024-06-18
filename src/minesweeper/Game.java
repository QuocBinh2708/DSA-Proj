package src.minesweeper;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;


import javax.swing.*;

public class Game extends JFrame {

    private JLabel statusbar;
    private JButton bUndo;
    private JButton bRule;
    private JPanel buttonPanel;
    private JTextArea textArea;
    private JPanel statusPanel;
    protected Board board;

    private static final int BOARD_WIDTH = Board.BOARD_WIDTH;
    private static final int BOARD_HEIGHT = Board.BOARD_HEIGHT;
    

    public Game() throws IOException {

        initUI();

    }

    private void initUI() throws IOException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Minesweeper: Ben10 Edition");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(BOARD_WIDTH, BOARD_HEIGHT);
    setLocationRelativeTo(null);
        
    // Create main menu with background image
    ImagePanel mainMenuPanel = new ImagePanel("image/Ben10.jpg");
    mainMenuPanel.setLayout(new BoxLayout(mainMenuPanel, BoxLayout.Y_AXIS));

    // Title label
    JLabel titleLabel = new JLabel("MINESWEEPER: BEN 10 EDITION");
    titleLabel.setAlignmentX(Component.TOP_ALIGNMENT);
    titleLabel.setAlignmentY(Component.TOP_ALIGNMENT);
    titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
    titleLabel.setForeground(Color.BLACK);
    mainMenuPanel.add(Box.createVerticalGlue()); // Push components to the top
    mainMenuPanel.add(titleLabel);
    mainMenuPanel.add(Box.createRigidArea(new Dimension(0, 30))); // Spacing

    // Play button
    JButton playButton = new JButton("Play");
    playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    playButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                setSize(BOARD_WIDTH, BOARD_HEIGHT);
                startGame();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    });
    mainMenuPanel.add(playButton);
    mainMenuPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacing

    // Quit button
    JButton quitButton = new JButton("Quit");
    quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    quitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    });
    mainMenuPanel.add(quitButton);
    mainMenuPanel.add(Box.createVerticalGlue()); // Push components to the bottom

    add(mainMenuPanel);
    pack();
    setVisible(true);

    // Start background music
    Thread audioThread = new Thread(() -> {
        try {
            MP3Player.playMP3("sounds/Ben10.mp3");
        } catch (IOException e) {
            e.printStackTrace();
        }
    });
    audioThread.start();
}


    private void startGame() throws IOException{
        getContentPane().removeAll();
        statusPanel();
        Board board = new Board(statusbar, bUndo, bRule, textArea);
        add(board);
        setResizable(false);
        pack();
        
    }

    private void statusPanel() {
        bUndo = new JButton("Undo");
        bRule = new JButton("Rules");
        buttonPanel = new JPanel();
        
        add(buttonPanel, BorderLayout.NORTH);            
        buttonPanel.add(bRule, BorderLayout.NORTH);
        buttonPanel.add(bUndo, BorderLayout.SOUTH);

        statusPanel = new JPanel();
        statusbar = new JLabel("Flags Left");
        textArea = new JTextArea();
        textArea.setText("Input your name here...");
        statusPanel.add(statusbar, BorderLayout.NORTH);
        statusPanel.add(textArea, BorderLayout.SOUTH);
        add(statusPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            Game ex;
            try {
                ex = new Game();
                //Automatically saves file when user exits out of game
                ex.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(WindowEvent winEvt) {
                        try {
                            Board.saveGameStatus2File();
                        } catch (IOException ex1) {

                        }

                    }
                });
                ex.setVisible(true);

            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }
}
