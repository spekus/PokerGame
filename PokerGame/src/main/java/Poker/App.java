package Poker;

import Poker.deck.Card;
import Poker.deck.Cards;

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
        System.out.println("Hello Player!");
        Cards cards = new Cards(2, 14);
        cards.drawCards(FULL_HAND_SIZE);
        gameLogicLoop(cards);
    }

    private static void gameLogicLoop(Cards cards) {
        while (true) {
            cards.getCardsInHand().sort(Comparator.comparing(Card::getRank));
            System.out.println("your cards are:" + cards.getCardsInHand().toString());
            System.out.println("please pick which card do you want to replace, 0 means no card, 9 means ending game");
            int userInput = getUserInput();
            if (userInput == END_TURN) {
                userAction(cards);
                continue;
            }
            if (userInput == END_GAME) {
                break;
            }
            cards.discardCard(cards.getCardsInHand().get(userInput - 1)); // -1 used because people start calculating
            // from 1 and computer scientists from 0
        }
        System.out.println("Your final score is - " + totalPoints);
    }

    private static void userAction(Cards cards) {
        cards.drawCards(FULL_HAND_SIZE - cards.getCardsInHand().size());
        cards.getCardsInHand().sort(Comparator.comparing(Card::getRank));
        System.out.println("FINAL HAND: " + cards.getCardsInHand().toString());
        int pointsWon = getHandValue(cards.getCardsInHand());
        totalPoints = totalPoints + pointsWon - BET_SIZE;
        System.out.println(String.format("You won %s amount of points, cost of bet - %s, total points are %s",
                pointsWon, BET_SIZE, totalPoints));
        cards.shuffleDeck();
        cards.drawCards(FULL_HAND_SIZE);
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
