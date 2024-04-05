package Card;

import org.junit.Test;
import org.junit.Assert;

public class CardTest{
   public CardTest(){}

    @Test
    public void cardValueValueTest(){
       Assert.assertEquals("Walet ma liczbowa wartosc 11", 11, Card.Value.J.getValue());
    }

    @Test
    public void cardVolorValueTest() {
       Assert.assertEquals("Kier ma wartość liczbową 4", 4, Card.Color.Kier.getValue());
    }

    @Test
    public void areFieldsReadableTest() {
        Card cardOne = new Card(Card.Value.J, Card.Color.Kier);
        System.out.println(cardOne.getValue() + " " + cardOne.getValueValue() + " " + cardOne.getColor() + " " + cardOne.getColorValue());
    }
    
    @Test
    public void isHigherValueTest() {
        Card cardOne = new Card(Card.Value.A, Card.Color.Kier);
        Card cardTwo = new Card(Card.Value.J, Card.Color.Kier);

        boolean[] result = cardOne.checkHigher(cardTwo);
        boolean[] expectedResult = {true, false};

        Assert.assertArrayEquals("As jest wyzej", expectedResult, result);
    }

    @Test
    public void isHigherColorTest() {
        Card cardOne = new Card(Card.Value.J, Card.Color.Kier);
        Card cardTwo = new Card(Card.Value.J, Card.Color.Pik);

        boolean[] result = cardOne.checkHigher(cardTwo);
        boolean[] expectedResult = {true, false};

        Assert.assertArrayEquals("Kier jest wyzej", expectedResult, result);
    }

    @Test
    public void isEqual() {
        Card cardOne = new Card(Card.Value.J, Card.Color.Kier);
        Card cardTwo = new Card(Card.Value.J, Card.Color.Kier);

        boolean[] result = cardOne.checkHigher(cardTwo);
        boolean[] expectedResult = {false, true};

        Assert.assertArrayEquals("Sa rowne", expectedResult, result);
    }

    @Test
    public void isLowerValueTest() {
        Card cardOne = new Card(Card.Value.J, Card.Color.Kier);
        Card cardTwo = new Card(Card.Value.A, Card.Color.Kier);

        boolean[] result = cardOne.checkHigher(cardTwo);
        boolean[] expectedResult = {false, false};

        Assert.assertArrayEquals("As jest wyzej", expectedResult, result);
    }

    @Test
    public void isLowerColorTest() {
        Card cardOne = new Card(Card.Value.J, Card.Color.Pik);
        Card cardTwo = new Card(Card.Value.J, Card.Color.Kier);

        boolean[] result = cardOne.checkHigher(cardTwo);
        boolean[] expectedResult = {false, false};

        Assert.assertArrayEquals("Kier jest wyzej", expectedResult, result);
    }
}