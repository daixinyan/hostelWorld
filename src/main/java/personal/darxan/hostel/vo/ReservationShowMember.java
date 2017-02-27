package personal.darxan.hostel.vo;

import java.util.Date;

/**
 * Created by darxan on 2017/2/26.
 */
public class ReservationShowMember {

    private Long reservationId;

    private boolean reserved;

    private boolean canceled;

    private boolean refused;

    private boolean payment;

    private boolean checkIn;

    private boolean checkOut;

    /**
     * 创建时间
     */
    private Date reserveTime;

    private double amount;


    private Date updateTime;

    private Date checkInTime;

    private Date checkOutTime;

    private Date paymentTime;

    private String people;


    private Long roomId;

    private Long hostelId;

    private String hostel;

    private Date startDate;

    private Date endDate;

    private float price;

    private short count;

    /**
     * 房间数
     */
    private short capacity;

    /**
     * 床数
     */
    private short numOfBed;

    private boolean airCondition;

    private boolean computer;

    private String description;

    private String image;


    public String getHostel() {
        return hostel;
    }

    public void setHostel(String hostel) {
        this.hostel = hostel;
    }

    @Override
    public String toString() {
        return "ReservationShowMember{" +
                "reservationId=" + reservationId +
                ", reserved=" + reserved +
                ", canceled=" + canceled +
                ", refused=" + refused +
                ", payment=" + payment +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", reserveTime=" + reserveTime +
                ", amount=" + amount +
                ", updateTime=" + updateTime +
                ", checkInTime=" + checkInTime +
                ", checkOutTime=" + checkOutTime +
                ", paymentTime=" + paymentTime +
                ", people='" + people + '\'' +
                ", roomId=" + roomId +
                ", hostelId=" + hostelId +
                ", hostel='" + hostel + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", price=" + price +
                ", count=" + count +
                ", capacity=" + capacity +
                ", numOfBed=" + numOfBed +
                ", airCondition=" + airCondition +
                ", computer=" + computer +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    public boolean isRefused() {
        return refused;
    }

    public void setRefused(boolean refused) {
        this.refused = refused;
    }

    public boolean isPayment() {
        return payment;
    }

    public void setPayment(boolean payment) {
        this.payment = payment;
    }

    public boolean isCheckIn() {
        return checkIn;
    }

    public void setCheckIn(boolean checkIn) {
        this.checkIn = checkIn;
    }

    public boolean isCheckOut() {
        return checkOut;
    }

    public void setCheckOut(boolean checkOut) {
        this.checkOut = checkOut;
    }

    public Date getReserveTime() {
        return reserveTime;
    }

    public void setReserveTime(Date reserveTime) {
        this.reserveTime = reserveTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }

    public Date getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(Date checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getHostelId() {
        return hostelId;
    }

    public void setHostelId(Long hostelId) {
        this.hostelId = hostelId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public short getCount() {
        return count;
    }

    public void setCount(short count) {
        this.count = count;
    }

    public short getCapacity() {
        return capacity;
    }

    public void setCapacity(short capacity) {
        this.capacity = capacity;
    }

    public short getNumOfBed() {
        return numOfBed;
    }

    public void setNumOfBed(short numOfBed) {
        this.numOfBed = numOfBed;
    }

    public boolean isAirCondition() {
        return airCondition;
    }

    public void setAirCondition(boolean airCondition) {
        this.airCondition = airCondition;
    }

    public boolean isComputer() {
        return computer;
    }

    public void setComputer(boolean computer) {
        this.computer = computer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
