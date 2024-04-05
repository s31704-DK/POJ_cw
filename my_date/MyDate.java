package MyDate;

public class MyDate {
    private int month;
    private int day;
    private int year;

    //gettery
    public int getMonth() {
        return month;
    }
    public int getDay() {
        return day;
    }
    public int getYear() {
        return year;
    }

    //settery
    public void setDay(int day) {
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Month must be between 1 and 31");
        } else {
            this.day = day;
        }
    }
    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month must be between 1 and 12");
        } else {
            this.month = month;
        }
    }
    public void setYear(int year) {
        if (year < 1990 || year > 2050) {
            throw new IllegalArgumentException("Year must be between 1990 and 2050");
        } else {
            this.year = year;
        }
    }

    public String displayDate(){
        String fullDay = (day >= 10)? String.valueOf(day) : "0" + day;
        String fullMonth = (month >= 10)? String.valueOf(month) : "0" + month;
        return fullDay + "/" + fullMonth + "/" + year;
    }

    //konstruktor
    public MyDate(int month, int day, int year) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month must be between 1 and 12");
        } else {
            this.month = month;
        }
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Month must be between 1 and 31");
        } else {
            this.day = day;
        }
        if (year < 1990 || year > 2050) {
            throw new IllegalArgumentException("Year must be between 1990 and 2050");
        } else {
            this.year = year;
        }
    }
}
