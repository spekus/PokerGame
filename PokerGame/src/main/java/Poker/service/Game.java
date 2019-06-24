package Poker.service;

import Poker.deck.Card;
import Poker.deck.CardDeck;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class Game {

    final static int FULL_HAND_SIZE = 5;
    final static int BET_SIZE = 1;
    private CardDeck cardDeck;

    public void startGame() {
        final int LOWEST_CARD = 2;
        final int HIGHEST_CARD = 14;
        this.cardDeck = new CardDeck(LOWEST_CARD, HIGHEST_CARD);
        cardDeck.drawCards(FULL_HAND_SIZE);
        cardDeck.getCardsInHand().sort(Comparator.comparing(Card::getRank));
    }

    public List<Card> drawFullHand() {
        cardDeck.drawCards(FULL_HAND_SIZE - cardDeck.getCardsInHand().size());
        return cardDeck.getCardsInHand();
    }

    public int evaluateProfitFromTurn() {
        cardDeck.getCardsInHand().sort(Comparator.comparing(Card::getRank));
        return HandEvaluatorKt.getHandValue(cardDeck.getCardsInHand()) - BET_SIZE;
    }

    //discard card from 0 to default 4
    public List<Card> discardTheCardFromHand(int cardNumber) {
        cardDeck.discardCard(cardDeck.getCardsInHand().get(cardNumber));
        return cardDeck.getCardsInHand();
    }

    public void resetDeck() {
        cardDeck.shuffleDeck();
        cardDeck.drawCards(FULL_HAND_SIZE);
    }

    public List<Card> getCardsInHand() {
        return cardDeck.getCardsInHand();
    }
}
