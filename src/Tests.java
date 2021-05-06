import org.junit.Assert;
import org.junit.Test;

public class Tests {

    @Test
    public void testNormal() {
        Assert.assertEquals("несовпадалово", (long) 8, (long)Example.decode("8"));
    }

    @Test
    public void testNormalOct() {
        Assert.assertEquals("несовпадалово", (long) 81, (long)Example.decode("0121"));
    }

    @Test
    public void testNormalHex() {
        Assert.assertEquals("несовпадалово", (long) 276, (long)Example.decode("0x114"));
    }

    @Test
    public void testNegative() {
        Assert.assertEquals("несовпадалово", (long) -276, (long)Example.decode("-0x114"));
    }

    @Test
    public void testPositive() {
        Assert.assertEquals("несовпадалово", (long) 276, (long)Example.decode("+#114"));
    }

    @Test
    public void testSignPosition() {
        try{
            Example.decode("#-568");
            Assert.fail("тут надо бы исключение");
        }
        catch (NumberFormatException e) {
            Assert.assertEquals("Sign character in wrong position", e.getMessage());
        }
    }

    @Test
    public void testEmpty() {
        try{
            Example.decode("");
            Assert.fail("тут надо бы исключение");
        }
        catch (NumberFormatException e) {
            Assert.assertEquals("Zero length string", e.getMessage());
        }
    }

    @Test
    public void testWrongInput() {
        try{
            Example.decode("asd");
            Assert.fail("тут надо бы исключение");
        }
        catch (NumberFormatException e) {
            Assert.assertEquals("For input string: \"asd\"", e.getMessage());
        }
    }
}