package personal.darxan.hostel.model;

import org.hibernate.annotations.GenericGenerator;
import personal.darxan.hostel.model.base.BaseTable;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by darxan on 2017/2/16.
 */
@Entity
public class HostelRoom extends BaseTable{

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "native")
    @GeneratedValue(generator = "idGenerator")
    private Long roomId;

    @ManyToOne
    @JoinColumn(name = "hostelId")
    private Hostel hostel;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
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

    public Hostel getHostel() {
        return hostel;
    }

    public void setHostel(Hostel hostel) {
        this.hostel = hostel;
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
}
