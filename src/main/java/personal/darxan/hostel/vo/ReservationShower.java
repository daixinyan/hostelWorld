package personal.darxan.hostel.vo;

import java.util.Date;

/**
 * Created by darxan on 2017/2/19.
 */
public class ReservationShower {

    private Long reservationId;

    private boolean reserved;

    private boolean canceled;

    private boolean refused;

    private boolean payment;

    private boolean checkIn;

    private boolean checkOut;


    private Long memberId;

    private Long hostelId;

    private Long roomId;
    /**
     * 创建时间
     */
    private Date createTime;

    private double amount;

    private String add_1;

    private String add_2;

    private String add_3;

    private String add_4;

    private String address;

    private String phone;

    private String contact;
    /**
     * 客栈名字
     */
    private String hostel;

}
