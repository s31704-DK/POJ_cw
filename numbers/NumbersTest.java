package Numbers;
import org.junit.Assert;
import org.junit.Test;

public class NumbersTest {
    public NumbersTest() {}
    private final int[] TABLICA_SUT = {-1, 10, 18};

    @Test
    public void testSum() {

        Numbers sut = new Numbers(TABLICA_SUT);
        int sum = sut.sum();
        Assert.assertEquals(27, sum);
    }
    @Test
    public void testAverage() {
        Numbers sut = new Numbers(TABLICA_SUT);
        double average = sut.average();
        Assert.assertEquals(9.0, average, 0.1);
    }
    @Test
    public void testGeometric() {
        Numbers sut = new Numbers(TABLICA_SUT);
        double geometric = sut.geometric();
        Assert.assertEquals(-5.6, geometric, 0.1);
    }
    @Test
    public void testMax() {
        Numbers sut = new Numbers(TABLICA_SUT);
        int max = sut.max();
        Assert.assertEquals(18, max);
    }
    @Test
    public void testMin() {
        Numbers sut = new Numbers(TABLICA_SUT);
        int min = sut.min();
        Assert.assertEquals(-1, min);
    }
}
