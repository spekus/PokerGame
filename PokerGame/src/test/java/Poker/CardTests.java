package Poker;

import Poker.deck.Card;
import Poker.deck.CardDeck;
import Poker.enums.Suits;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CardTests {

    CardDeck allCardDeck;

    @Before
    public void executedBeforeEach() {
        this.allCardDeck = new CardDeck(2, 14);
    }

    @Test
    public void jackReturnsExpectedStringValue(){
        List<Card> cards = List.of(new Card(11, Suits.DIAMOND));
        assertEquals(cards.get(0).toString(), "Jack of DIAMOND");
    }

    @Test
    public void queenReturnsExpectedStringValue(){
        List<Card> cards = List.of(new Card(12, Suits.DIAMOND));
        assertEquals(cards.get(0).toString(), "Queen of DIAMOND");
    }

    @Test
    public void kingReturnsExpectedStringValue(){
        List<Card> cards = List.of(new Card(13
                , Suits.DIAMOND), new Card(14, Suits.DIAMOND));
        assertEquals(cards.get(0).toString(), "King of DIAMOND");
    }

    @Test
    public void aceReturnsExpectedStringValue(){
        List<Card> cards = List.of(new Card(14, Suits.DIAMOND));
        assertEquals(cards.get(0).toString(), "Ace of DIAMOND");
    }
}
