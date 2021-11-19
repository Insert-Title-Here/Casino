
import java.util.*;

public class CardListClass {

	public Set<Card> cardList;

	public CardListClass(boolean deckCards) {

		cardList = new HashSet<Card>();

		if (deckCards) {
			cardStarter();
		}

	}

	public void cardStarter() { // gets all cards and adds them into array.

		for (int i = 1; i <= 4; i++) {

			for (int j = 1; j <= 13; j++) {
				String number;

				if (j == 1) {
					number = "Ace";

				} else if (j == 11) {
					number = "Jack";

				} else if (j == 12) {
					number = "Queen";

				} else if (j == 13) {
					number = "King";

				} else {
					number = j + "";
				}

				if (i == 1) {
					cardList.add(new Card("Clubs", number));

				} else if (i == 2) {
					cardList.add(new Card("Diamonds", number));

				} else if (i == 3) {
					cardList.add(new Card("Hearts", number));

				} else if (i == 4) {
					cardList.add(new Card("Spades", number));

				}

				//shuffleDeck();

			}
		}
	}

	public void printcardList() {

		/*
		 * for(int i = 0; i < cardList.size(); i++){
		 * System.out.println(cardList.get(i).getName() + " of " +
		 * cardList.get(i).getSuit()); }
		 */

		for (Card current : cardList) {
			System.out.println(current.getName() + " of " + current.getSuit());
		}
	}

	public void shuffleDeck() {

		// Collections.shuffle(cardList);
	}

	public void giveCards(int amtCards, CardListClass deck) {

		for (int i = 0; i < amtCards; i++) {

			int size = deck.cardList.size();
			int item = new Random().nextInt(size); // In real life, the Random object should be rather more shared than
													// this
			int j = 0;
			for (Card current : deck.cardList) {
				if (j == item)
					cardList.add(current);
				j++;
			}
		}

		// cardList.add(deck.);
	}
	
	public Card[] convertToArray() {
		Card[] cardArray = new Card[cardList.size()];
		int i = 0;
		for(Card current: cardList) {
			cardArray[i] = current;
			i++;
		}
		
		return cardArray;
	}

	public int getSize() {
		return cardList.size();
	}

	/*
	public Card getCard(int i) {
		return cardList.get(i);
	}


	

	
	*/

}
