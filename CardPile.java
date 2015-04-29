/**
   Represents a pile of cards.
   @author J.P. O’Malley
*/


// Import classes
import java.util.ArrayList;

public class CardPile {
   
   // Fields
   
   /**
      An ArrayList of the cards in the pile.
      (Index 0 is the top of the pile.)
   */
   private ArrayList<Card> pile;
   
   // Constructors
   
   /**
      Creates a CardPile object with a
      pile that has no cards.
   */
   public CardPile() {
      pile = new ArrayList<Card>();
   }
   
   // Methods
   
   // Add and remove methods
   
   /**
      Adds a card at the pile at the
      specified position in the pile.
      @param index the index of where
      the card is to be added
      @param newCard the card to be added
   */
   public void add(int index, Card newCard) {
      pile.add(index, newCard);
   }
   
   /**
      Adds a card to the top of the pile.
      @param newCard the card to be added
   */
   public void addToTop(Card newCard) {
      add(0, newCard);
   }
   
   /**
      Adds a card to the bottom of the pile.
      @param newCard the card to be added
   */
   public void addToBottom(Card newCard) {
      add(size(), newCard);
   }
   
   /**
      Removes the card at the specified
      position in the pile.
      @param index the index of the
      card to be removed
      @return the card that was removed
      from the pile
   */
   public Card remove(int index) {
      return pile.remove(index);
   }
   
   /**
      Removes the card at the top of
      the pile.
      @return the card that was removed
      from the pile
   */
   public Card removeFromTop() {
      return remove(0);
   }
   
   /**
      Removes the card at the bottom of
      the pile.
      @return the card that was removed
      from the pile
   */
   public Card removeFromBottom() {
      return remove(size() - 1);
   }
   
   // Get and set methods
   
   /**
      Returns the card at the specified
      position in the pile.
      @param index the index of the
      card to return
      @return the card at the specified
      position in the pile
   */
   public Card get(int index) {
      return pile.get(index);
   }
   
   /**
      Replaces the card at the specified
      position in the pile with the
      specified card. 
      @param index the index of the card
      to replace
      @param newCard the card that will
      replace the card at the specified
      position in the pile
   */
   public void set(int index, Card newCard) {
      pile.set(index, newCard);
   }
   
   // Other methods
   
   /**
      Returns the number of cards in the pile
      @return the number of cards in the pile
   */
   public int size() {
      return pile.size();
   }
   
   /**
      Returns {@code true} if there are no
      cards in the pile.
      @return {@code true} if there are no
      cards in the pile
   */ 
   public boolean isEmpty() {
      
      if (size() == 0) {
         return true;
      }
      else {
         return false;
      }
   }
}