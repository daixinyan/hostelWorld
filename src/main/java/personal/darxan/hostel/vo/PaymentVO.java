package personal.darxan.hostel.vo;

import sun.rmi.runtime.Log;

import java.util.Date;

/**
 * Created by darxan on 2017/2/15.
 */
public class PaymentVO {

    private Long paymentId;


    private Long reservationId;

    private Long hostelId;

    private Long memberId;

    private Date createTime;

    private Short payType;

    private double amount;
}
