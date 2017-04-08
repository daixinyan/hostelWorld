package personal.darxan.hostel.vo;

/**
 * Created by darxan on 2017/3/12.
 */
public class StatObejct {
    private String[] timeArray = {"1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"};


    private double[] values = {0,0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public String[] getTimeArray() {
        return timeArray;
    }

    public void setTimeArray(String[] timeArray) {
        this.timeArray = timeArray;
    }

    public double[] getValues() {
        return values;
    }

    public void setValues(double[] values) {
        this.values = values;
    }
}
