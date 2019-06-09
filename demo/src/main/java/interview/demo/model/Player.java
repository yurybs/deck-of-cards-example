package interview.demo.model;

import java.util.ArrayList;

public class Player {

    private ArrayList<Card> cards = new ArrayList<>();
    private int totalCardsAddedValue;
    private int playerId = 0;

    public Player(int playerId) {
        this.playerId = playerId;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public int getTotalCardsAddedValue() {
        totalCardsAddedValue = 0;
        for (Card card : cards){
            totalCardsAddedValue += card.getRank().getValue();
        }
        return totalCardsAddedValue;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void addCards(ArrayList<Card> cardsToAdd) {
        cards.addAll(cardsToAdd);
    }
}
