package Clock;
import java.lang.Math;

public class Clock {
    private int hours, minutes, seconds;
    private static final int SECONDS_IN_HOUR = 3600;
    private static final int MINUTES_IN_HOUR = 60;
    //konstruktory
        //1
    public Clock() {
        hours = 12;
        minutes = 0;
        seconds = 0;
    }
        //2
    public Clock(int hours, int minutes, int seconds) {
        //hours
        if (hours < 0 || hours > 23) {
            throw new IllegalArgumentException("Hours must be between 0 and 23");
        } else {
            this.hours = hours;
        }
        //minutes
        if (minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Minutes must be between 0 and 59");
        } else {
            this.minutes = minutes;
        }
        //seconds
        if (seconds < 0 || seconds > 59) {
            throw new IllegalArgumentException("Seconds must be between 0 and 59");
        } else {
            this.seconds = seconds;
        }
    }
        //3
    public Clock(int seconds) {
        if (seconds < 0 || seconds > 86399) {
            throw new IllegalArgumentException("Seconds must be between 0 and 86399");
        } else {
            hours = (int) Math.floor((double)(seconds/SECONDS_IN_HOUR));
            minutes = (int) Math.floor((double)((seconds%SECONDS_IN_HOUR)/MINUTES_IN_HOUR));
            this.seconds = seconds - (minutes*MINUTES_IN_HOUR + hours*SECONDS_IN_HOUR);
        }
    }
    //gettery
    public int getHours() {
        return hours;
    }
    public int getMinutes() {
        return minutes;
    }
    public int getSeconds() {
        return seconds;
    }
    //settery
    public void setHours(int hours) {
        if (hours < 0 || hours > 23) {
            throw new IllegalArgumentException("Hours must be between 0 and 23");
        } else {
            this.hours = hours;
        }
    }
    public void setMinutes(int minutes) {
        if (minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Minutes must be between 0 and 59");
        } else {
            this.minutes = minutes;
        }
    }
    public void setSeconds(int seconds) {
        if (seconds < 0 || seconds > 59) {
            throw new IllegalArgumentException("Seconds must be between 0 and 59");
        } else {
            this.seconds = seconds;
        }
    }
    //metody
    public String toString() {
        String hoursStr = (hours<10)? "0"+hours:""+hours;
        String minutesStr = (minutes<10)? "0"+minutes:""+minutes;
        String secondsStr = (seconds<10)? "0"+seconds:""+seconds;
        return "[" + hoursStr +":" + minutesStr + ":" + secondsStr + "]";
    }
    public void tick() {
        ++seconds;
        if (seconds > 59) {
            seconds = 0;
            ++minutes;
            if (minutes > 59) {
                minutes = 0;
                ++hours;
                if (hours > 23) {
                    hours = 0;
                }
            }
        }
    }
    public void tickDown () {
        --seconds;
        if (seconds < 0) {
            seconds = 59;
            --minutes;
            if (minutes < 0) {
                minutes = 59;
                --hours;
                if (hours < 0) {
                    hours = 23;
                }
            }
        }
    }
}