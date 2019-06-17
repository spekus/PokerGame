package Poker;

import Poker.deck.Card;
import Poker.deck.CardDeck;

import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

import static Poker.CardEvaluator.getHandValue;

public class App {
    final static int BET_SIZE = 1;
    final static int FULL_HAND_SIZE = 5;
    final static int END_TURN = 0;
    final static int END_GAME = 9;
    static int totalPoints = 100;

    public static void main(String[] args) {
        //TODO move everything from main, use dependency injection provided by spring instead of creating objects yourself
        final int LOWEST_CARD = 2;
        final int HIGHEST_CARD = 14;
        System.out.println("Hello Player!");
        CardDeck cardDeck = new CardDeck(LOWEST_CARD, HIGHEST_CARD);
        cardDeck.drawCards(FULL_HAND_SIZE);
        gameLogicLoop(cardDeck);
    }

    private static void gameLogicLoop(CardDeck cardDeck) {
        while (true) {
            cardDeck.getCardsInHand().sort(Comparator.comparing(Card::getRank));
            System.out.println("your cardDeck are:" + cardDeck.getCardsInHand().toString());
            System.out.println("please pick which card do you want to replace, 0 means no card, 9 means ending game");
            int userInput = getUserInput();
            validate(userInput, cardDeck);
            if (userInput == END_TURN) {
                userAction(cardDeck);
                continue;
            }
            if (userInput == END_GAME) {
                break;
            }
            cardDeck.discardCard(cardDeck.getCardsInHand().get(userInput - 1)); // -1 used because people start calculating
            // from 1 and computer scientists from 0
        }
        System.out.println("Your final score is - " + totalPoints);
    }

    private static void validate(int userInput, CardDeck cardDeck) {
        //TODO validate that user pick is valid number, prompt him to pick card again if it is not
    }

    private static void userAction(CardDeck cardDeck) {
        cardDeck.drawCards(FULL_HAND_SIZE - cardDeck.getCardsInHand().size());
        cardDeck.getCardsInHand().sort(Comparator.comparing(Card::getRank));
        System.out.println("FINAL HAND: " + cardDeck.getCardsInHand().toString());
        int pointsWon = getHandValue(cardDeck.getCardsInHand());
        totalPoints = totalPoints + pointsWon - BET_SIZE;
        System.out.println(String.format("You won %s amount of points, cost of bet - %s, total points are %s",
                pointsWon, BET_SIZE, totalPoints));
        cardDeck.shuffleDeck();
        cardDeck.drawCards(FULL_HAND_SIZE);
    }

    private static int getUserInput() {
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                return in.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Please try entering valid number");
                continue;
            }
        }
    }


}
