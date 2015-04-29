/**
   Represents a standard 52-card deck.
   @author J.P. O’Malley
*/


// Import classes
import java.util.Random;

public class Deck extends CardPile {
   
   // Fields
   
   /** The number of cards in a full deck. */
   public static final int FULL_DECK = 52;
   
   // Constructors
   
   /**
      Creates a Deck object with a full
      unshuffled 52-card deck.
   */
   public Deck() {
      freshDeck();
   }
   
   // Methods
   
   /**
      Replaces the current deck with a
      full unshuffled 52-card deck.
   */
   public void freshDeck() {
      
      // Remove current cards
      while (!isEmpty()) {
         remove(0);
      }
      
      // Go through each card suit 
      for (int s = 0; s < Card.NUM_SUITS; s++) {
      
         // Go through each card rank
         for (int r = Card.MIN_RANK; r <= Card.MAX_RANK; r++) {
            
            // Add each type of card to the deck
            addToBottom(new Card(r, s));
         }
      }
   }
            
   /**
      Shuffles all the cards in the deck.
   */
   public void shuffle() {
      
      Random rand = new Random(); 
      int randIndex;
      Card randCard;
      
      for (int i = 0; i < size(); i++) {
         
         randIndex = rand.nextInt(size());
         randCard = get(i);
         set(i, get(randIndex));
         set(randIndex, randCard);
      }
   }
}