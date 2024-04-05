package Numbers;
import java.lang.Math;

public class Numbers {
    private int[] tablicaLiczb = new int[3];
    //konstruktor
    public Numbers(int[] tablicaLiczb) {
        for (int i = 0; i  < tablicaLiczb.length; i++) {
            this.tablicaLiczb[i] = tablicaLiczb[i];
        }
    }
    //gettery
    public int getLiczba(int indeks) {
        return tablicaLiczb[indeks];
    }

    //settery
    public void setLiczba1(int liczba, int indeks) {
        tablicaLiczb[indeks] = liczba;
    }

    //metody
    public int sum(){
        int sum = 0;
        for (int liczba : tablicaLiczb) {
            sum += liczba;
        }
        return sum;
    }
    public double average(){
        return sum()/3.0;
    }
    public double geometric(){
        double product = 1;
        for (int liczba : tablicaLiczb) {
            product *= liczba;
        }
        return Math.cbrt(product);
    }
    public int max(){
        int max = Integer.MIN_VALUE;
        for (int liczba : tablicaLiczb) {
            if (max < liczba) {
                max = liczba;
            }
        }
        return max;
    }
    public int min(){
        int min = Integer.MAX_VALUE;
        for (int liczba : tablicaLiczb) {
            if (min > liczba) {
                min = liczba;
            }
        }
        return min;
    }
}
