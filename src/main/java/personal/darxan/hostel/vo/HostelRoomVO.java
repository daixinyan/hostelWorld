package personal.darxan.hostel.vo;

import java.util.Date;

/**
 * Created by darxan on 2017/2/17.
 */
public class HostelRoomVO {

    private Long roomId;

    private Long hostelId;

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


    private java.util.Date createTime;

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

    public java.util.Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

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

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "HostelRoomVO{" +
                "roomId=" + roomId +
                ", hostelId=" + hostelId +
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
}
