package Poker.service

import Poker.deck.Card

fun getHandValue(cardsInHand: List<Card>): Int {
    return when {
        CombinationChecker.isThisRoyalFlush(cardsInHand) -> 800
        CombinationChecker.isThisStraightFlush(cardsInHand) -> 50
        CombinationChecker.isThisFourOfTheKind(cardsInHand) -> 25
        CombinationChecker.isThisFullHouse(cardsInHand) -> 9
        CombinationChecker.doCardsMatchSuit(cardsInHand) -> 6
        CombinationChecker.areAllCardsInARow(cardsInHand) -> 4
        CombinationChecker.isThisThreeOfTheKind(cardsInHand) -> 3
        CombinationChecker.isThisDoublePair(cardsInHand) -> 2
        CombinationChecker.isThisJackOrBetter(cardsInHand) -> 1
        else -> 0
    }
}