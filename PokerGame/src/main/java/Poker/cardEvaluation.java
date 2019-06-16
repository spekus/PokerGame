package Poker;

import Poker.deck.Card;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class cardEvaluation {
    public static int evaluateHand(List<Card> cardsInHand) {
        if (isThisRoyalFlush(cardsInHand)) {
            return 800;
        } else if (isThisStraightFlush(cardsInHand)) {
            return 50;
        } else if (isThisFourOfTheKind(cardsInHand)) {
            return 25;
        } else if (isThisFullHouse(cardsInHand)) {
            return 9;
        } else if (doCardsMatchSuit(cardsInHand)) { //checks for flush
            return 6;
        } else if (areAllCardsInARow(cardsInHand)) { //checks for straight
            return 4;
        } else if (isThisThreeOfTheKind(cardsInHand)) {
            return 3;
        } else if (isThisDoublePair(cardsInHand)) {
            return 2;
        } else if (isThisJackOrBetter(cardsInHand)) {
            return 1;
        }

        return 0;
    }

    private static boolean isThisJackOrBetter(List<Card> cardsInHand) {
        return cardsInHand.stream().map(card->card.getRank()).anyMatch(rank-> rank >= 11);
    }


    private static boolean isThisFourOfTheKind(List<Card> cardsInHand) {
        Set<Integer> uniqueRanks = cardsInHand.stream().map(Card::getRank).collect(Collectors.toSet());
        List<Integer> cardValue = cardsInHand.stream().map(Card::getRank).collect(Collectors.toList());
        List<Integer> counts =
                uniqueRanks.stream().map(rank -> Collections.frequency(cardValue, rank)).collect(Collectors.toList());
        return counts.contains(4);
    }

    private static boolean isThisThreeOfTheKind(List<Card> cardsInHand) {
        Set<Integer> uniqueRanks = cardsInHand.stream().map(Card::getRank).collect(Collectors.toSet());
        List<Integer> cardValue = cardsInHand.stream().map(Card::getRank).collect(Collectors.toList());
        List<Integer> numberOfDuplicatesForEachRank =
                uniqueRanks.stream().map(rank -> Collections.frequency(cardValue, rank)).collect(Collectors.toList());
        return numberOfDuplicatesForEachRank.contains(3);
    }


    private static boolean isThisDoublePair(List<Card> cardsInHand) {
        Set<Integer> uniqueRanks = cardsInHand.stream().map(Card::getRank).collect(Collectors.toSet());
        List<Integer> cardValue = cardsInHand.stream().map(Card::getRank).collect(Collectors.toList());
        List<Integer> numberOfDuplicatesForEachRank =
                uniqueRanks.stream().map(rank -> Collections.frequency(cardValue, rank)).collect(Collectors.toList());
        return Collections.frequency(numberOfDuplicatesForEachRank, 2) == 2;
    }

    private static boolean isThisFullHouse(List<Card> cardsInHand) {
        Set<Integer> uniqueRanks = cardsInHand.stream().map(Card::getRank).collect(Collectors.toSet());
        List<Integer> cardValue = cardsInHand.stream().map(Card::getRank).collect(Collectors.toList());
        List<Integer> counts =
                uniqueRanks.stream().map(rank -> Collections.frequency(cardValue, rank)).collect(Collectors.toList());
        return counts.contains(2) && counts.contains(3);
    }

    private static boolean isThisStraightFlush(List<Card> cardsInHand) {
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
