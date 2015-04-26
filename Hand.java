/**
   Represents a pile of cards in a battle.
   @author J.P. O’Malley
*/

public class Hand extends Pile {
   
   // Method
   
   /**
      Gets the card at the top of the pile.
      @return The top card.
   */
   public Card getTopCard() {
      return deck[ct-1];
   }
   
   /**
      Adds a card to the top of the pile.
      @param newCard The card to be added.
   */
   public void addCard(Card newCard) {
      
      // Check if there’s room to add a card.
      if (ct < CARDS_IN_DECK) {
         
         // Add the card to the bottom.
         deck[ct] = newCard;
         ct++;
      }      
   }
}