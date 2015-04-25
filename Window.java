/**
   Displays a window for the War application.
   @author J.P. O’Malley
*/


// Import classes
import javax.swing.*;

public class Window extends JFrame {

   /**
      Creates a window for the application’s GUI.
   */   
   public Window() {
      
      final int WINDOW_WIDTH = 350;   // Window width in pixels
      final int WINDOW_HEIGHT = 250;  // Window height in pixels

      setTitle("War"); // Set title
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT); // Set size
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close button
      setVisible(true); // Display window
   }
}