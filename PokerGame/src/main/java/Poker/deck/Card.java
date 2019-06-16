package Poker.deck;

import lombok.Data;

@Data
public class Card {
    private Suits suit;
    private int rank;
    public Card(int rank, Suits suit) {
        this.suit = suit;
        this.rank =rank;
    }

    @Override
    public String toString() {
        return rank + " " + suit;
    }
}
