package Poker.deck;

import lombok.Data;

@Data
public class Card {
    private Suits suit;
    private int rank;

    public Card(int rank, Suits suit) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        switch (rank) {
            case 11:
                return "Jack" + " of " + suit;
            case 12:
                return "Queen" + " of " + suit;
            case 13:
                return "King" + " of " + suit;
            case 14:
                return "Ace" + " of " + suit;
            default:
                return rank + " of " + suit;
        }
    }
}
