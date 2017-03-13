package personal.darxan.hostel.model;

import org.hibernate.annotations.GenericGenerator;
import personal.darxan.hostel.model.base.Loginable;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by darxan on 2017/2/13.
 */
@Entity
public class Member extends Loginable {

    /**
     * 会员ID，扩充为七位数字时便是会员编码
     */
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "native")
    @GeneratedValue(generator = "idGenerator")
    private Long memberId;

    /**
     * 未激活
     * 激活
     * 暂停
     * 正常
     * 停止
     */
    @Column(columnDefinition="tinyint default 0")
    private Short state;

    /**
     * 会员最近一次状态更新时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    /**
     * 会员最近一次创建时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    /**
     * 余额
     */
    @Column(columnDefinition="decimal(10,2) default 0")
    private Double balance ;

    /**
     * 会员等级
     */
    @Column(columnDefinition="tinyint default 0")
    private Short level ;

    /**
     * 会员积分
     */
    @Column(columnDefinition="bigint default 0")
    private Long bonusPoint = 0L;

    @Column(length = 255)
    private String avatar;
    /**
     * 银行卡
     */
    @Column(length = 255, name = "bankCard")
    private String bankCard;

    @Column(length = 17)
    private String phone;

    @Column(length = 255)
    private String contact;


    @Column(length = 31)
    protected String name;

    @Column(length = 31)
    protected String password;


    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY,
            cascade={CascadeType.MERGE,CascadeType.REMOVE})
    private Set<Reservation> reservationSet;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY,
            cascade={CascadeType.MERGE,CascadeType.REMOVE})
    private Set<Payment> paymentSet;


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
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

    public Set<Reservation> getReservationSet() {
        return reservationSet;
    }

    public void setReservationSet(Set<Reservation> reservationSet) {
        this.reservationSet = reservationSet;
    }

    public Set<Payment> getPaymentSet() {
        return paymentSet;
    }

    public void setPaymentSet(Set<Payment> paymentSet) {
        this.paymentSet = paymentSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", state=" + state +
                ", updateTime=" + updateTime +
                ", balance=" + balance +
                ", level=" + level +
                ", bonusPoint=" + bonusPoint +
                ", avatar='" + avatar + '\'' +
                ", bankCard='" + bankCard + '\'' +
                ", phone='" + phone + '\'' +
                ", contact='" + contact + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", reservationSet=" + reservationSet +
                ", paymentSet=" + paymentSet +
                '}';
    }
}
