package kalkulator;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
	@Test
	public void testAddOne(){
		// Arrange
		// sut = System Under Test
		Calculator sut = new Calculator();
		// Act
		sut.add(1);
		// Assert
		assertEquals("0+1 = 1", 1, sut.getState());
	}

	@Test
	public void testMultOneByTwo() {
		Calculator sut = new Calculator();
		sut.setState(1);
		sut.mult(2);
		assertEquals("1*2 = 2", 2, sut.getState());
	}

	@Test
	public void testDivdSixByTwo() {
		Calculator sut = new Calculator();
		sut.setState(6);
		sut.divd(2);
		assertEquals("6/2 = 3", 3, sut.getState());
	}
	@Test
	public void testSubsOne() {
		Calculator sut = new Calculator();
		sut.substract(1);
		assertEquals("0-1 = -1", -1, sut.getState());
	}

	@Test
	public void testAddOneToMemory() {
		Calculator sut = new Calculator();
		sut.setIfToMemory(true);
		sut.add(1);
		sut.setIfFromMemory(true);
		sut.add(1);
		assertEquals("0+1+1 = 2", 2, sut.getState());
	}

	@Test
	public void testSubsOneFromMemory() {
		Calculator sut = new Calculator();
		sut.setIfToMemory(true);
		sut.substract(1);
		sut.setIfFromMemory(true);
		sut.substract(1);
		assertEquals("0-1-(-1) = 2", 2, sut.getState());
	}

	@Test
	public void testMultOneByTwoToMemory() {
		Calculator sut = new Calculator();
		sut.setState(1);
		sut.setIfToMemory(true);
		sut.mult(2);
		sut.setIfFromMemory(true);
		sut.mult(2);
		assertEquals("1*2*2 = 4", 4, sut.getState());
	}

	@Test
	public void testDivdTwelveByTwoFromMemory() {
		Calculator sut = new Calculator();
		sut.setState(12);
		sut.setIfToMemory(true);
		sut.divd(2);
		sut.setIfFromMemory(true);
		sut.divd(24);
		assertEquals("(12/2) = 6, 24/6=4", 4, sut.getState());
	}

	@Test
	public void testDivdByZero() {
		Calculator sut = new Calculator();
		sut.setState(0);
		try {
			sut.divd(0);
		}
		catch (ArithmeticException divdByZero){
		}
		//Komunikat wyswietla sie
	}

	@Test
	public void testOverFlowAdd() {
		Calculator sut = new Calculator();
		sut.setState(1);
		sut.add(Integer.MAX_VALUE);
		//Komunikat wyswietla sie
	}

	@Test
	public void testOverflowMultiply() {
		Calculator sut = new Calculator();
		sut.setState(2);
		sut.mult(Integer.MAX_VALUE);
		//Komunikat wyswietla sie
	}

	@Test
	public void testOverflowSub() {
		Calculator sut = new Calculator();
		sut.setState(Integer.MIN_VALUE);
		sut.substract(1);
		//Komunikat wyswietla sie
	}
}

