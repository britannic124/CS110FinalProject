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
      
      int pileSize = newCards.cardsRemaining();
      
      // Check if there’s room to add cards
      if (ct + pileSize < CARDS_IN_DECK) {
         
         // Shift each card in the deck up the
         // needed number of spaces
         for (int i = ct - 1; i >= 0; i--) {
            deck[i + pileSize] = deck[i];
         }
      }
      
      // Add the new cards to the bottom
      for (int i = pileSize - 1; i >= 0; i--) {
         deck[i] = newCards.dealCard();
      }
      ct += pileSize;
   }
   
   /**
      Adds a specific number of cards to the bottom of the deck.
      @param newCards The pile from which the cards will be taken.
      @param numCards The number of cards which are to be added.
   */
   public void addCards(Deck newCards, int numCards) {
      
      int pileSize = newCards.cardsRemaining();
      
      // Check if there’s room to add a card and that
      // there are enough cards in the source pile
      if (ct + numCards < CARDS_IN_DECK &&
          numCards <= pileSize) {
         
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
   
   /*
   public static void main(String[] args) {
      Pile myPile = new Pile();
      Pile myPile2 = new Pile();
      myPile.addCardToTop(new Card(Card.ACE, Card.SPADES));
      myPile.addCardToTop(new Card(5, Card.HEARTS));
      myPile.addCardToTop(new Card(Card.KING, Card.CLUBS));
      myPile2.addCardsToBottom(myPile, 2);
      System.out.println(myPile2.dealCard());
      System.out.println(myPile.dealCard());
   }
   */
}