package funix.prm.prm391x_alarmclock_thanhchfx01399;

// Lop alarm clock cua list view
public class AlarmClock {

    // id
    private int id;

    //hour
    private int hour;

    //minute
    private int minute;

    //trang thai on or off
    private String status;

    public AlarmClock(){
    }

    public AlarmClock(int id, int hour, int minute, String status) {
        this.id = id;
        this.hour = hour;
        this.minute = minute;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
