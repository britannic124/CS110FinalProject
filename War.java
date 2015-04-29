/**
   This program simulates the card game of war.
   @author J.P. O’Malley
*/


// Import classes
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class War extends JFrame {
   
   // Class constants
   
   /** Window width in pixels. */
   private final int WIN_W = 800;
   /** Window width in pixels. */
   private final int WIN_H = 665;
   /** Background color. */
   public static final Color BG_COLOR = new Color(53, 94, 59);
   /** Message background color. */
   public static final Color MSG_COLOR = new Color(247, 0, 28);
   public static final String PLAY_BTL_TXT = "Player Wins!",
                              COMP_BTL_TXT = "Computer Wins!",
                              PLAY_GAME_TXT = "Player Wins the Game!",
                              COMP_GAME_TXT = "Computer Wins the Game!",
                              START_TXT = "Start",
                              DEAL_TXT = "Battle",
                              WAR_TXT = "War",
                              NEXT_TXT = "Next",
                              RST_TXT = "New Game",
                              IMG_PATH = "resource/",
                              IMG_EXT = ".jpg",
                              BACK_IMG = IMG_PATH + "back.jpg",
                              BLNK_IMG = IMG_PATH + "blank.png";
   
   // Fields
   
   private JPanel msgPanel,
                  ctrPanel,
                  compPanel,
                  playPanel,
                  buttonPanel;
   private JLabel msgLabel,
                  compHandLabel,
                  compPileLabel,
                  playHandLabel,
                  playPileLabel;
   private JButton button;
   public GameData game;
   
   // Constructor
   
   
   /**
      Creates a window for the application’s GUI.
   */   
   public War() {
      
      game = new GameData(); // Create game data
      
      setTitle("War"); // Set title
      setSize(WIN_W, WIN_H); // Set size
      setMinimumSize(new Dimension(WIN_W, WIN_H));
      setMaximumSize(new Dimension(WIN_W, WIN_H));
      setLocationRelativeTo(null); // Center on screen
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close button
      
      
      button = new JButton(START_TXT); // Create button
      button.addActionListener(new ButtonListener()); // Add action listener
      
      setLayout(new BorderLayout()); // Set layout
      buildPanels(); // Build panels
      setAppearance(); // Set appearance
      pack(); // Pack panels
      setVisible(true); // Display window
   }
   
   // Methods
   
   /**
      Builds the computer and player panels.
   */
   private void buildPanels() {
   
      // Create panels
      msgPanel = new JPanel();
      ctrPanel = new JPanel();
      compPanel = new JPanel();
      playPanel = new JPanel();
      buttonPanel = new JPanel();
      
      // Create labels
      msgLabel = new JLabel(" ", SwingConstants.CENTER);
      compHandLabel = new JLabel("", scaledImg(BLNK_IMG),
                                 SwingConstants.CENTER);
      compPileLabel = new JLabel("", scaledImg(BLNK_IMG),
                                 SwingConstants.CENTER);
      playHandLabel = new JLabel("", scaledImg(BLNK_IMG),
                                 SwingConstants.CENTER);
      playPileLabel = new JLabel("", scaledImg(BLNK_IMG),
                                 SwingConstants.CENTER);
      
      // Set background colors
      setBackground(BG_COLOR);
      msgPanel.setBackground(BG_COLOR);
      compPanel.setBackground(BG_COLOR);
      playPanel.setBackground(BG_COLOR);
      buttonPanel.setBackground(BG_COLOR);
      
      // Set foreground colors
      msgLabel.setForeground(Color.WHITE);
      compHandLabel.setForeground(Color.WHITE);
      compPileLabel.setForeground(Color.WHITE);
      playHandLabel.setForeground(Color.WHITE);
      playPileLabel.setForeground(Color.WHITE);
      
      // Set panel layouts
      ctrPanel.setLayout(new BorderLayout());
      compPanel.setLayout(new BorderLayout());
      playPanel.setLayout(new BorderLayout());
      
      // Add labels to panels
      msgPanel.add(msgLabel);
      
      compPanel.add(compHandLabel, BorderLayout.NORTH);
      compPanel.add(compPileLabel, BorderLayout.SOUTH);
            
      playPanel.add(playPileLabel, BorderLayout.NORTH);
      playPanel.add(playHandLabel, BorderLayout.SOUTH);
      
      buttonPanel.add(button);
      
      // Add panels to panels
      ctrPanel.add(compPanel, BorderLayout.NORTH);
      ctrPanel.add(playPanel, BorderLayout.SOUTH);
      
      // Add panels to window and pack
      add(msgPanel, BorderLayout.NORTH);
      add(ctrPanel, BorderLayout.CENTER);
      add(buttonPanel, BorderLayout.SOUTH);
   }
   
   /**
      Sets the appearance of the labels.
   */
   private void setAppearance() {
      
      // Check how many cards are in each pile
      int compHandCount = game.compHandSize(),
          compPileCount = game.compPileSize(),
          playHandCount = game.playHandSize(),
          playPileCount = game.playPileSize();
      
      // Set computer hand label appearance
      compHandLabel.setText(Integer.toString(game.compHandSize()));
      if (compHandCount > 0) {
         compHandLabel.setIcon(scaledImg(BACK_IMG));
      }
      else {
         compHandLabel.setIcon(scaledImg(BLNK_IMG));
      }
      
      // Set computer pile label appearance
      compPileLabel.setText(Integer.toString(compPileCount));
      if (compPileCount > 0) {
         compPileLabel.setIcon(scaledImg(IMG_PATH +
                               game.getCompPileTop() + IMG_EXT));
      }
      else {
         compPileLabel.setIcon(scaledImg(BLNK_IMG));
      }
      
      // Set player hand label appearance
      playHandLabel.setText(Integer.toString(playHandCount));
      if (playHandCount > 0) {
         playHandLabel.setIcon(scaledImg(BACK_IMG));
      }
      else {
         playHandLabel.setIcon(scaledImg(BLNK_IMG));
      }
      
      // Set player pile label appearance
      playPileLabel.setText(Integer.toString(playPileCount));
      if (playPileCount > 0) {
         playPileLabel.setIcon(scaledImg(IMG_PATH +
                               game.getPlayPileTop() + IMG_EXT));
      }
      else {
         playPileLabel.setIcon(scaledImg(BLNK_IMG));
      }
      
      // Set button and message text
      
      // Is someone won the game…
      if (game.getGameWinner() != GameData.NONE) {
         
         button.setText(RST_TXT);
         msgLabel.setBackground(BG_COLOR);
         
         // If the user won the game…
         if (game.getGameWinner() == GameData.PLAY) {
            msgLabel.setText(PLAY_GAME_TXT);
         }
         
         // If the computer won the game…
         else if (game.getGameWinner() == GameData.COMP) {
            msgLabel.setText(COMP_GAME_TXT);
         }
      }
      
      // If no one won the game; if no one won the battle…
      else if (game.getBtlWinner() == GameData.NONE) {
         
         button.setText(DEAL_TXT);
         
         // If there is no war…
         if (playPileCount == 0 && compPileCount == 0) {
            msgPanel.setBackground(BG_COLOR);
            msgLabel.setText(" ");
         }
         
         // If there is a war…
         else {
            msgPanel.setBackground(MSG_COLOR);
            msgLabel.setText(WAR_TXT);
         }
      }
      
      // If someone won the battle…
      else {
         
         button.setText(NEXT_TXT);
         msgPanel.setBackground(BG_COLOR);
         
         // If the player won the battle…
         if (game.getBtlWinner() == GameData.PLAY) {
            msgLabel.setText(PLAY_BTL_TXT);
         }
         else {
            msgLabel.setText(COMP_BTL_TXT);
         }
      }
   }
   
   /**
      The ButtonListener is an action listener class for the
      button.
   */
   private class ButtonListener implements ActionListener {
      
      /**
         Initiates a round in the game and refreshes the GUI.
      */
      public void actionPerformed(ActionEvent event) {
         
         // Only initiate next step if there is no winner
         if (game.getGameWinner() == GameData.NONE) {
            game.next(); // Initiate a round
         }
         else {
            resetGame();
         }
         setAppearance(); // Refresh GUI
      }
   }
   
   /**
      Starts a new game.
   */
   private void resetGame() {
      game = new GameData();
   }
   
   /**
      Resizes image to 108 px by 150 px.
      @param filename The path of the file.
      @return The resized image.
   */
   private ImageIcon scaledImg(String filename){
      
      BufferedImage img = null;
      try {
         img = ImageIO.read(new File(filename));
      } catch (IOException e) {
         e.printStackTrace();
      }
      
      Image dimg = img.getScaledInstance(108, 150, Image.SCALE_SMOOTH);
      
      return new ImageIcon(dimg);
   }
      
   public static void main(String[] args) {
      
      new War();
   }
}