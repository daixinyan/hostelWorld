package personal.darxan.hostel.model;

import org.hibernate.annotations.GenericGenerator;
import personal.darxan.hostel.model.base.Loginable;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by darxan on 2017/2/14.
 */
@Entity
public class Hostel extends Loginable {

    /**
     * 会ID，扩充为七位数字时便是客栈编码
     */
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "native")
    @GeneratedValue(generator = "idGenerator")
    private Long hostelId;



    /**
     * 客栈状态：
     *  申请中；
     *  审核通过；
     *  审核不通过；
     */
    private short state;

    @Column(length = 255)
    private String add_1;

    @Column(length = 255)
    private String add_2;

    @Column(length = 255)
    private String add_3;

    @Column(length = 255)
    private String add_4;

    @Column(length = 255)
    private String address;

    @Column(length = 15)
    private String phone;

    @Column(length = 255)
    private String contact;


    @Column(length = 255)
    private String bankcard;

    /**
     * 客栈名字
     */
    @Column(length = 255)
    private String hostel;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Column(length = 31)
    protected String name;

    @Column(length = 31)
    protected String password;

    @Column(length = 255)
    private String image;

    @OneToMany(mappedBy = "hostel", fetch = FetchType.LAZY,
            cascade={CascadeType.MERGE,CascadeType.REMOVE})
    private Set<Reservation> reservationSet;

    @OneToMany(mappedBy = "hostel", fetch = FetchType.LAZY,
            cascade={CascadeType.MERGE,CascadeType.REMOVE})
    private Set<Payment> paymentSet;

    @OneToMany(mappedBy = "hostel", fetch = FetchType.LAZY)
    private Set<HostelRoom> hostelRoomSet;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getHostelId() {
        return hostelId;
    }

    public void setHostelId(Long hostelId) {
        this.hostelId = hostelId;
    }

    public short getState() {
        return state;
    }

    public void setState(short state) {
        this.state = state;
    }

    public String getAdd_1() {
        return add_1;
    }

    public void setAdd_1(String add_1) {
        this.add_1 = add_1;
    }

    public String getAdd_2() {
        return add_2;
    }

    public void setAdd_2(String add_2) {
        this.add_2 = add_2;
    }

    public String getAdd_3() {
        return add_3;
    }

    public void setAdd_3(String add_3) {
        this.add_3 = add_3;
    }

    public String getAdd_4() {
        return add_4;
    }

    public void setAdd_4(String add_4) {
        this.add_4 = add_4;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getBankcard() {
        return bankcard;
    }

    public void setBankcard(String bankcard) {
        this.bankcard = bankcard;
    }

    public String getHostel() {
        return hostel;
    }

    public void setHostel(String hostel) {
        this.hostel = hostel;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public Set<HostelRoom> getHostelRoomSet() {
        return hostelRoomSet;
    }

    public void setHostelRoomSet(Set<HostelRoom> hostelRoomSet) {
        this.hostelRoomSet = hostelRoomSet;
    }


    @Override
    public String toString() {
        return "Hostel{" +
                "hostelId=" + hostelId +
                ", state=" + state +
                ", add_1='" + add_1 + '\'' +
                ", add_2='" + add_2 + '\'' +
                ", add_3='" + add_3 + '\'' +
                ", add_4='" + add_4 + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", contact='" + contact + '\'' +
                ", bankcard='" + bankcard + '\'' +
                ", hostel='" + hostel + '\'' +
                ", createTime=" + createTime +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
