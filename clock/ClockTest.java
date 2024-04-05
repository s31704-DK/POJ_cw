package Clock;
import org.junit.Assert;
import org.junit.Test;
//80000 s - 22:13:20
public class ClockTest {
    public ClockTest() {}
    @Test
    public void testClockConstructor1() {
        Clock sut = new Clock();
        System.out.println(sut.getHours() + ":" + sut.getMinutes() + ":" + sut.getSeconds());
        Assert.assertEquals("12:0:0", sut.getHours() + ":" + sut.getMinutes() + ":" + sut.getSeconds());
    }
    @Test
    public void testClockConstructor2() {
        Clock sut = new Clock(22, 13, 20);
        System.out.println(sut.getHours() + ":" + sut.getMinutes() + ":" + sut.getSeconds());
        Assert.assertEquals("22:13:20", sut.getHours() + ":" + sut.getMinutes() + ":" + sut.getSeconds());
    }
    @Test
    public void testClockConstructor3() {
        Clock sut = new Clock(80000);
        System.out.println(sut.getHours() + ":" + sut.getMinutes() + ":" + sut.getSeconds());
        Assert.assertEquals("22:13:20", sut.getHours() + ":" + sut.getMinutes() + ":" + sut.getSeconds());
    }
    @Test
    public void testSetHours() {
        Clock sut = new Clock();
        sut.setHours(22);
        Assert.assertEquals(22,sut.getHours());
    }
    @Test
    public void testSetMinutes() {
        Clock sut = new Clock();
        sut.setMinutes(22);
        Assert.assertEquals(22,sut.getMinutes());
    }
    @Test
    public void testSetSeconds() {
        Clock sut = new Clock();
        sut.setSeconds(22);
        Assert.assertEquals(22,sut.getSeconds());
    }
    @Test
    public void testToStringNo0s() {
        Clock sut = new Clock(22, 13, 20);
        Assert.assertEquals("[22:13:20]", sut.toString());
    }
    @Test
    public void testToString0s() {
        Clock sut = new Clock(2, 3, 2);
        Assert.assertEquals("[02:03:02]", sut.toString());
    }
    @Test
    public void testTickSimple() {
        Clock sut = new Clock(22, 13, 20);
        sut.tick();
        Assert.assertEquals("[22:13:21]", sut.toString());
    }
    @Test
    public void testTickMinuteChange() {
        Clock sut = new Clock(22, 13, 59);
        sut.tick();
        Assert.assertEquals("[22:14:00]", sut.toString());
    }
    @Test
    public void testTickHourChange() {
        Clock sut = new Clock(22, 59, 59);
        sut.tick();
        Assert.assertEquals("[23:00:00]", sut.toString());
    }
    @Test
    public void testTickItsLowNoon() {
        Clock sut = new Clock(23, 59, 59);
        sut.tick();
        Assert.assertEquals("[00:00:00]", sut.toString());
    }
    @Test
    public void testTickLowNoonTwoTicks() {
        Clock sut = new Clock(23, 59, 59);
        for (int i = 1; i <= 2; i++) {
            sut.tick();
        }
        Assert.assertEquals("[00:00:01]", sut.toString());
    }
    @Test
    public void testTickDownSimple() {
        Clock sut = new Clock(22, 13, 20);
        sut.tickDown();
        Assert.assertEquals("[22:13:19]", sut.toString());
    }
    @Test
    public void testTickDownMinuteChange() {
        Clock sut = new Clock(22, 13, 00);
        sut.tickDown();
        Assert.assertEquals("[22:12:59]", sut.toString());
    }
    @Test
    public void testTickDownHourChange() {
        Clock sut = new Clock(22, 00, 00);
        sut.tickDown();
        Assert.assertEquals("[21:59:59]", sut.toString());
    }
    @Test
    public void testTickDownLowNoon() {
        Clock sut = new Clock(00, 00, 00);
        sut.tickDown();
        Assert.assertEquals("[23:59:59]", sut.toString());
    }
    @Test
    public void testTickDownLowNoonTwoTicks() {
        Clock sut = new Clock(00, 00, 00);
        for (int i = 1; i <= 2; i++) {
            sut.tickDown();
        }
        Assert.assertEquals("[23:59:58]", sut.toString());
    }
}