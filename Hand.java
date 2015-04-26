/**
   Represents a hand of cards.
   @author J.P. O’Malley
*/

public class Hand extends Deck {
   
   // Constructors
   
   /**
      Creates a hand capable of holding up to 52 cards.
   */
   public Hand() {
      deck = new Card[CARDS_IN_DECK];
      removeAll();
   }
   
   // Methods
   
   /**
      Removes all cards from the hand.
   */
   protected void removeAll() {
      while (!isEmpty()) {
         dealCard();
      }
   }
   
   /**
      Adds a card to the bottom of the deck.
      @param newCard The card to be added.
   */
   public void addCard(Card newCard) {
      
      // Check if there’s room to add a card.
      if (ct < CARDS_IN_DECK) {
         
         // Shift each card in the deck up.
         for (int i = ct - 1; i >= 0; i--) {
            deck[i+1] = deck[i];
         }
      
         // Add the card to the bottom
         deck[0] = newCard;
         ct++;
      }      
   }
   
   /**
      Adds a set of cards to the bottom of the deck.
      @param newCards The set of cards to be added.
   */
   public void addCards(Deck newCards) {
      
      int handSize = newCards.cardsRemaining();
      
      // Check if there’s room to add cards
      if (ct + handSize < CARDS_IN_DECK) {
         
         // Shift each card in the deck up the
         // needed number of spaces
         for (int i = ct - 1; i >= 0; i--) {
            deck[i + handSize] = deck[i];
         }
      }
      
      // Add the new cards to the bottom
      for (int i = handSize - 1; i >= 0; i--) {
         deck[i] = newCards.dealCard();
      }
      ct += handSize;
   }
   
   /**
      Adds a specific number of cards to the bottom of the deck.
      @param newCards The hand from which the cards will be taken.
      @param numCards The number of cards which are to be added.
   */
   public void addCards(Deck newCards, int numCards) {
      
      int handSize = newCards.cardsRemaining();
      
      // Check if there’s room to add a card and that
      // there are enough cards in the source hand
      if (ct + numCards < CARDS_IN_DECK &&
          numCards <= handSize) {
         
         // Shift each card in the deck up the
         // needed number of spaces
         for (int i = ct - 1; i >= 0; i--) {
            deck[i + numCards] = deck[i];
         }
      }
      
      // Add the new cards to the bottom
      for (int i = numCards - 1; i >= 0; i--) {
         deck[i] = newCards.dealCard();
      }
      ct += numCards;
   }
   
//    public static void main(String[] args) {
//       Hand myHand = new Hand();
//       Hand myHand2 = new Hand();
//       myHand.addCardToTop(new Card(Card.ACE, Card.SPADES));
//       myHand.addCardToTop(new Card(5, Card.HEARTS));
//       myHand.addCardToTop(new Card(Card.KING, Card.CLUBS));
//       myHand2.addCardsToBottom(myHand, 2);
//       System.out.println(myHand2.dealCard());
//       System.out.println(myHand.dealCard());
//    }
}