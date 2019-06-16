package Poker;

import Poker.deck.Card;
import Poker.deck.Cards;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        System.out.println("Hello World!");
        Cards cards = new Cards(2, 14);
        cards.drawCards(5);
        gameLogicLoop(cards);

    }

    private static void gameLogicLoop(Cards cards) {
        while (true) {
            cards.getCardsInHand().sort(Comparator.comparing(card -> card.getRank()));
            System.out.println("your cards are:" + cards.getCardsInHand().toString());
            System.out.println("please pick which card do you want to replace, 0 means no card");
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            if (n == 0) {
                int points = evaluateHand(cards.getCardsInHand());
                cards.shuffleDeck();
                cards.drawCards(5);
                continue;
            }
            cards.discardCard(cards.getCardsInHand().get(n - 1));

        }

    }

    public static int evaluateHand(List<Card> cardsInHand) {
        if (isThisRoyalFlush(cardsInHand)) {
            return 800;
        } else if (isThisFlush(cardsInHand)) {
            return 50;
        } else if (isThisPair(cardsInHand)) {
             return 2;
        }

        return 0;


    }

    private static boolean isThisPair(List<Card> cardsInHand) {
        // count the frequency of the word "code"
        Set<Integer> uniqueRanks = cardsInHand.stream().map(Card::getRank).collect(Collectors.toSet());
        List<Integer> cardValue = cardsInHand.stream().map(Card::getRank).collect(Collectors.toList());
        List<Integer> counts = uniqueRanks.stream().map(rank -> Collections.frequency(cardValue, rank)).collect(Collectors.toList();
        if(counts.contains(2)){
            return true;
        }
        return false;
    }

    private static boolean isThisFlush(List<Card> cardsInHand) {
        return areAllCardsInARow(cardsInHand) && doCardsMatchSuit(cardsInHand);
    }


    public static boolean isThisRoyalFlush(List<Card> cardsInHand) {
        return doCardsMatchSuit(cardsInHand) && areCardsRoyal(cardsInHand);
    }


    private static boolean areCardsRoyal(List<Card> cardsInHand) {
//        14+13+12+11+10 =60;
        final int FLUSH_VALUE = 60;
        return cardsInHand.stream().map(card -> card.getRank()).distinct().mapToInt(x -> x).sum() == FLUSH_VALUE;
    }

    private static boolean areAllCardsInARow(List<Card> cardsInHand) {
        long CardGroupsInARow = IntStream.range(0, cardsInHand.size() - 1)
                .filter(i -> cardsInHand.get(i + 1).getRank() - cardsInHand.get(i).getRank() == 1)
                .count();
        // a bit counter intuitive, but if 5 cards are in a row, they consist of 4 groups
        return CardGroupsInARow == 4;
    }

    public static boolean doCardsMatchSuit(List<Card> cardsInHand) {
        return cardsInHand.stream().map(card -> card.getSuit()).distinct().count() == 1;
    }


}
