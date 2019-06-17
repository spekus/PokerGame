package Poker.deck;

import Poker.enums.Suits;
import lombok.Data;

import java.util.*;

import java.util.stream.IntStream;

@Data
public class CardDeck {

    /**
     * TODO this class should be part of Deck interface, this particular implementation would be for standard deck
     * which has no jacks and 4 colors, maybe some other card games use other kind of setups.
     */

    Collection<Suits> cardSuits = Arrays.asList(Suits.DIAMOND, Suits.HEART,Suits.DIAMOND, Suits.SPADE);
    List<Card> cardsInDeck;
    List<Card> cardsInHand;
    Random rand = new Random();

    public CardDeck(int lowestCard, int highestCard){
        this.cardsInDeck = generateDeck(lowestCard, highestCard);
        this.cardsInHand = new ArrayList<>();
    }

    private List<Card> generateDeck(int startingCard, int lastCard) {
        var deck = new ArrayList<Card>();
        for (Suits suit:cardSuits) {
            int counter = startingCard;
            for(;counter <= lastCard; counter++){
                deck.add(new Card(counter, suit));
            }
        }
        return deck;
    }

    public void drawCards(int cardsToDraw) {
            IntStream.range(0, cardsToDraw)
                    .mapToObj(drawRequest -> getRandomCardFromDeck())
                    .forEach(this::moveCardFromDeckToHand);
    }

    private Card getRandomCardFromDeck(){
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
