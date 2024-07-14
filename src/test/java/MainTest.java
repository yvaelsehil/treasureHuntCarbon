import app.treasurehunt.Main;
import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    public void verifyNoExceptionThrown() {
        Main.main(new String[]{
                "src/test/ressources/maps/map1"
        });
    }
}
