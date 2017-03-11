package personal.darxan.hostel.model;

import org.hibernate.annotations.GenericGenerator;
import personal.darxan.hostel.model.base.BaseTable;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by darxan on 2017/2/14.
 */
@Entity
public class Payment extends BaseTable {


    @Id
    @GenericGenerator(name = "idGenerator", strategy = "native")
    @GeneratedValue(generator = "idGenerator")
    private Long paymentId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservationId")
    private Reservation reservation;

    @ManyToOne
    @JoinColumn(name = "hostelId")
    private Hostel hostel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private Member member;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    private short payType;

    @Column(columnDefinition="decimal(10,2) default 0")
    private double amount;

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Hostel getHostel() {
        return hostel;
    }

    public void setHostel(Hostel hostel) {
        this.hostel = hostel;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public short getPayType() {
        return payType;
    }

    public void setPayType(short payType) {
        this.payType = payType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
