package personal.darxan.hostel.vo;

import personal.darxan.hostel.tool.DateFormatter;

import java.util.Date;

/**
 * Created by darxan on 2017/2/16.
 */
public class SearchRestrict {

    private double priceUpper = 1000000;

    private double priceLower = 0;

    private String address;

    private String add1;

    private String add2;

    private String add3;

    private String add4;

    private Integer page = 1;

    private String keyword;

    private Boolean computer;

    private Boolean airCondition;

    private Short numOfBed;

    private Short capacity;

    private Short pageSize = 20;

    private String order = "roomId";

    private boolean asc = true;


    private Date dateLower = new Date(System.currentTimeMillis()-15*24*60*60*1000);

    private Date dateUpper = new Date();


    public String getDateLowerString() {
        return DateFormatter.dateFormat.format(dateLower);
    }


    public String getDateUpperString() {
        return DateFormatter.dateFormat.format(dateUpper);
    }

    public Date getDateLower() {
        return dateLower;
    }

    public void setDateLower(Date dateLower) {
        this.dateLower = dateLower;
    }

    public Date getDateUpper() {
        return dateUpper;
    }

    public void setDateUpper(Date dateUpper) {
        this.dateUpper = dateUpper;
    }

    public double getPriceUpper() {
        return priceUpper;
    }

    public void setPriceUpper(double priceUpper) {
        this.priceUpper = priceUpper;
    }

    public double getPriceLower() {
        return priceLower;
    }

    public void setPriceLower(double priceLower) {
        this.priceLower = priceLower;
    }

    public boolean isAsc() {
        return asc;
    }

    public void setAsc(boolean asc) {
        this.asc = asc;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Short getPageSize() {
        return pageSize;
    }

    public void setPageSize(Short pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Boolean getComputer() {
        return computer;
    }

    public void setComputer(Boolean computer) {
        this.computer = computer;
    }

    public Boolean getAirCondition() {
        return airCondition;
    }

    public void setAirCondition(Boolean airCondition) {
        this.airCondition = airCondition;
    }

    public Short getNumOfBed() {
        return numOfBed;
    }

    public void setNumOfBed(Short numOfBed) {
        this.numOfBed = numOfBed;
    }

    public Short getCapacity() {
        return capacity;
    }

    public void setCapacity(Short capacity) {
        this.capacity = capacity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAdd1() {
        return add1;
    }

    public void setAdd1(String add1) {
        this.add1 = add1;
    }

    public String getAdd2() {
        return add2;
    }

    public void setAdd2(String add2) {
        this.add2 = add2;
    }

    public String getAdd3() {
        return add3;
    }

    public void setAdd3(String add3) {
        this.add3 = add3;
    }

    public String getAdd4() {
        return add4;
    }

    public void setAdd4(String add4) {
        this.add4 = add4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SearchRestrict that = (SearchRestrict) o;

        if (Double.compare(that.priceUpper, priceUpper) != 0) return false;
        if (Double.compare(that.priceLower, priceLower) != 0) return false;
        if (asc != that.asc) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (add1 != null ? !add1.equals(that.add1) : that.add1 != null) return false;
        if (add2 != null ? !add2.equals(that.add2) : that.add2 != null) return false;
        if (add3 != null ? !add3.equals(that.add3) : that.add3 != null) return false;
        if (add4 != null ? !add4.equals(that.add4) : that.add4 != null) return false;
        if (keyword != null ? !keyword.equals(that.keyword) : that.keyword != null) return false;
        if (computer != null ? !computer.equals(that.computer) : that.computer != null) return false;
        if (airCondition != null ? !airCondition.equals(that.airCondition) : that.airCondition != null) return false;
        if (numOfBed != null ? !numOfBed.equals(that.numOfBed) : that.numOfBed != null) return false;
        if (capacity != null ? !capacity.equals(that.capacity) : that.capacity != null) return false;
        if (pageSize != null ? !pageSize.equals(that.pageSize) : that.pageSize != null) return false;
        return order != null ? order.equals(that.order) : that.order == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(priceUpper);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(priceLower);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (add1 != null ? add1.hashCode() : 0);
        result = 31 * result + (add2 != null ? add2.hashCode() : 0);
        result = 31 * result + (add3 != null ? add3.hashCode() : 0);
        result = 31 * result + (add4 != null ? add4.hashCode() : 0);
        result = 31 * result + (keyword != null ? keyword.hashCode() : 0);
        result = 31 * result + (computer != null ? computer.hashCode() : 0);
        result = 31 * result + (airCondition != null ? airCondition.hashCode() : 0);
        result = 31 * result + (numOfBed != null ? numOfBed.hashCode() : 0);
        result = 31 * result + (capacity != null ? capacity.hashCode() : 0);
        result = 31 * result + (pageSize != null ? pageSize.hashCode() : 0);
        result = 31 * result + (order != null ? order.hashCode() : 0);
        result = 31 * result + (asc ? 1 : 0);
        return result;
    }


    @Override
    public String toString() {
        return "SearchRestrict{" +
                "priceUpper=" + priceUpper +
                ", priceLower=" + priceLower +
                ", address='" + address + '\'' +
                ", add1='" + add1 + '\'' +
                ", add2='" + add2 + '\'' +
                ", add3='" + add3 + '\'' +
                ", add4='" + add4 + '\'' +
                ", page=" + page +
                ", keyword='" + keyword + '\'' +
                ", computer=" + computer +
                ", airCondition=" + airCondition +
                ", numOfBed=" + numOfBed +
                ", capacity=" + capacity +
                ", pageSize=" + pageSize +
                ", order='" + order + '\'' +
                ", asc=" + asc +
                ", dateLower=" + dateLower +
                ", dateUpper=" + dateUpper +
                '}';
    }
}
