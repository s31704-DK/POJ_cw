package Student;

import org.junit.Assert;
import org.junit.Test;


public class StudentTest {
    public StudentTest() {}

    public void writeFields(Student student) {
        System.out.println(student.getImie());
        System.out.println(student.getNazwisko());
        System.out.println(student.getNrIndeksu());
        System.out.println(student.getObecnosc());
        System.out.println(student.is2());
        System.out.println(student.getOcenaPOJ());
    }
    @Test
    public void constructor1() {
        Student sut = new Student("Dawid", "Koscielniak", "s31704", 7);
        System.out.println("Konstruktor 1\n");
        writeFields(sut);
        System.out.println("\n");
    }

    @Test
    public void constructor2() {
        Student sut = new Student("s31704", 3);
        System.out.println("Konstruktor 2\n");
        writeFields(sut);
        System.out.println("\n");
    }

    @Test
    public void constructor3() {
        Student sut = new Student("s31704");
        System.out.println("Konstruktor 3\n");
        writeFields(sut);
        System.out.println("\n");
    }

    @Test
    public void obecnosc() {
        Student sut = new Student("s31704");
        sut.setObecnosc(5);

        System.out.println("\n" + sut.getObecnosc() + " " + sut.is2());
    }
    @Test
    public void constructor4PoprawnaOcena() {
        Student sut = new Student("Dawid", "Koscielniak", "s31704", 7, 3);
        System.out.println("Konstruktor 4\n");
        writeFields(sut);
        System.out.println("\n");

    }

    @Test
    public void constructor4NiepoprawnaOcena() {
        boolean error = false;
        try {
            Student sut = new Student("Dawid", "Koscielniak", "s31704", 7, 8);
        } catch(IllegalArgumentException e){
            error = true;
        }
        Assert.assertEquals(true, error);
    }

    @Test
    public void constructor4BrakObcenosci() {
        Student sut = new Student("Dawid", "Koscielniak", "s31704", 3, 3);
        boolean error = false;
        try {
            System.out.println("Konstruktor 4\n");
            writeFields(sut);
            System.out.println("\n");
        } catch(IllegalArgumentException e){
            error = true;
        }
        Assert.assertEquals(false, error);
    }

    @Test
    public void setOcenaTest(){
        Student sut = new Student("Dawid", "Koscielniak", "s31704", 7);
        sut.setOcenaPOJ(3);

        System.out.println(sut.is2());
        System.out.println(sut.getOcenaPOJ());
    }

    @Test
    public void setOcenaBrakObecnosciTest(){
        Student sut = new Student("Dawid", "Koscielniak", "s31704", 2);
        sut.setOcenaPOJ(3);

        System.out.println(sut.is2());
        System.out.println(sut.getOcenaPOJ());
    }

    @Test
    public void setOcenaOverflowTest(){
        Student sut = new Student("Dawid", "Koscielniak", "s31704", 7);

        boolean error = false;
        try {
            sut.setOcenaPOJ(8);
        } catch(IllegalArgumentException e){
            error = true;
        }

        Assert.assertEquals(true, error);
    }
}
