package personal.darxan.hostel.vo;

import personal.darxan.hostel.vo.base.BaseVO;

import java.util.Date;

/**
 * Created by darxan on 2017/2/15.
 */
public class AdministerVO extends BaseVO {

    private Long adminsterId;

    private Date createTime;

    protected String name;

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

    @Override
    public String toString() {
        return "AdministerVO{" +
                "adminsterId=" + adminsterId +
                ", createTime=" + createTime +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
