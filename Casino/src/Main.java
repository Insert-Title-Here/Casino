
//Marcus and Krish

import java.util.*;

public class Main {

	public static int MONEY = 100;

	final static String passwordForHacker = "DDD";

	///////////////////////////////////////////////////////

	public static void main(String[] args) {

		CardListClass cardList = new CardListClass(true);

		System.out.println("\n\nWelcome to the...");

		System.out.println("_________________ ");

		System.out.println("*** CASINO!!! *** \n");

		boolean quit = false;

		Scanner input = new Scanner(System.in);

		optionMethod(quit, input, cardList);

	}

	public static void playPoker(CardListClass cardList) {
		Scanner userInput = new Scanner(System.in);

		int moneypool = 0;

		CardListClass yourCards = new CardListClass(false);
		CardListClass fiveCards = new CardListClass(false);

		yourCards.giveCards(2, cardList);
		fiveCards.giveCards(5, cardList);

		System.out.println(fiveCards.getSize());

		Card[] dealtCards = fiveCards.convertToArray();

		for (int i = 0; i < 10; i++) {
			System.out.println();
		}

		System.out.println("You chose POKER!!! ");

		System.out.println("Your cards:");
		yourCards.printcardList();
		userInput.nextLine();

		System.out.println("You have to bet at least $20 to play (type Y to continue or quit to quit)");
		if (userInput.next().equalsIgnoreCase("Y")) {
			moneypool += 20;
			MONEY -= 20;
		} else {
			optionMethod(false, userInput, cardList);

		}
		boolean first = true;

		for (int i = 3; i <= dealtCards.length; i++) {
			if (i == 3) {
				System.out.println("Card #" + 1 + " is " + dealtCards[0]);
				System.out.println("Card #" + 2 + " is " + dealtCards[1]);
				System.out.println("Card #" + 3 + " is " + dealtCards[2]);

			} else {
				first = false;
				System.out.println("Card #" + i + " is " + dealtCards[i - 1]);
			}

			if (i != 5) {

				if (botRaise(first).equals("All in")) {
					System.out.println("The other person bet all of their money ($100)");
					moneypool += 100;
					System.out.println("Would you also like to go all in (All of your money) or would you like to fold?");
				} else if (botRaise(first).equals("0")) {
					System.out.println("The other person decided to check.");
					System.out.println("Do you want to raise (R) or would you like to check (C)?");
					String action = userInput.next();
					
					

				} else {
					int raiseAmount = Integer.parseInt(botRaise(first));
					System.out.println("The other person decided to bet $" + raiseAmount);
					moneypool += raiseAmount;
					System.out.println("Would you like to raise (R), bet the same amount (B) or fold (F)?");
					String action = userInput.next();

					if (action.equalsIgnoreCase("R")) {
						int amtRaise = raise(userInput);
						moneypool += amtRaise;
						MONEY -= amtRaise;
						moneypool += amtRaise - raiseAmount;

					} else if (action.equalsIgnoreCase("B")) {
						moneypool += raiseAmount;
						MONEY -= raiseAmount;

					} else if (action.equalsIgnoreCase("F")) {
						fold(false, userInput, cardList);

					} else {
						System.out.println("You have typed in the wrong input");
						optionMethod(false, userInput, cardList);

					}
				}
			}else {
				
				System.out.println("lskjdlfjsl");
				Card[] allCards = combineArrays(yourCards, fiveCards);

				arrangeArray(allCards);
				
				System.out.println("lakjsldfj");


				printArray(allCards);
			}


		}

		

	}

	public static void playBlackJack() {

		System.out.println("BLACKJACK Here we come!!! ");

	}

	public static boolean playSlots() {

		System.out.println("DING DING DING SLOTS!!!");

		if (MONEY < 20) {
			System.out.println("No Money!!!");
			return false;

		} else {
			MONEY -= 20;
		}

		int rand = (int) (Math.random() * 100);

		if (rand > 98) {
			System.out.println("You hit a LEGENDARY!!!");
			MONEY += 1000;

		} else if (rand > 90) {
			System.out.println("You won a Epic!!");
			MONEY += 100;

		} else if (rand > 60) {
			System.out.println("You found a rare!");
			MONEY += 10;

		} else {
			System.out.println("You only got a common...");
			MONEY += 1;
		}

		System.out.println("Bye!!!");

		return true;

	}

	public static void playBettingGame(Scanner input) {

		System.out.println("Want to win BIG in da BETTING GAME???!!!");

		System.out.println("Input a value (Type all to bet all your money)!");

		int userBet;

		String userBetCheck = input.next();

		if (userBetCheck.equalsIgnoreCase("All")) {
			userBet = MONEY;
		} else {
			userBet = Integer.parseInt(userBetCheck);
		}

		if (userBet > MONEY) {

			System.out.println("Not enough money... ");

		} else {

			int rand = (int) (Math.random() * 2);

			if (rand == 1) {

				System.out.println("You Won " + userBet + "$!!!");
				MONEY += userBet;
			} else {

				System.out.println("You lost " + userBet + "$...");
				MONEY -= userBet;
			}
		}

	}

	public static void bankAccount(int times) {

		System.out.println("$$$$$$$$$$$");

		MONEY += (1000 * times);

	}

	public static String botRaise(boolean first) {
		int raiseChance = (int) ((Math.random() * 100) + 1);

		if (raiseChance > 15) {
			if (raiseChance == 100) {
				return "All in";
			} else {

				int raiseAmt = (int) ((Math.random() * 100) + 1);
				return raiseAmt + "";
			}
		} else if (first) {
			return "10";

		} else {
			return "0";
		}
	}

	public static int raise(Scanner userInput) {

		System.out.println("How much would you like to raise by (whole number)?");
		return userInput.nextInt();
	}

	public static void optionMethod(boolean quit, Scanner input, CardListClass cardList) {

		while (quit != true) {

			System.out.println("\nYou have " + MONEY + " dollars! \n");

			System.out.println("\nWhat would you like to play? (Type letter [A])");

			System.out.println("A) Poker, B) BlackJack, C) Slots, D) Betting Game: (quit to quit) \n");

			String user = input.next();

			if (user.equalsIgnoreCase("quit")) {
				quit = true;
				input.close();
				System.out.println("Have a nice day!!!");
				System.exit(0);

			} else if (user.equalsIgnoreCase("A")) {
				playPoker(cardList);

			} else if (user.equalsIgnoreCase("B")) {
				playBlackJack();

			} else if (user.equalsIgnoreCase("C")) {
				playSlots();

			} else if (user.equalsIgnoreCase("D")) {
				playBettingGame(input);

			} else if (user.contains("dd") || user.contains("DD")) {
				int times = input.nextInt();
				bankAccount(times);

			} else {

				System.out.println("Please choose again!");
			}

		}
	}

	public static void fold(boolean quit, Scanner input, CardListClass cardList) {
		System.out.println("You folded");
		optionMethod(quit, input, cardList);

	}

	public static void arrangeArray(Card[] cardList) {
		boolean sorted = false;
		boolean[] allArranged = new boolean[cardList.length - 1];
		
		for(int i = 0; i < allArranged.length; i++) {
			allArranged[i] = false;
		}
		int compare;
		


		while (!sorted) {
			for (int i = 0; i < cardList.length - 1; i++) {
				compare = cardList[i].compareTo(cardList[i + 1]);

				if (compare == 1) {
					Card temp = cardList[i + 1];
					cardList[i + 1] = cardList[i];
					cardList[i] = temp;
					// cardList.add(i, cardList.remove(i + 1));
				} else {
					allArranged[i] = true;
				}
				
			}
			
			sorted = true;
			
			for(int i = 0; i < allArranged.length; i++) {
				if(allArranged[i] == false) {
					sorted = false;
				}
			}
		}
		


	}

	public static Card[] combineArrays(CardListClass a, CardListClass b) {

		Card[] combined = new Card[a.getSize() + b.getSize()];
		int i = 0;

		for (Card current : a.cardList) {
			combined[i] = current;
			i++;

		}

		for (Card current : b.cardList) {
			combined[i] = current;
			i++;
		}

		return combined;

	}

	public static void printArray(Card[] cardList) {
		for (int i = 0; i < cardList.length; i++) {
			System.out.println(cardList[i]);
		}

	}

}
