package Poker;

import Poker.deck.Card;
import Poker.deck.Cards;
import Poker.deck.Suits;
import org.junit.Test;

import java.util.List;

import static Poker.App.evaluateHand;
import static Poker.App.isThisRoyalFlush;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);

    }

    @Test
    public void shouldCreate52Cards() {

        Cards cards = new Cards(2, 14);
        assertEquals(52, cards.getCardsInDeck().size());
    }

    @Test
    public void shouldHaveNoCardInHand() {

        Cards cards = new Cards(2, 14);
        assertEquals(0, cards.getCardsInHand().size());
    }

    @Test
    public void shouldHaveCorrectAmountInHandAfterTakingCardToHand() {

        Cards cards = new Cards(2, 14);
        cards.drawCards(5);
        assertEquals(5, cards.getCardsInHand().size());
    }

    @Test
    public void shouldHaveCorrectAmountInDeckAfterTakingCardToHand() {

        Cards cards = new Cards(2, 14);
        cards.drawCards(5);
        assertEquals(47, cards.getCardsInDeck().size());
    }

    @Test
    public void shouldHaveCorrectAmountInDeckAfterDiscardingCard() {

        Cards cards = new Cards(2, 14);
        cards.drawCards(5);
        Card cardFromHand = cards.getCardsInHand().get(0);
        cards.discardCard(cardFromHand);
        assertEquals(48, cards.getCardsInDeck().size());
        assertEquals(4, cards.getCardsInHand().size());
    }

    @Test
    public void shufflingDeckDoesNotLooseAnyCards(){
        Cards cards = new Cards(2, 14);
        cards.drawCards(5);
        cards.shuffleDeck();
        assertEquals(0, cards.getCardsInHand().size());
        assertEquals(52, cards.getCardsInDeck().size());
    }

    //---------------------------------------------------------------
    // evaluating hands

    @Test
    public void royalFlush(){
        List<Card> cards = List.of(new Card(10, Suits.HEART), new Card(11, Suits.HEART), new Card(12
                , Suits.HEART) ,new Card(13, Suits.HEART), new Card(14, Suits.HEART));
        assertEquals(800, evaluateHand(cards));
    }

    @Test
    public void royalFlush2(){
        List<Card> cards = List.of(new Card(10, Suits.DIAMOND), new Card(11, Suits.DIAMOND), new Card(12
                , Suits.DIAMOND) ,new Card(13, Suits.DIAMOND), new Card(14, Suits.DIAMOND));
        assertEquals(800, evaluateHand(cards));
    }

    @Test
    public void straightFlush2(){
        List<Card> cards = List.of(new Card(8, Suits.DIAMOND), new Card(9, Suits.DIAMOND), new Card(10
                , Suits.DIAMOND) ,new Card(11, Suits.DIAMOND), new Card(12, Suits.DIAMOND));
        assertEquals(50, evaluateHand(cards));
    }




}
