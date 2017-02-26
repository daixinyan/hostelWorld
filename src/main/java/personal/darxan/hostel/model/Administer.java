package personal.darxan.hostel.model;

import org.hibernate.annotations.GenericGenerator;
import personal.darxan.hostel.model.base.Loginable;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by darxan on 2017/2/15.
 */
@Entity
public class Administer extends Loginable{

    /**
     * 管理员ID
     */
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "native")
    @GeneratedValue(generator = "idGenerator")
    private Long adminsterId;


    /**
     * 创建时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Column(length = 31)
    protected String name;

    @Column(length = 31)
    protected String password;


    public Long getAdminsterId() {
        return adminsterId;
    }

    public void setAdminsterId(Long adminsterId) {
        this.adminsterId = adminsterId;
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
}
