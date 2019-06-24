package Poker.deck;

import Poker.deck.Card;
import Poker.enums.Suits;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
public class CardDeck {

    /**
     * TODO this class should be part of Deck interface, this particular implementation would be for standard deck
     * which has no jacks and 4 colors, maybe some other card games use other kind of setups.
     */

    List<Card> cardsInDeck;
    List<Card> cardsInHand;
    Random rand = new Random();

    public CardDeck(int lowestCard, int highestCard) {
        this.cardsInDeck = generateFullDeck(lowestCard, highestCard);
        this.cardsInHand = new ArrayList<>();
    }

    private List<Card> generateFullDeck(int startingCard, int lastCard) {
        return Arrays.stream(Suits.values())
                .map(suit -> generateFullSuit(startingCard, lastCard, suit))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private List<Card> generateFullSuit(int startingCard, int lastCard, Suits suit) {
        return IntStream.rangeClosed(startingCard, lastCard)
                .mapToObj(x -> new Card(x, suit))
                .collect(Collectors.toList());
    }

    public void drawCards(int cardsToDraw) {
        IntStream.range(0, cardsToDraw)
                .mapToObj(drawRequest -> getRandomCardFromDeck())
                .forEach(this::moveCardFromDeckToHand);
    }

    private Card getRandomCardFromDeck() {
        return cardsInDeck.get(rand.nextInt(cardsInDeck.size()));
    }

    private void moveCardFromDeckToHand(Card cardToDraw) {
        cardsInDeck.remove(cardToDraw);
        cardsInHand.add(cardToDraw);
    }

    public void discardCard(Card cardToDiscardFromHand) {
        cardsInHand.remove(cardToDiscardFromHand);
        cardsInDeck.add(cardToDiscardFromHand);
    }

    public void shuffleDeck() {
        cardsInDeck.addAll(cardsInHand);
        cardsInHand.clear();
    }
}
