package Poker;

import Poker.deck.Card;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class CombinationChecker {
    static boolean isThisJackOrBetter(List<Card> cardsInHand) {
        return cardsInHand.stream().map(Card::getRank).anyMatch(rank -> rank >= 11);
    }

    static boolean isThisFourOfTheKind(List<Card> cardsInHand) {
        List<Integer> repetitionsForEachRank = getCountForEachRank(cardsInHand);
        return repetitionsForEachRank.contains(4);
    }

    static boolean isThisThreeOfTheKind(List<Card> cardsInHand) {
        List<Integer> repetitionsForEachRank = getCountForEachRank(cardsInHand);
        return repetitionsForEachRank.contains(3);
    }

    static boolean isThisDoublePair(List<Card> cardsInHand) {
        List<Integer> repetitionsForEachRank = getCountForEachRank(cardsInHand);
        return Collections.frequency(repetitionsForEachRank, 2) == 2;
    }

    static boolean isThisFullHouse(List<Card> cardsInHand) {
        List<Integer> repetitionsForEachRank = getCountForEachRank(cardsInHand);
        return repetitionsForEachRank.contains(2) && repetitionsForEachRank.contains(3);
    }

    private static List<Integer> getCountForEachRank(List<Card> cardsInHand) {
        Set<Integer> uniqueRanks = cardsInHand.stream().map(Card::getRank).collect(Collectors.toSet());
        List<Integer> cardValue = cardsInHand.stream().map(Card::getRank).collect(Collectors.toList());
        return uniqueRanks.stream().map(rank -> Collections.frequency(cardValue, rank)).collect(Collectors.toList());
    }

    static boolean isThisRoyalFlush(List<Card> cardsInHand) {
        return doCardsMatchSuit(cardsInHand) && areCardsRoyal(cardsInHand);
    }

    private static boolean areCardsRoyal(List<Card> cardsInHand) {
        final int ROYAL_FLUSH_VALUE = 60;
        return cardsInHand.stream().map(Card::getRank).distinct().mapToInt(x -> x).sum() == ROYAL_FLUSH_VALUE;
    }

    static boolean isThisStraightFlush(List<Card> cardsInHand) {
        return areAllCardsInARow(cardsInHand) && doCardsMatchSuit(cardsInHand);
    }

    static boolean areAllCardsInARow(List<Card> cardsInHand) {
        long CardGroupsInARow = IntStream.range(0, cardsInHand.size() - 1)
                .filter(i -> cardsInHand.get(i + 1).getRank() - cardsInHand.get(i).getRank() == 1)
                .count();
        // a bit counter intuitive, but if 5 cards are in a row, they make 4 groups of each having 2 members 1 number apart
        return CardGroupsInARow == 4;
    }

    static boolean doCardsMatchSuit(List<Card> cardsInHand) {
        return cardsInHand.stream().map(Card::getSuit).distinct().count() == 1;
    }
}
