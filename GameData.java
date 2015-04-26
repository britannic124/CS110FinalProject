/**
   Represents a card game of war.
   @author J.P. O’Malley
*/

public class GameData {
   
   // Fields
   
   /** The starting deck. */
   private Deck mainDeck;
   /** The player’s hand. */
   private Hand playHand;
   /** The computer’s hand. */
   private Hand compHand;
   /** The player’s current cards in play. */
   private Pile playPile;
   /** The computer’s current cards in play. */
   private Pile compPile;
//    private Card /** The player’s last played card. */
//                 playCard,
//                 /** The computer’s last played card. */
//                 compCard;
   /** The winner of the game. */
   private int gameWinner;
   /** The winner of the last battle. */
   private int btlWinner;
   public static final int NONE = 0,
                           PLAY = 1,
                           COMP = 2;
   
   // Constructor
   
   /**
      Starts a simulated game, shuffling a full deck and
      distributing the cards to the player and computer.
   */
   public GameData() {
      
      // Initialize decks
      mainDeck = new Deck();
      playHand = new Hand();
      compHand = new Hand();
      playPile = new Pile();
      compPile = new Pile();
      
      mainDeck.shuffle(); // Shuffle deck
      // Distribute cards equaly
      playHand.addCards(mainDeck, Deck.CARDS_IN_DECK / 2);
      compHand.addCards(mainDeck);
      
      // Initialize winners
      gameWinner = NONE;
      btlWinner = NONE;
   }
   
   // Methods
   
   /**
      Plays a battle. The player and the computer
      put down two cards. Whoever’s card is higher
      wins.
   */
   public void startBattle() {
      
      // Check if someone won the last battle
      if (btlWinner == NONE) {
         
         // Deal two cards
         for (int i = 0; i < 2; i++) {
            playHand.addCard(playHand.dealCard());
            compHand.addCard(compHand.dealCard());
         }
      }
      else {
         endWar();
      }
   }
   
   /**
      Returns the cards in the piles back to the
      player who won the last battle.
   */
   private void endWar() {
      
      // Return the piles to the winner’s hand
      if (btlWinner == PLAY) {
         playHand.addCards(playPile);
         playHand.addCards(compPile);
      }
      else {
         compHand.addCards(compPile);
         compHand.addCards(playPile);
      }
      
      // Reset battle winner
      btlWinner = NONE;
   }
   
   /**
      Calculates the winner of the last round and
      sets the value to the {@link btlWinner} field.
   */
   private void calcBtlWinner() {
      
      // Get the last cards played
      Card playCard = new Card(playPile.getTopCard()),
           compCard = new Card(compPile.getTopCard());
      
      // Compare them
      if (playCard.compareRank(compCard) == 1) {
         btlWinner = PLAY;
      }
      else if (playCard.compareRank(compCard) == 0) {
         btlWinner = NONE;
      }
      else {
         btlWinner = COMP;
      }
   }
   
   /**
      Returns the winner of the game.
      @return The winner of the game as an
              interger ({@value PLAY}
              (player), {@value COMP} (computer), 
              or {@value NONE} (unfinished game).
   */
   public int getGameWinner() {
      return gameWinner;
   }
   
   /**
      Returns the winner of the last battle.
      @return The winner of the last battle as an
              interger ({@value PLAY}
              (player), {@value COMP} (computer), 
              or {@value NONE} (war has not started
              last turn was a tie).
   */
   public int getBattleWinner() {
      return btlWinner;
   }
   
   /**
      Returns the player’s last played card.
      @return The player’s last played card.
   */
   public Card getPlayCard() {
      return new Card(playPile.getTopCard());
   }
   
   /**
      Returns the computer’s last played card.
      @return The computer’s last played card.
   */
   public Card getCompCard() {
      return new Card(compPile.getTopCard());
   }
   
   /**
      Returns the number of cards left in the
      player’s hand.
      @return The number of cards left.
   */
   public int getPlayHandRemaining() {
      return playHand.cardsRemaining();
   }
   
   /**
      Returns the number of cards left in the
      computer’s hand.
      @return The number of cards left.
   */
   public int getCompHandRemaining() {
      return compHand.cardsRemaining();
   }
   
   /**
      Returns the number of cards left in the
      player’s pile.
      @return The number of cards left.
   */
   public int getPlayPileRemaining() {
      return playPile.cardsRemaining();
   }
   
   /**
      Returns the number of cards left in the
      computer’s pile.
      @return The number of cards left.
   */
   public int getCompPileRemaining() {
      return compPile.cardsRemaining();
   }
}