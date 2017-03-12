package personal.darxan.hostel.vo;

import personal.darxan.hostel.model.HostelRoom;

import java.util.Date;
import java.util.List;

/**
 * Created by darxan on 2017/2/15.
 */
public class HostelVO {

    private Long hostelId;

    protected String name;

    protected String password;

    private double balance;
    /**
     * 客栈状态：
     *  申请中；
     *  审核通过；
     *  审核不通过；
     */
    private short state;

    private String add_1;

    private String add_2;

    private String add_3;

    private String add_4;

    private String address;

    private String phone;

    private String contact;

    private String bankcard;

    /**
     * 客栈名字
     */
    private String hostel;


    private Date createTime;

    private String image;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

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

    @Override
    public String toString() {
        return "HostelVO{" +
                "hostelId=" + hostelId +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
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
                ", image='" + image + '\'' +
                '}';
    }
}
