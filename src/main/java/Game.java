import java.util.ArrayList;

public class Game {
    ArrayList<Player> players = new ArrayList<>();


    public void register(Player player) {

        if (! players.contains(player)) {
            players.add(player);
        }
    }

    public ArrayList<Player> getAllPlayers() {
        return players;
    }

    public int round(String playerName1, String playerName2) throws NotRegisteredException {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

        if (!players.contains(player1) || !players.contains(player2)) {
            throw new NotRegisteredException("One of the players is not registered in the game");
        }

        int strength1 = findByName(playerName1).getStrength();
        int strength2 = findByName(playerName2).getStrength();

        if (strength1 > strength2) {
            return 1;
        } else if (strength1 < strength2) {
            return 2;
        } else {
            return 0;
        }
    }

    public Player findByName(String playerName) {
        for (Player player : getAllPlayers()) {
            if (player.getName() == playerName) {
                return player;
            }
        }
        return null;
    }



}
