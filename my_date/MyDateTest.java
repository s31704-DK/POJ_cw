package MyDate;
import org.junit.Assert;
import org.junit.Test;

public class MyDateTest {
    public MyDateTest() {}

    @Test
    public void testMyDateAllValidNo0s() {
        MyDate sut = new MyDate(12, 12, 2014);
        Assert.assertEquals("12/12/2014", sut.displayDate());
    }

    @Test
    public void testMyDateAllValid0s() {
        MyDate sut = new MyDate(7, 7, 2014);
        Assert.assertEquals("07/07/2014", sut.displayDate());
    }

    @Test
    public void testMyDateNotValidDay() {
        boolean error = false;
        try {
            MyDate sut = new MyDate(12, 150, 2014);
        } catch(IllegalArgumentException e){
            error = true;
        }
        Assert.assertEquals(true, error);
    }

    @Test
    public void testMyDateNotValidMonth() {
        boolean error = false;
        try {
            MyDate sut = new MyDate(50, 14, 2014);
        } catch(IllegalArgumentException e){
            error = true;
        }
        Assert.assertEquals(true, error);
    }

    @Test
    public void testMyDateNotValidYear() {
        boolean error = false;
        try {
            MyDate sut = new MyDate(5, 14, 2070);
        } catch(IllegalArgumentException e){
            error = true;
        }
        Assert.assertEquals(true, error);
    }

    @Test
    public void testMyDateGetDay() {
        MyDate sut = new MyDate(12, 21, 2014);
        Assert.assertEquals(21, sut.getDay());
    }

    @Test
    public void testMyDateGetMonth() {
        MyDate sut = new MyDate(12, 21, 2014);
        Assert.assertEquals(12, sut.getMonth());
    }

    @Test
    public void testMyDateGetYear() {
        MyDate sut = new MyDate(12, 21, 2014);
        Assert.assertEquals(2014, sut.getYear());
    }

    @Test
    public void testSetInvalidDay() {
        MyDate sut = new MyDate(12, 21, 2014);
        boolean error = false;
        try {
            sut.setDay(-1);
        } catch (IllegalArgumentException e){
            error = true;
        }
        Assert.assertEquals(true, error);
    }

    @Test
    public void testSetInvalidMonth() {
        MyDate sut = new MyDate(12, 21, 2014);
        boolean error = false;
        try {
            sut.setMonth(-1);
        } catch (IllegalArgumentException e){
            error = true;
        }
        Assert.assertEquals(true, error);
    }

    @Test
    public void testSetInvalidYear() {
        MyDate sut = new MyDate(12, 21, 2014);
        boolean error = false;
        try {
            sut.setYear(1980);
        } catch (IllegalArgumentException e){
            error = true;
        }
        Assert.assertEquals(true, error);
    }
}
