/**
   Represents a standard French playing card (aces high).
   @author J.P. O’Malley
*/

public class Card {

   // Define class constants
   public static int ACE = 14,
                     KING = 13,
                     QUEEN = 12,
                     JACK = 11,
                     SPADES = 0,
                     HEARTS = 1,
                     DIAMONDS = 2,
                     CLUBS = 3,
                     MIN_RANK = 2,
                     MAX_RANK = 14,
                     NUM_SUITS = 4,
                     /** The default rank. */
                     DEF_RANK = ACE,
                     /** The default suit. */
                     DEF_SUIT = SPADES;
   
   // Define fields
   private int rank,
               suit;
   
   // Constructors
   /** Creates a default card—an ace of spades. */
   public Card() {
      rank = DEF_RANK;
      
      suit = DEF_SUIT;
   }
   
   /**
      Creates a card with the rank and suit given.
      @param rank The card’s rank. (If an invalid value is given,
                  the rank will default to an ace.)
      @param suit The card’s suit. (If an invalid value is given,
                  the suit will default to spades.)
   */
   public Card(int rank, int suit) {
      
      if (MIN_RANK <= rank && rank <= MAX_RANK) {
         this.rank = rank;
      }
      else {
         this.rank = DEF_RANK;
      }
      
      if (0 <= suit && suit <= NUM_SUITS) {
         this.suit = suit;
      }
      else {
         this.suit = DEF_SUIT;
      }
   }
   
   // Methods
   
   /**
      Returns the rank as an interger value.
      @returns The card’s rank as an interger.
   */
   public int getRank() {
      return rank;
   }
   
   /**
      Returns the suit as an interger value.
      @returns The card’s suit represented by an interger.
   */
   public int getSuit() {
      return suit;
   }
   
   /**
      Returns the card’s rank name.
      @returns The card’s rank.
   */
   /*public String getRankName() {
      
      if (suit == ACE) {
   */
   
   /**
      @return The rank in shorthand. 
   */
   public String getRankShort(){
      
      if (getRank() == ACE) {
         return "A";
      }
      else if (getRank() == KING) {
         return "K";
      }
      else if (getRank() == QUEEN) {
         return "Q";
      }
      else if (getRank() == JACK) {
         return "J";
      }
      else {
         return "" + rank;
      }
   }
   
   /**
      @return The suit in shorthand.
   */
   public String getSuitShort() {
      
      if (getSuit() == SPADES) {
         return "♠";
      }
      else if (getSuit() == HEARTS) {
         return "♥";
      }
      else if (getSuit() == DIAMONDS) {
         return "♦";
      }
      else {
         return "♣";
      }
   }
   
   /**
      @return The card’s name in shorthand.
   */
   public String getNameShort() {
      return getRankShort() + getSuitShort();
   }
   
   /**
      @returns The card represented as a
               String—the card’s name in shorthand.
   */
   public String toString() {
      return getNameShort();
   }
   
   public static void main(String[] args) {
      Card myCard = new Card(4, Card.SPADES);
      System.out.println(myCard);
   }
}