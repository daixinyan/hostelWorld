package personal.darxan.hostel.vo;

/**
 * Created by darxan on 2017/3/11.
 */
public class StatReservation {

    private String[] timeArray = {"1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"};

    private double maxValue = 250;

    private double minValue = 0;
    
    private double interval = 50;

    private double[] reservations = {0, 0, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    private double[] checkIns = {0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0} ;

    private double[] payment = {0,0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public String[] getTimeArray() {
        return timeArray;
    }

    public void setTimeArray(String[] timeArray) {
        this.timeArray = timeArray;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    public double getMinValue() {
        return minValue;
    }

    public void setMinValue(double minValue) {
        this.minValue = minValue;
    }

    public double getInterval() {
        return interval;
    }

    public void setInterval(double interval) {
        this.interval = interval;
    }

    public double[] getReservations() {
        return reservations;
    }

    public void setReservations(double[] reservations) {
        this.reservations = reservations;
    }

    public double[] getCheckIns() {
        return checkIns;
    }

    public void setCheckIns(double[] checkIns) {
        this.checkIns = checkIns;
    }

    public double[] getPayment() {
        return payment;
    }

    public void setPayment(double[] payment) {
        this.payment = payment;
    }
}
