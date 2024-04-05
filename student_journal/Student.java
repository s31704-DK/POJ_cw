package Student;

public class Student {
    //zmienne z mozliwoscia zmiany wartosci
    private String imie = "Unknown";        //powinno byc final, ale m.in. isntnieje w prawie mozliwosc zmiany imienia i nazwiska
    private String nazwisko = "Unknown";
    private float obecnosc;                   //ilosc obecnosci przeliczana na procenty; zalozenie - liczba zajec: 10
    private int ocenaPOJ = 2;

    //zmienne niezbedne, bez mozliwosci ustawienia nowej wartosci
    private final String NR_INDEKSU;
    private boolean is2;        //wartosc zmienia sie automatycznie; nie ma settera, wiec nalezy do tej kategorii; osobny stan celem monitorowania

    //gettery
    public String getImie() {
        return imie;
    }
    public String getNazwisko() {
        return nazwisko;
    }
    public String getNrIndeksu() {
        return NR_INDEKSU;
    }
    public float getObecnosc() {
        return obecnosc;
    }
    public boolean is2() {
        return is2;
    }

    public int getOcenaPOJ() {
        return ocenaPOJ;
    }

    //settery
    public void setImie(String imie) {
        this.imie = imie;
    }
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
    public void checkObecnosc() {
        if (obecnosc < 50) {
            is2 = true;
        } else {
            is2 = false;
        }
    }
    public void setObecnosc(int obecnosc) {
        this.obecnosc = (obecnosc*100)/10f;
        checkObecnosc();
    }

    public void setOcenaPOJ(int ocenaPOJ) {
        checkObecnosc();
        if (is2) {
            this.ocenaPOJ = 2;
        } else {
            if (ocenaPOJ > 5 || ocenaPOJ < 2) {
                throw new IllegalArgumentException("to nie jest ocena");
            } else {
                this.ocenaPOJ = ocenaPOJ;
            }
        }
    }

    //konstruktory
    //1
    public Student(String imie, String nazwisko, String nrIndeksu, int obecnosc) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.NR_INDEKSU = nrIndeksu;
        this.obecnosc = (obecnosc*100)/10f;

        if (obecnosc < 50) {
            is2 = true;
        } else {
            is2 = false;
        }
    }
    //2
    public Student(String nrIndeksu, int obecnosc) {
        this.NR_INDEKSU = nrIndeksu;
        this.obecnosc = (obecnosc*100)/10f;

        if (obecnosc < 50) {
            is2 = true;
        } else {
            is2 = false;
        }
    }
    //3
    public Student(String nrIndeksu) {
        this.NR_INDEKSU = nrIndeksu;
    }
    //4 - np. przy przepisywaniu osiagniec w trkacie juz trwajacego semestru
    public Student(String imie, String nazwisko, String nrIndeksu, int obecnosc, int ocenaPOJ) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.NR_INDEKSU = nrIndeksu;
        this.obecnosc = (obecnosc*100)/10f;

        if (this.obecnosc < 50) {
            is2 = true;
        } else {
            is2 = false;
        }

        if (is2 == false) {
            if (ocenaPOJ > 5 || ocenaPOJ < 2) {
                throw new IllegalArgumentException("to nie jest ocena");
            } else {
                this.ocenaPOJ = ocenaPOJ;
            }
        } else {
            this.ocenaPOJ = 2;
        }
    }
}
