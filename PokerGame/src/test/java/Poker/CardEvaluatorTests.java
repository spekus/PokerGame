package Poker;

import Poker.deck.Card;
import Poker.deck.Suits;
import org.junit.Test;

import java.util.List;

import static Poker.CardEvaluator.getHandValue;
import static org.junit.Assert.assertEquals;

public class CardEvaluatorTests {

    @Test
    public void royalFlush() {
        List<Card> cards = List.of(new Card(10, Suits.HEART), new Card(11, Suits.HEART), new Card(12
                , Suits.HEART), new Card(13, Suits.HEART), new Card(14, Suits.HEART));
        assertEquals(800, getHandValue(cards));
    }

    @Test
    public void royalFlush2() {
        List<Card> cards = List.of(new Card(10, Suits.DIAMOND), new Card(11, Suits.DIAMOND), new Card(12
                , Suits.DIAMOND), new Card(13, Suits.DIAMOND), new Card(14, Suits.DIAMOND));
        assertEquals(800, getHandValue(cards));
    }

    @Test
    public void straightFlush2() {
        List<Card> cards = List.of(new Card(8, Suits.DIAMOND), new Card(9, Suits.DIAMOND), new Card(10
                , Suits.DIAMOND), new Card(11, Suits.DIAMOND), new Card(12, Suits.DIAMOND));
        assertEquals(50, getHandValue(cards));
    }

    @Test
    public void flush() {
        List<Card> cards = List.of(new Card(4, Suits.DIAMOND), new Card(6, Suits.DIAMOND), new Card(10
                , Suits.DIAMOND), new Card(11, Suits.DIAMOND), new Card(12, Suits.DIAMOND));
        assertEquals(6, getHandValue(cards));
    }

    @Test
    public void straight() {
        List<Card> cards = List.of(new Card(4, Suits.HEART), new Card(5, Suits.DIAMOND), new Card(6
                , Suits.DIAMOND), new Card(7, Suits.DIAMOND), new Card(8, Suits.DIAMOND));
        assertEquals(4, getHandValue(cards));
    }

    @Test
    public void fourOfTheKind() {
        List<Card> cards = List.of(new Card(8, Suits.DIAMOND), new Card(8, Suits.HEART), new Card(8
                , Suits.DIAMOND), new Card(8, Suits.DIAMOND), new Card(12, Suits.DIAMOND));
        assertEquals(25, getHandValue(cards));
    }

    @Test
    public void fullHouse() {
        List<Card> cards = List.of(new Card(8, Suits.DIAMOND), new Card(8, Suits.HEART), new Card(8
                , Suits.DIAMOND), new Card(12, Suits.DIAMOND), new Card(12, Suits.DIAMOND));
        assertEquals(9, getHandValue(cards));
    }

    @Test
    public void threeOfTheKind() {
        List<Card> cards = List.of(new Card(8, Suits.DIAMOND), new Card(8, Suits.HEART), new Card(8
                , Suits.DIAMOND), new Card(11, Suits.DIAMOND), new Card(12, Suits.DIAMOND));
        assertEquals(3, getHandValue(cards));
    }

    @Test
    public void twoPairs() {
        List<Card> cards = List.of(new Card(3, Suits.DIAMOND), new Card(8, Suits.HEART), new Card(8
                , Suits.DIAMOND), new Card(12, Suits.DIAMOND), new Card(12, Suits.DIAMOND));
        assertEquals(2, getHandValue(cards));
    }

    @Test
    public void jackOrHigher() {
        List<Card> cards = List.of(new Card(3, Suits.DIAMOND), new Card(8, Suits.HEART), new Card(8
                , Suits.DIAMOND), new Card(2, Suits.DIAMOND), new Card(11, Suits.DIAMOND));
        assertEquals(1, getHandValue(cards));
    }


    @Test
    public void onePairReturnZero() {
        List<Card> cards = List.of(new Card(8, Suits.DIAMOND), new Card(8, Suits.HEART), new Card(2
                , Suits.DIAMOND), new Card(3, Suits.DIAMOND), new Card(4, Suits.DIAMOND));
        assertEquals(0, getHandValue(cards));
    }
}
