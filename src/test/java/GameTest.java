import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GameTest {
    Game game = new Game();

    Player player1 = new Player(1, "Korsak", 100);
    Player player2 = new Player(2, "Gideon555", 150);
    Player player3 = new Player(3, "CinGirl678", 100);
    Player player4 = new Player(5, "ggdfgdfj777", 10);



    @Test
    public void shouldCheckRegistration() {


        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        ArrayList<Player> expected = new ArrayList<>();
        expected.add(player1);
        expected.add(player2);
        expected.add(player3);
        expected.add(player4);

        Assertions.assertEquals(expected, game.getAllPlayers());
    }

    @Test
    public void shouldCheckRegistrationWithRegisteredPlayer() {


        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player1);

        ArrayList<Player> expected = new ArrayList<>();
        expected.add(player1);
        expected.add(player2);
        expected.add(player3);
        expected.add(player4);

        Assertions.assertEquals(expected, game.getAllPlayers());
    }


    @Test
    public void shouldRoundSecondWin() throws NotRegisteredException {
        game.register(player1);
        game.register(player2);


        int expected = 2;
        int actual = game.round("Korsak", "Gideon555");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRoundNobodyWin() throws NotRegisteredException {
        game.register(player1);
        game.register(player3);


        int expected = 0;
        int actual = game.round("Korsak", "CinGirl678");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRoundFirstWin() throws NotRegisteredException {
        game.register(player1);
        game.register(player4);


        int expected = 1;
        int actual = game.round("Korsak", "ggdfgdfj777");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRoundWithException() throws NotRegisteredException {
        game.register(player1);


        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Korsak", "ggdfgdfj777");
        });
    }

    @Test
    public void shouldRoundWithExceptionTwo() throws NotRegisteredException {
        game.register(player4);


        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Korsak", "ggdfgdfj777");
        });
    }

    @Test
    public void shouldRoundWithExceptionThree() throws NotRegisteredException {


        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Korsak", "ggdfgdfj777");
        });
    }


}
