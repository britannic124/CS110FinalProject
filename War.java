/**
   This program simulates the card game of war.
   @author J.P. O’Malley
*/


// Import classes
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class War extends JFrame {
   
   // Class constants
   
   /** Window width in pixels. */
   private final int WIN_W = 800;
   /** Window width in pixels. */
   private final int WIN_H = 600;
   public static final String DEAL_TXT = "Deal",
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
   private GameData game;
   
   // Constructor
   
   
   /**
      Creates a window for the application’s GUI.
   */   
   public War() {
      
      game = new GameData(); // Create game data
      
      setTitle("War"); // Set title
      setSize(WIN_W, WIN_H); // Set size
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close button
      
      
      button = new JButton(""); // Create button
      button.addActionListener(new ButtonListener()); // Add action listener
      
      setLayout(new BorderLayout()); // Set layout
      buildPanels(); // Build panels
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
      compHandLabel = new JLabel("", new ImageIcon(BLNK_IMG),
                                 SwingConstants.RIGHT);
      compPileLabel = new JLabel("", new ImageIcon(BLNK_IMG),
                                 SwingConstants.RIGHT);
      playHandLabel = new JLabel("", new ImageIcon(BLNK_IMG),
                                 SwingConstants.RIGHT);
      playPileLabel = new JLabel("", new ImageIcon(BLNK_IMG),
                                 SwingConstants.RIGHT);
      
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
      compPileLabel.setText("HELLO");
      
      // Check how many cards are remaining
      int compHandCt = game.getCompHandRemaining(),
          compPileCt = game.getCompPileRemaining(),
          playHandCt = game.getPlayHandRemaining(),
          playPileCt = game.getPlayPileRemaining();
      
      // Set computer hand label appearance
      compHandLabel.setText(Integer.toString(compHandCt));
      if (compHandCt > 0) {
         compHandLabel.setIcon(new ImageIcon(BACK_IMG));
      }
      else {
         compHandLabel.setIcon(new ImageIcon(BLNK_IMG));
      }
      
      // Set computer pile label appearance
      compPileLabel.setText(Integer.toString(compPileCt));
      if (compPileCt > 0) {
         compPileLabel.setIcon(new ImageIcon(IMG_PATH +
                               game.getCompCard() + IMG_EXT));
      }
      else {
         compPileLabel.setIcon(new ImageIcon(BLNK_IMG));
      }
      
      // Set player hand label appearance
      playHandLabel.setText(Integer.toString(playHandCt));
      if (playHandCt > 0) {
         playHandLabel.setIcon(new ImageIcon(BACK_IMG));
      }
      else {
         playHandLabel.setIcon(new ImageIcon(BLNK_IMG));
      }
      
      // Set player pile label appearance
      playPileLabel.setText(Integer.toString(playPileCt));
      if (playPileCt > 0) {
         playPileLabel.setIcon(new ImageIcon(IMG_PATH +
                               game.getPlayCard() + IMG_EXT));
      }
      else {
         playPileLabel.setIcon(new ImageIcon(BLNK_IMG));
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
   
   public static void main(String[] args) {
      
      new War();
   }
}