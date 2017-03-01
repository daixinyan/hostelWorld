package personal.darxan.hostel.model;

import org.hibernate.annotations.GenericGenerator;
import personal.darxan.hostel.model.base.BaseTable;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by darxan on 2017/2/14.
 */
@Entity
public class Reservation extends BaseTable {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "native")
    @GeneratedValue(generator = "idGenerator")
    private Long reservationId;


    private boolean reserved;

    private boolean canceled;

    private boolean refused;

    private boolean payment;

    private boolean checkIn;

    private boolean checkOut;


    @ManyToOne(cascade={CascadeType.MERGE})
    @JoinColumn(name = "memberId")
    private Member member;

    @ManyToOne(cascade={CascadeType.MERGE})
    @JoinColumn(name = "hostelId")
    private Hostel hostel;

    @ManyToOne(cascade={CascadeType.MERGE})
    @JoinColumn(name = "roomId")
    private HostelRoom hostelRoom;
    /**
     * 创建时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date reserveTime;

    @Column
    private int amount;

    private double price;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date checkInTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date checkOutTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentTime;

    private String people;

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

    public HostelRoom getHostelRoom() {
        return hostelRoom;
    }

    public void setHostelRoom(HostelRoom hostelRoom) {
        this.hostelRoom = hostelRoom;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Hostel getHostel() {
        return hostel;
    }

    public void setHostel(Hostel hostel) {
        this.hostel = hostel;
    }

    public Date getReserveTime() {
        return reserveTime;
    }

    public void setReserveTime(Date reserveTime) {
        this.reserveTime = reserveTime;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
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


}
