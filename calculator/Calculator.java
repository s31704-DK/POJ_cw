package kalkulator;
import java.lang.Math;

public class Calculator {
	private int state = 0;
	private int memory = 0;
	private boolean ifFromMemory = false;
	private boolean ifToMemory = false;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	public void setIfFromMemory(boolean ifFromMemory) {this.ifFromMemory = ifFromMemory;}
	public void setIfToMemory(boolean ifToMemory) {this.ifToMemory = ifToMemory;}
	public void eraseMemoryStatus() {
		this.ifFromMemory = false;
		this.ifToMemory = false;
	}

	public void add(int value){
		try {
			if (ifFromMemory == true) {
				state = Math.addExact(memory, value);

			} else {
				state = Math.addExact(state, value);
			}
			if (ifToMemory == true) {
				memory = state;
			}
		}
		catch (ArithmeticException overflowEx) {
			System.out.println("Liczba przekroczyla mozliwy zakres");
		}
		eraseMemoryStatus();
	}

	public void substract(int value){
		try{
			if (ifFromMemory == true) {
				state = Math.subtractExact(value, memory);
			} else {
				state = Math.subtractExact(state, value);
			}
			if (ifToMemory == true) {
				memory = state;
			}
		}
		catch (ArithmeticException overflowEx) {
			System.out.println("Liczba przekroczyla mozliwy zakres");
		}
		eraseMemoryStatus();
	}

	public void mult(int value){
		try {
			if (ifFromMemory == true) {
				state = Math.multiplyExact(value, memory);
			} else {
				state = Math.multiplyExact(state, value);
			}
			if (ifToMemory == true) {
				memory = state;
			}
		}
		catch (ArithmeticException overflowEx) {
			System.out.println("Liczba przekroczyla mozliwy zakres");
		}
		eraseMemoryStatus();
	}

	public void divd(int value) {
		if (value != 0) {
			if (ifFromMemory == true) {
				state = Math.divideExact(value, memory);
			} else {
				state = Math.divideExact(state, value);
			}
			if (ifToMemory == true) {
				memory = state;
			}
		} else {
			memory = state;
				System.out.println("Nie można dzielić przez "+value+". Zapisano dotychczasowy wynik w pamięci");
			}
		eraseMemoryStatus();
	}

}