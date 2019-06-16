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
            int n = in.nextInt();
            if (n == 0) {
                totalPoints -= BET_SIZE;
                cards.drawCards(5- cards.getCardsInHand().size());
                cards.getCardsInHand().sort(Comparator.comparing(card -> card.getRank()));
                System.out.println("FINAL HAND: " + cards.getCardsInHand().toString());
                int points = evaluateHand(cards.getCardsInHand());
                totalPoints += points;
                System.out.println(String.format("You won %s amount of points, cost of bet - %s, total points are %s", points, BET_SIZE, totalPoints));
                cards.shuffleDeck();
                cards.drawCards(5);
                continue;
            }
            if(n ==9){
                break;
            }
            cards.discardCard(cards.getCardsInHand().get(n - 1));

        }
        System.out.println("Your final score is - " + totalPoints);

    }


}
