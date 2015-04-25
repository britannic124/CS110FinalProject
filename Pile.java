/**
   Represents a pile of cards.
   @author J.P. O’Malley
*/

public class Pile extends Deck {
   
   // Constructors
   
   /**
      Creates a pile capable of holding up to 52 cards.
   */
   public Pile() {
      deck = new Card[CARDS_IN_DECK];
      removeAll();
   }
   
   // Methods
   
   /**
      Removes all cards from the pile.
   */
   protected void removeAll() {
      while (!isEmpty()) {
         dealCard();
      }
   }
   
   /**
      Adds a card to the bottom of the deck.
   */
   public void addCardToBottom(Card newCard) {
      
      // Check if there’s room to add a card.
      if (ct < CARDS_IN_DECK) {
         
         // Shift each card in the deck up.
         for (int i = ct - 1; i >= 0; i--) {
            deck[i+1] = deck[i];
         }
      }
      
      // Add the card to the bottom
      deck[0] = newCard;
      ct++;
   }
   
   public static void main(String[] args) {
      Pile myPile = new Pile();
      myPile.freshDeck();
      myPile.dealCard();
      myPile.shuffle();
      myPile.addCardToBottom(new Card());
      System.out.println(myPile.cardsRemaining());
   }
}