/**
   Represents a standard French playing card.
   @author J.P. O’Malley
*/


// Import classes.
import java.util.Random;

public class Card {

   // Class constants
   public static final int ACE = 1,
                           JACK = 11,
                           QUEEN = 12,
                           KING = 13,
                           SPADES = 0,
                           HEARTS = 1,
                           DIAMONDS = 2,
                           CLUBS = 3,
                           MIN_RANK = ACE,
                           MAX_RANK = KING,
                           NUM_SUITS = 4;
   
   // Fields
   
   /** The card’s rank. */
   private final int rank;
   /** The card’s suit. */
   private final int suit;
   
   // Constructors
   
   /** Creates a random card. */
   public Card() {
      
      rank = randRank();
      suit = randSuit();
   }
   
   /**
      Creates a copy of another card.
      @param orig The card to be copied.
   */
   public Card(Card orig) {
      
      rank = orig.getRank();
      suit = orig.getSuit();
   }
   
   /**
      Creates a card with the rank and suit given.
      @param rank The card’s rank as an interger.
                  (If an invalid value is given,
                  the rank will be randomly chosen.)
      @param suit The card’s suit as an interger.
                  (If an invalid value is given,
                  the suit will be randomly chosen.)
   */
   public Card(int rank, int suit) {
      
      if (MIN_RANK <= rank && rank <= MAX_RANK) {
         this.rank = rank;
      }
      else {
         this.rank = randRank();
      }
      
      if (0 <= suit && suit < NUM_SUITS) {
         this.suit = suit;
      }
      else {
         this.suit = randSuit();
      }
   }
   
   // Methods
   
   /**
      Generates a random rank.
      @return A rank as an interger.
   */
   private static int randRank() {
      
      Random rand = new Random();
      return MIN_RANK + rand.nextInt(MAX_RANK - MIN_RANK + 1);
   }
   
   /**
      Generates a random suit.
      @return A suit as an interger.
   */
   private static int randSuit() {
      
      Random rand = new Random();
      return rand.nextInt(NUM_SUITS);
   }
   
   /**
      Returns the rank as an interger value.
      @return The card’s rank as an interger.
              (e.g. {@value ACE})
   */
   public int getRank() {
      return rank;
   }
   
   /**
      Returns the suit as an interger value.
      @return The card’s suit represented by
              an interger. (e.g. {@value SPADES})
   */
   public int getSuit() {
      return suit;
   }
   
   /**
      Returns the card’s rank name.
      @return The card’s rank.
   */
   /*public String getRankName() {
      
      if (suit == ACE) {
   */
   
   /**
      Returns the card’s rank in shorthand.
      @return The rank in shorthand. (e.g. "A")
   */
   public String getRankShort() {
      
      if (getRank() == ACE) {
         return "A";
      }
      else if (getRank() == JACK) {
         return "J";
      }
      else if (getRank() == QUEEN) {
         return "Q";
      }
      else if (getRank() == KING) {
         return "K";
      }
      else {
         return "" + rank;
      }
   }
   
   /**
      Returns the suit in shorthand.
      @return The suit in shorthand. (e.g. "s")
   */
   public String getSuitShort() {
      
      if (getSuit() == SPADES) {
         return "s";
      }
      else if (getSuit() == HEARTS) {
         return "h";
      }
      else if (getSuit() == DIAMONDS) {
         return "d";
      }
      else {
         return "c";
      }
   }
   
   /**
      Returns the card’s name in shorthand.
      @return The card’s name in shorthand. (e.g. "As")
   */
   public String getNameShort() {
      return getRankShort() + getSuitShort();
   }
   
   /**
      Compares the ranks of two cards.
      @param other The card to compare to.
      @return If the rank is higher than
      the other card’s: 1; if it is equal
      to other card’s: 0; if it is lower
      than other card’s: -1.
   */
   public int compareRank(Card other) {
      
      int rank2 = other.getRank();
      
      if (rank > rank2) {
         return 1;
      }
      else if (rank == rank2) {
         return 0;
      }
      else {
         return -1;
      }
   }
   
   /**
      @return The card represented as a
               String—the card’s name in shorthand.
   */
   public String toString() {
      return getNameShort();
   }
}