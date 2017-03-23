package interview;
import java.util.*;

public class Cards {
	/*
	 * public String[] rank =
	 * {"A","2","3","4","5","6","7","8","9","10","J","Q","K"}; public String[]
	 * suit = {"C","H","D","S"};
	 */
	public enum Rank {
		DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
	}

	public enum Suit {
		CLUBS, DIAMONDS, HEARTS, SPADES
	}

	public final Rank rank;
	public final Suit suit;

	private Cards(Rank r, Suit s) {
		rank = r;
		suit = s;
	}

	public String toString() {
		return rank + " of " + suit;
	}

	private static final List<Cards> deck = new ArrayList<Cards>();
	static {
		for (Rank rr : Rank.values()) {
			for (Suit suit : Suit.values()) {
				deck.add(new Cards(rr, suit));
			}
		}
	}

	public static void main(String[] args) {
		Random r =new Random();
		shuffle(deck, r);
		 for (Cards card : deck)
				System.out.println(card);
	}
	
	private static void shuffle(List<?> deck, Random r) {
		Object[] arr = deck.toArray();
		int j;
		int len = arr.length;
		Object temp;
		for (int i = len - 1; i > 0; i--) {
			j = r.nextInt(i);
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}

		// Dump array back into list
		ListIterator it = deck.listIterator();
		for (int i = 0; i < arr.length; i++) {
			it.next();
			it.set(arr[i]);
		}
	}
}
