package Poker;

import Poker.deck.Card;
import Poker.deck.Cards;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AppTest {

    Cards allCards;

    @Before
    public void executedBeforeEach() {
        this.allCards = new Cards(2, 14);
    }

    @Test
    public void shouldCreate52Cards() {
        assertEquals(52, allCards.getCardsInDeck().size());
    }

    @Test
    public void shouldHaveNoCardInHand() {
        assertEquals(0, allCards.getCardsInHand().size());
    }

    @Test
    public void shouldHaveCorrectAmountInHandAfterTakingAdditionalCardToHand() {
        allCards.drawCards(5);
        assertEquals(5, allCards.getCardsInHand().size());
    }

    @Test
    public void shouldHaveCorrectAmountInDeckAfterTakingCardToHand() {
        allCards.drawCards(5);
        assertEquals(47, allCards.getCardsInDeck().size());
    }

    @Test
    public void shouldHaveCorrectAmountInDeckAfterDiscardingCard() {
        allCards.drawCards(5);
        Card cardFromHand = allCards.getCardsInHand().get(0);
        allCards.discardCard(cardFromHand);
        assertEquals(48, allCards.getCardsInDeck().size());
        assertEquals(4, allCards.getCardsInHand().size());
    }

    @Test
    public void shufflingDeckDoesNotLooseAnyCards() {
        allCards.drawCards(5);
        allCards.shuffleDeck();
        assertEquals(0, allCards.getCardsInHand().size());
        assertEquals(52, allCards.getCardsInDeck().size());
    }
}
