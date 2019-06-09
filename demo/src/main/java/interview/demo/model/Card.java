package interview.demo.model;

public class Card {

    private Suits suit;
    private Ranks rank;

    enum Suits{
        SPADES, HEARTS, DIAMONDS, CLUBS;
    }

    enum Ranks{
        ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13);
        private int value;

        public int getValue(){
            return this.value;
        }

        Ranks(int i) {
            this.value = i;
        }
    }

    public Card(Suits suit, Ranks rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suits getSuit() {
        return suit;
    }

    public Ranks getRank() {
        return rank;
    }
}
