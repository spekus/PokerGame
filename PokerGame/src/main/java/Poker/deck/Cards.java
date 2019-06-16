package Poker.deck;

import lombok.Data;

import java.util.*;

import java.util.stream.IntStream;

@Data
public class Cards {
    Collection<Suits> cardSuits = Arrays.asList(Suits.DIAMOND, Suits.HEART,Suits.DIAMOND, Suits.SPADE);
    List<Card> cardsInDeck;
    List<Card> cardsInHand;
    Random rand = new Random();

    public Cards(int lowestCard, int higherstCard){
        this.cardsInDeck = generateDeck(lowestCard, higherstCard);
        this.cardsInHand = new ArrayList<>();
    }

    private List<Card> generateDeck(int startingCard, int lastCard) {
        var returnCards = new ArrayList<Card>();
        for (Suits suit:cardSuits) {
            for(;startingCard <= lastCard; startingCard++){
                returnCards.add(new Card(startingCard, suit));
            }
            startingCard= 2;
        }
        return returnCards;
    }

    public void drawCards(int cardsToDraw) {
            IntStream.range(0, cardsToDraw)
                    .forEach(x -> moveRandomCardToHand());
    }

    private void moveRandomCardToHand(){
        Card randomCard = cardsInDeck.get(rand.nextInt(cardsInDeck.size()));
        moveCardFromDeckToHand(randomCard);
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
        cardsInHand.forEach(card -> cardsInDeck.add(card));
        cardsInHand.clear();
    }
}
