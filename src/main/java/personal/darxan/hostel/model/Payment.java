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
}
