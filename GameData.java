/**
   Represents a card game of war.
   @author J.P. O’Malley
*/

public class GameData {
   
   // Fields
   private Hand /** The player’s hand. */
                playHand,
                /** The computer’s hand. */
                compHand;
                /** The player’s current cards in play. */
   private Pile playPile,
                /** The computer’s current cards in play. */
                compPile;
//    private Card /** The player’s last played card. */
//                 playCard,*/
//                 /** The computer’s last played
   public static final int TIE = 0,
                           PLAY = 1,
                           COMP = 2;
   
   /**
      Plays one turn of a battle and returns
      the winner.
      @return The winner as an interger ({@value PLAY}
              (player), {@value COMP} (computer), or
              {@value TIE} (tie)).
   */
   public int playBattle() {
      
      // Deal two cards
      for (int i = 0; i < 2; i++) {
         playHand.addCard(playHand.dealCard());
         compHand.addCard(compHand.dealCard());
      }
      
      // Check who won the round and return winner
      Card playCard = new Card(playPile.getTopCard()),
           compCard = new Card(compPile.getTopCard());
      
      if (playCard.compareRank(compCard) == 1) {
         return PLAY;
      }
      else if (playCard.compareRank(compCard) == 0) {
         return TIE;
      }
      else {
         return COMP;
      }
   }
   
   /**
      Returns the cards in the piles back to the
      winning player.
      @param winner Whoever won the war.
   */
   public void endWar(int winner) {
      
      playCard = null;
      compCard = null;
      
      if (winner == PLAY) {
         playHand.addCards(playPile);
         playHand.addCards(compPile);
      }
      else {
         compHand.addCards(compPile);
         compHand.addCards(playPile);
      }
   }
}