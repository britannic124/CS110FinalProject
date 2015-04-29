/**
   Represents a card game of war.
   @author J.P. O’Malley
*/

public class GameData {
   
   // Fields
   
   /** The starting deck. */
   private Deck mainDeck;
   /** The player’s hand. */
   private CardPile playHand;
   /** The computer’s hand. */
   private CardPile compHand;
   /** The player’s current cards in play. */
   private CardPile playPile;
   /** The computer’s current cards in play. */
   private CardPile compPile;
   /** The winner of the game. */
   private int gameWinner;
   /** The winner of the last battle. */
   private int btlWinner;
   /**
      The number of cards dealt during
      a regular battle.
   */
   public static final int BTL_CRDS = 1;
   /**
      The number of cards dealt during
      a war battle.
   */
   public static final int WAR_CRDS = 2;
   /** Integer representation of a tie. */
   public static final int NONE = 0;
   /** Integer representation of player. */
   public static final int PLAY = 1;
   /** Integer representation of computer. */
   public static final int COMP = 2;
   
   // Constructor
   
   /**
      Starts a simulated game, shuffling a full deck and
      distributing the cards to the player and computer.
   */
   public GameData() {
      
      // Initialize decks
      mainDeck = new Deck();
      playHand = new CardPile();
      compHand = new CardPile();
      playPile = new CardPile();
      compPile = new CardPile();
      
      mainDeck.shuffle(); // Shuffle deck
      
      // Split deck among player and computer
      for (int i = 0; i < Deck.FULL_DECK / 2; i++) {
         playHand.addToBottom(mainDeck.removeFromTop());
      }
      for (int i = 0; i < Deck.FULL_DECK / 2; i++) {
         compHand.addToBottom(mainDeck.removeFromTop());
      }
      
      // Initialize winners
      gameWinner = NONE;
      btlWinner = NONE;
   }
   
   // Methods
   
   /**
      Makes a turn happen: either starts a battl.
      Plays a battle. The player and the computer
      put down two cards. Whoever’s card is higher
      wins.
   */
   public void next() {
      System.out.println(playPile.isEmpty() && compPile.isEmpty());
      
      // Check that there are no cards in the piles
      if (playPile.isEmpty() && compPile.isEmpty()) {
      
         // Player and computer each deal a card
         battle(BTL_CRDS);
      }
      
      // If there are cards, check if there is no winner
      else if (btlWinner == NONE) { // If there is no winner…
         
         // Player and computer each deal two cards
         battle(WAR_CRDS);
      }
      
      // If someone did win, return cards to winner
      else {
         endWar();
      }
      System.out.println(btlWinner);
   }
   
   /**
      Makes both the player and the computer each
      deal the specified number of cards and then
      calculates the winner of the battle.
      @param numCards the number of cards the player
      and the computer will each deal
   */
   private void battle(int numCards) {
   
      System.out.println("Running GameData.battle(int)…");
            
      for (int i = 0; i < numCards; i++) {
         
         playPile.addToTop(playHand.removeFromTop());
         compPile.addToTop(compHand.removeFromTop());
      }
      
      // Get the last cards played
      Card playCard = getPlayPileTop(),
           compCard = getCompPileTop();
      
      // Compare the cards
      
      // If the rank of the player’s card is
      // higher the rank of the computer’s card…
      if (playCard.compareRank(compCard) > 0) {
         btlWinner = PLAY;
      }
      // If the player’s card and the computer’s
      // card have the same rank
      else if (playCard.compareRank(compCard) == 0) {
         btlWinner = NONE;
      }
      // If the rank of the computer’s card is
      // higher than the rank player’s card…
      else {
         btlWinner = COMP;
      }
   }
   
   /**
      Returns the cards in the piles back to the
      hand of player who won the last battle.
   */
   private void endWar() {
      
      // Return the piles to the winner’s hand
      if (btlWinner == PLAY) {
         
         while (!playPile.isEmpty()) {
            playHand.addToBottom(playPile.removeFromTop());
         }
         while (!compPile.isEmpty()) {
            playHand.addToBottom(compPile.removeFromTop());
         }
      }
      else {
         while (!compPile.isEmpty()) {
            compHand.addToBottom(compPile.removeFromTop());
         }
         while (!playPile.isEmpty()) {
            compHand.addToBottom(playPile.removeFromTop());
         }
      }
      
      // Reset battle winner
      btlWinner = NONE;
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
              interger ({@value PLAY} (player),
              {@value COMP} (computer), or
              {@value NONE} (there was no winner).
   */
   public int getBtlWinner() {
      return btlWinner;
   }
   
   /**
      Returns the player’s last played card.
      @return The card at the top of the
              player’s pile.
   */
   public Card getPlayPileTop() {
      return playPile.get(0);
   }
   
   /**
      Returns the computer’s last played card.
      @return The card at the top of the
              computer’s pile.
   */
   public Card getCompPileTop() {
      return compPile.get(0);
   }
   
   /**
      Returns the number of cards in the
      player’s hand.
      @return The number of cards in the
              player’s hand.
   */
   public int playHandSize() {
      return playHand.size();
   }
   
   /**
      Returns the number of cards in the
      computer’s hand.
      @return The number of cards in the
              computer’s hand.
   */
   public int compHandSize() {
      return compHand.size();
   }
   
   /**
      Returns the number of cards in the
      player’s pile.
      @return The number of cards in the
              player’s pile.
   */
   public int playPileSize() {
      return playPile.size();
   }
   
   /**
      Returns the number of cards in the
      computer’s pile.
      @return The number of cards in the
              computer’s pile.
   */
   public int compPileSize() {
      return compPile.size();
   }
}