package interview;
import java.util.*;


public class shuffledCard {
	public enum Rank { DEUCE, THREE, FOUR, FIVE, SIX,
        SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE }

    public enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES }

    private final Rank rank;
    private final Suit suit;
    private shuffledCard(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank rank() { return rank; }
    public Suit suit() { return suit; }
    public String toString() { return rank + " of " + suit; }

    private static final List<shuffledCard> protoDeck = new ArrayList<shuffledCard>();

    // Initialize prototype deck
    static {
        for (Suit suit : Suit.values())
            for (Rank rank : Rank.values())
                protoDeck.add(new shuffledCard(rank, suit));
    }

    public static ArrayList<shuffledCard> newDeck() {
        return new ArrayList<shuffledCard>(protoDeck); // Return copy of prototype deck
    }
    
	public static void main(String[] args) {

		List<shuffledCard> cards = newDeck();

		Collections.shuffle(cards);
		for (shuffledCard card : cards)
			System.out.println(card);

	}
}
