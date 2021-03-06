package personal.darxan.hostel.vo;

import personal.darxan.hostel.tool.DateFormatter;

import java.util.Date;

/**
 * Created by darxan on 2017/2/26.
 */
public class ReservationShowMember {

    private Long reservationId;

    private Date checkInDate;

    private Boolean reserved;

    private Boolean canceled;

    private Boolean refused;

    private Boolean payment;

    private Boolean checkIn;

    private Boolean checkOut;

    private Boolean deduct;

    /**
     * 创建时间
     */
    private Date reserveTime;

    private Integer amount;


    private Date updateTime;

    private Date checkInTime;

    private Date checkOutTime;

    private Date paymentTime;

    private Date deductTime;

    private String people;


    private Long roomId;

    private Long hostelId;

    private String hostel;

    private String contact;

    private String phone;

    private String address;

    private Date startDate;

    private Date endDate;

    private Float price;

    private Short count;

    /**
     * 房间数
     */
    private Short capacity;

    /**
     * 床数
     */
    private Short numOfBed;

    private Boolean airCondition;

    private Boolean computer;

    private String description;

    private String image;


    public boolean isDeduct() {
        return deduct;
    }

    public void setDeduct(boolean deduct) {
        this.deduct = deduct;
    }

    public Date getDeductTime() {
        return deductTime;
    }

    public void setDeductTime(Date deductTime) {
        this.deductTime = deductTime;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getHostel() {
        return hostel;
    }

    public void setHostel(String hostel) {
        this.hostel = hostel;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
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

    public Short getCount() {
        return count;
    }

    public void setCount(Short count) {
        this.count = count;
    }

    public Short getCapacity() {
        return capacity;
    }

    public void setCapacity(Short capacity) {
        this.capacity = capacity;
    }

    public Short getNumOfBed() {
        return numOfBed;
    }

    public void setNumOfBed(Short numOfBed) {
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

    public String getReservationTimeString() {
        return DateFormatter.dateFormat.format(reserveTime);
    }
    public String getReserveTimeString() {
        return DateFormatter.dateFormat.format(reserveTime);
    }

    public String getPaymentTimeString() {
        return DateFormatter.dateFormat.format(paymentTime);
    }

    public String getCheckInTimeString() {
        return DateFormatter.dateFormat.format(checkInTime);
    }

}
