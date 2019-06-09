package interview.demo;

import interview.demo.model.Game;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

@SpringBootApplication
public class DemoApplication {

    private HashMap<Integer, Game> gamesRunning = new HashMap<>();
    private static int gameId = 0;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    public HashMap<Integer, Game> getGamesRunning() {
        return gamesRunning;
    }

    public void addToGamesRunning() {
        Game game = new Game();
        gamesRunning.put(gameId++, game);
    }

    public void deleteGameById(int gameIdForDeletion){
        gamesRunning.remove(gameIdForDeletion);
    }
}
