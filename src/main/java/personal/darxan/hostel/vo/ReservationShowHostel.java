package personal.darxan.hostel.vo;

import personal.darxan.hostel.tool.DateFormatter;

import java.util.Date;

/**
 * Created by darxan on 2017/2/26.
 */
public class ReservationShowHostel {

    private Long reservationId;

    private Date checkInDate;

    private boolean reserved;

    private boolean canceled;

    private boolean refused;

    private boolean payment;

    private boolean checkIn;

    private boolean checkOut;

    private boolean deduct;
    /**
     * 创建时间
     */
    private Date reserveTime;

    private Integer amount;

    private Double price;

    private Date updateTime;

    private Date checkInTime;

    private Date checkOutTime;

    private Date paymentTime;

    private Date deductTime;

    private String people;

    /**
     * 会员ID，扩充为七位数字时便是会员编码
     */
    private Long memberId;

    /**
     * 未激活
     * 激活
     * 暂停
     * 正常
     * 停止
     */
    private Short state;

    /**
     * 会员等级
     */
    private Short level = 0;

    /**
     * 会员积分
     */
    private Long bonusPoint = 0L;

    private String avatar;
    /**
     * 银行卡
     */
    private String bankCard;

    private String phone;

    private String contact;

    protected String name;


    @Override
    public String toString() {
        return "ReservationShowHostel{" +
                "reservationId=" + reservationId +
                ", reserved=" + reserved +
                ", canceled=" + canceled +
                ", refused=" + refused +
                ", payment=" + payment +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", reserveTime=" + reserveTime +
                ", amount=" + amount +
                ", price=" + price +
                ", updateTime=" + updateTime +
                ", checkInTime=" + checkInTime +
                ", checkOutTime=" + checkOutTime +
                ", people='" + people + '\'' +
                ", memberId=" + memberId +
                ", state=" + state +
                ", level=" + level +
                ", bonusPoint=" + bonusPoint +
                ", avatar='" + avatar + '\'' +
                ", bankCard='" + bankCard + '\'' +
                ", phone='" + phone + '\'' +
                ", contact='" + contact + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

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

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }

    public Short getLevel() {
        return level;
    }

    public void setLevel(Short level) {
        this.level = level;
    }

    public Long getBonusPoint() {
        return bonusPoint;
    }

    public void setBonusPoint(Long bonusPoint) {
        this.bonusPoint = bonusPoint;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
