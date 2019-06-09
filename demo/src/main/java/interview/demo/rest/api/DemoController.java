package interview.demo.rest.api;

import interview.demo.DemoApplication;
import interview.demo.model.Card;
import interview.demo.model.Deck;
import interview.demo.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    DemoApplication application;

    @RequestMapping(value = "", method = GET)
    public String welcome(){
        return "Welcome :)";
    }

    @RequestMapping(value = "/deck", method = GET)
    public Deck createDeck(){
        return new Deck();
    }

    @RequestMapping(value = "/games", method = POST)
    public String createGame(){
        application.addToGamesRunning();
        return "New Game Created";
    }

    @RequestMapping(value = "/games/{gameid}/deck", method = POST)
    public String addDeckToGame(@PathVariable("gameid") int gameid) {
        application.getGamesRunning().get(gameid).addDeck();
        return "New deck added to game gameID " + gameid;
    }

    @RequestMapping(value = "/games/{gameid}/deck/shuffle", method = PATCH)
    public String shuffleGameDeck(@PathVariable("gameid") int gameid) {
        application.getGamesRunning().get(gameid).shuffleGameDeck();
        return "Deck was shuffled for gameID " + gameid;
    }

    @RequestMapping(value = "/games/{gameid}", method = DELETE)
    public String deleteGame(@PathVariable("gameid") int gameid) {
        application.deleteGameById(gameid);
        return "Game deleted. gameID " + gameid;
    }

    @RequestMapping(value = "/games/{gameid}/players", method = POST)
    public String addPlayerToGame(@PathVariable("gameid") int gameid) {
        application.getGamesRunning().get(gameid).addPlayer();
        return "Player added to game gameID " + gameid;
    }

    @RequestMapping(value = "/games/{gameid}/players", method = GET)
    public HashMap<Integer, Player> getFullListOfAllPlayersInAGame(@PathVariable("gameid") int gameid) {
        HashMap<Integer, Player> integerPlayerHashMap = application.getGamesRunning().get(gameid).getPlayers();
        return integerPlayerHashMap;
    }

    @RequestMapping(value = "/games/{gameid}/players/ranking", method = GET)
    public TreeMap<Integer, Integer> getListOfAllPlayersInAGameInARanking(@PathVariable("gameid") int gameid) {
        TreeMap<Integer, Integer> playersInARanking = application.getGamesRunning().get(gameid).getPlayersInARanking();
        return playersInARanking;
    }

    @RequestMapping(value = "/games/{gameid}/cards/undealt", method = GET)
    public HashMap<String, Integer> cardsPerSuitUndealt(@PathVariable("gameid") int gameid) {
        HashMap<String, Integer> cardsPerSuitUndealt = application.getGamesRunning().get(gameid).howManyCardsPerSuitUndealt();
        return cardsPerSuitUndealt;
    }

    @RequestMapping(value = "/games/{gameid}/players/{playerid}", method = DELETE)
    public String removePlayerFromGame(@PathVariable("gameid") int gameid, @PathVariable("playerid") int playerid) {
        application.getGamesRunning().get(gameid).deletePlayerById(playerid);
        return "Player deleted from game gameID " + gameid;
    }

    @RequestMapping(value = "/games/{gameid}/players/{playerid}/dealcard", method = PATCH)
    public String dealCardToAPlayerInAGame(@PathVariable("gameid") int gameid, @PathVariable("playerid") int playerid) {
        application.getGamesRunning().get(gameid).dealCard(playerid);
        return "New card dealt for Player ID " + playerid;
    }

    @RequestMapping(value = "/games/{gameid}/players/{playerid}/cards", method = GET)
    public ArrayList<Card> getListOfCardsForAPlayer(@PathVariable("gameid") int gameid, @PathVariable("playerid") int playerid) {
        ArrayList<Card> cardArrayList = application.getGamesRunning().get(gameid).getPlayerById(playerid).getCards();
        return cardArrayList;
    }

    //test to show game deck
    @RequestMapping("deckgamezero")
    public ArrayList<Card> showDeck(){
        return application.getGamesRunning().get(0).getGameDeck();
    }
}
