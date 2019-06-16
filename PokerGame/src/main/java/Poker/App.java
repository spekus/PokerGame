package Poker;

import Poker.deck.Card;
import Poker.deck.Cards;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static Poker.cardEvaluation.evaluateHand;

/**
 * Hello world!
 */
public class App {
    static int totalPoints = 100;
    final static int BET_SIZE = 1;
    final static int FULL_HAND_SIZE =5;
    final static int END_TURN =0;
    final static int END_GAME =9;

    public static void main(String[] args) {
        System.out.println("Hello Player!");
        Cards cards = new Cards(2, 14);
        cards.drawCards(5);
        gameLogicLoop(cards);
    }

    private static void gameLogicLoop(Cards cards) {
        while (true) {
            cards.getCardsInHand().sort(Comparator.comparing(card -> card.getRank()));
            System.out.println("your cards are:" + cards.getCardsInHand().toString());
            System.out.println("please pick which card do you want to replace, 0 means no card, 9 means ending game");
            Scanner in = new Scanner(System.in);
            int userInput = in.nextInt();
            if (userInput == END_TURN) {
                cards.drawCards(FULL_HAND_SIZE- cards.getCardsInHand().size());
                cards.getCardsInHand().sort(Comparator.comparing(card -> card.getRank()));
                System.out.println("FINAL HAND: " + cards.getCardsInHand().toString());
                int pointsReceived = evaluateHand(cards.getCardsInHand());
                totalPoints = totalPoints + pointsReceived - BET_SIZE;
                System.out.println(String.format("You won %s amount of points, cost of bet - %s, total points are %s", pointsReceived, BET_SIZE, totalPoints));
                cards.shuffleDeck();
                cards.drawCards(FULL_HAND_SIZE);
                continue;
            }
            if(userInput ==END_GAME){
                break;
            }
            cards.discardCard(cards.getCardsInHand().get(userInput - 1)); // -1 used because people start calculating from 1 and computer scientists from 0
        }
        System.out.println("Your final score is - " + totalPoints);
    }


}
