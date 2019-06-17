package Poker;

import Poker.deck.Card;
import Poker.deck.CardDeck;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardDeckTest {

    CardDeck allCardDeck;

    @Before
    public void executedBeforeEach() {
        this.allCardDeck = new CardDeck(2, 14);
    }

    @Test
    public void shouldCreate52Cards() {
        assertEquals(52, allCardDeck.getCardsInDeck().size());
    }

    @Test
    public void shouldHaveNoCardInHand() {
        assertEquals(0, allCardDeck.getCardsInHand().size());
    }

    @Test
    public void shouldHaveCorrectAmountInHandAfterTakingAdditionalCardToHand() {
        allCardDeck.drawCards(5);
        assertEquals(5, allCardDeck.getCardsInHand().size());
    }

    @Test
    public void shouldHaveCorrectAmountInDeckAfterTakingCardToHand() {
        allCardDeck.drawCards(5);
        assertEquals(47, allCardDeck.getCardsInDeck().size());
    }

    @Test
    public void shouldHaveCorrectAmountInDeckAfterDiscardingCard() {
        allCardDeck.drawCards(5);
        Card cardFromHand = allCardDeck.getCardsInHand().get(0);
        allCardDeck.discardCard(cardFromHand);
        assertEquals(48, allCardDeck.getCardsInDeck().size());
        assertEquals(4, allCardDeck.getCardsInHand().size());
    }

    @Test
    public void shufflingDeckDoesNotLooseAnyCards() {
        allCardDeck.drawCards(5);
        allCardDeck.shuffleDeck();
        assertEquals(0, allCardDeck.getCardsInHand().size());
        assertEquals(52, allCardDeck.getCardsInDeck().size());
    }
}
