import java.util.Random;

/**
 * Created by niko on 21/10/15.
 */
public class Generator implements NumberGenerator {

    @Override
    public int generateNumber() {
        return Math.abs(new Random().nextInt());
    }
}
