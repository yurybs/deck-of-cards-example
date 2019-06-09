package interview.demo.model;

import java.util.*;

public class Game {

    private ArrayList<Card> gameDeck = new ArrayList<>();
    private HashMap<Integer, Player> players = new HashMap<>();
    private static int playerId = 0;

    public Game() {
        //add one deck to the new game
        addDeck();
    }

    public void addDeck() {
        Deck deck = new Deck();
        ArrayList<Card> allCardsFromDeck = deck.getCards();
        gameDeck.addAll(allCardsFromDeck);
    }

    public ArrayList<Card> getGameDeck() {
        return gameDeck;
    }

    public HashMap<Integer, Player> getPlayers() {
        return players;
    }

    public TreeMap<Integer, Integer> getPlayersInARanking(){
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i=0 ; i < players.size(); i++){
            hashMap.put(players.get(i).getTotalCardsAddedValue(), players.get(i).getPlayerId());
        }

        TreeMap<Integer, Integer> ranking = new TreeMap<>();
        ranking.putAll(hashMap);
        return ranking;

    }

    public HashMap<String, Integer> howManyCardsPerSuitUndealt(){
        HashMap<String, Integer> cardsPerSuitUndealt = new HashMap<>();
        int spadesCount = 0;
        int heartsCount = 0;
        int diamondsCount = 0;
        int clubsCount = 0;

        for (Card card : gameDeck){
            switch (card.getSuit()){
                case SPADES:
                    spadesCount++;
                    break;
                case HEARTS:
                    heartsCount++;
                    break;
                case DIAMONDS:
                    diamondsCount++;
                    break;
                case CLUBS:
                    clubsCount++;
                    break;
            }
        }

        cardsPerSuitUndealt.put("Spades", spadesCount);
        cardsPerSuitUndealt.put("Hearts", heartsCount);
        cardsPerSuitUndealt.put("Diamond",diamondsCount);
        cardsPerSuitUndealt.put("Clubs", clubsCount);
        return cardsPerSuitUndealt;
    }

    public void addPlayer() {
        Player player = new Player(playerId);
        players.put(playerId, player);
        playerId++;
    }

    public void deletePlayerById(int playerIdForDeletion){
        players.remove(playerIdForDeletion);
    }

    public Player getPlayerById(int playerId){
        return players.get(playerId);
    }

    public void dealCard(int playerIdToReceiveOneCard){
        //Will give to the player the first card in the deck
        ArrayList<Card> cardDealt = new ArrayList<>();
        cardDealt.add(gameDeck.get(0));
        players.get(playerIdToReceiveOneCard).addCards(cardDealt);

        //And then the card will be removed from the deck
        gameDeck.remove(0);
    }

    public void shuffleGameDeck(){
        //1000 manual shuffles will be done by moving one card from random position to the end each time
        for (int i=0 ; i<1000 ; i++){
            int randomPosition = (int)(Math.random()*(gameDeck.size()));
            Card cardToMove = gameDeck.get(randomPosition);
            gameDeck.remove(randomPosition);
            gameDeck.add(cardToMove);
        }

    }
}
