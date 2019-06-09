package interview.demo.model;

import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();
        for (Card.Suits suit : Card.Suits.values()){
            for (Card.Ranks rank : Card.Ranks.values()){
                cards.add(new Card(suit, rank));
            }
        }
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}
