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
   private final int WIN_H = 661;
   public static final Color BG_COLOR = new Color(53, 94, 59);
   public static final String STRT_TXT = "Start",
                              DEAL_TXT = "Deal",
                              NEXT_TXT = "Next",
                              IMG_PATH = "resource/",
                              IMG_EXT = ".jpg",
                              BACK_IMG = IMG_PATH + "back.jpg",
                              BLNK_IMG = IMG_PATH + "blank.png";
   
   // Fields
   
   private JPanel compPanel,
                  playPanel,
                  buttonPanel;
   private JLabel compHandLabel,
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
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close button
      
      
      button = new JButton(STRT_TXT); // Create button
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
      compPanel = new JPanel();
      playPanel = new JPanel();
      buttonPanel = new JPanel();
      
      // Create labels
      compHandLabel = new JLabel("", scaledImg(BLNK_IMG),
                                 SwingConstants.CENTER);
      compPileLabel = new JLabel("", scaledImg(BLNK_IMG),
                                 SwingConstants.CENTER);
      playHandLabel = new JLabel("", scaledImg(BLNK_IMG),
                                 SwingConstants.CENTER);
      playPileLabel = new JLabel("", scaledImg(BLNK_IMG),
                                 SwingConstants.CENTER);
      
      compHandLabel.setBackground(BG_COLOR);
      compPileLabel.setBackground(BG_COLOR);
      playHandLabel.setBackground(BG_COLOR);
      playPileLabel.setBackground(BG_COLOR);
      compPanel.setBackground(BG_COLOR);
      playPanel.setBackground(BG_COLOR);
      buttonPanel.setBackground(BG_COLOR);
      setBackground(BG_COLOR);
      compHandLabel.setForeground(Color.WHITE);
      compPileLabel.setForeground(Color.WHITE);
      playHandLabel.setForeground(Color.WHITE);
      playPileLabel.setForeground(Color.WHITE);
      
      compHandLabel.setBackground(Color.RED);
      // Set panel layouts
      compPanel.setLayout(new BorderLayout());
      playPanel.setLayout(new BorderLayout());
      
      // Add labels to panels
      compPanel.add(compHandLabel, BorderLayout.NORTH);
      compPanel.add(compPileLabel, BorderLayout.SOUTH);
            
      playPanel.add(playPileLabel, BorderLayout.NORTH);
      playPanel.add(playHandLabel, BorderLayout.SOUTH);
      
      buttonPanel.add(button);
      
      // Add panels to window and pack
      add(compPanel, BorderLayout.NORTH);
      add(playPanel, BorderLayout.CENTER);
      add(buttonPanel, BorderLayout.SOUTH);
   }
   
   /**
      Sets the appearance of the labels.
   */
   private void setAppearance() {
      
      // Check how many cards are remaining
      int compHandCt = game.getCompHandRemaining(),
          compPileCt = game.getCompPileRemaining(),
          playHandCt = game.getPlayHandRemaining(),
          playPileCt = game.getPlayPileRemaining();
      
      // Set computer hand label appearance
      compHandLabel.setText(Integer.toString(compHandCt));
      if (compHandCt > 0) {
         compHandLabel.setIcon(scaledImg(BACK_IMG));
      }
      else {
         compHandLabel.setIcon(scaledImg(BLNK_IMG));
      }
      
      // Set computer pile label appearance
      compPileLabel.setText(Integer.toString(compPileCt));
      if (compPileCt > 0) {
         compPileLabel.setIcon(scaledImg(IMG_PATH +
                               game.getCompCard() + IMG_EXT));
      }
      else {
         compPileLabel.setIcon(scaledImg(BLNK_IMG));
      }
      
      // Set player hand label appearance
      playHandLabel.setText(Integer.toString(playHandCt));
      if (playHandCt > 0) {
         playHandLabel.setIcon(scaledImg(BACK_IMG));
      }
      else {
         playHandLabel.setIcon(scaledImg(BLNK_IMG));
      }
      
      // Set player pile label appearance
      playPileLabel.setText(Integer.toString(playPileCt));
      if (playPileCt > 0) {
         playPileLabel.setIcon(scaledImg(IMG_PATH +
                               game.getPlayCard() + IMG_EXT));
      }
      else {
         playPileLabel.setIcon(scaledImg(BLNK_IMG));
      }
      
      // Set the button’s text
      if (game.getBattleWinner() == GameData.NONE) {
         button.setText(DEAL_TXT);
      }
      else {
         button.setText(NEXT_TXT);
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
         
         game.startBattle(); // Initiate a round
         setAppearance(); // Refresh GUI
      }
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