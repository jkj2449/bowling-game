import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GameTest {

    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void canRoll() {
        game.roll(0);
    }

    @Test
    public void gutterGame() {
        rollMany(0, 20);

        assertThat(game.getScore(), is(0));
    }

    @Test
    public void allOnes() {
        rollMany(1, 20);

        assertThat(game.getScore(), is(20));
    }

    @Test
    public void oneSpare() {
        game.roll(5);
        game.roll(5);
        game.roll(3);
        rollMany(17, 0);

        assertThat(game.getScore(), is(16));
    }

    private void rollMany(int pins, int frame) {
        for (int i = 0; i < frame; i++) {
            game.roll(pins);
        }
    }
}
