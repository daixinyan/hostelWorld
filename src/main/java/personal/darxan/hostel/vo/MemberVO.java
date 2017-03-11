package personal.darxan.hostel.vo;

import personal.darxan.hostel.model.Payment;
import personal.darxan.hostel.model.Reservation;
import personal.darxan.hostel.vo.base.BaseVO;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by darxan on 2017/2/15.
 */
public class MemberVO extends BaseVO {

    private Long memberId;

    /**
     * 未激活
     * 激活
     * 暂停
     * 正常
     * 停止
     */
    private short state;

    /**
     * 会员最近一次状态更新时间
     */
    private Date updateTime;
    /**
     * 创建时间
     *
     */
    private Date createTime;

    /**
     * 余额
     */
    private double balance = 0;

    /**
     * 会员等级
     */
    private short level = 0;

    /**
     * 会员积分
     */
    private Long bonusPoint = 0L;

    /**
     * 银行卡
     */
    private String bankCard;

    private String phone;

    private String contact;

    protected String name;

    protected String password;

    private String avatar;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public short getState() {
        return state;
    }

    public void setState(short state) {
        this.state = state;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public short getLevel() {
        return level;
    }

    public void setLevel(short level) {
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
        return "MemberVO{" +
                "memberId=" + memberId +
                ", state=" + state +
                ", updateTime=" + updateTime +
                ", balance=" + balance +
                ", level=" + level +
                ", bonusPoint=" + bonusPoint +
                ", bankCard='" + bankCard + '\'' +
                ", phone='" + phone + '\'' +
                ", contact='" + contact + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MemberVO memberVO = (MemberVO) o;

        if (state != memberVO.state) return false;
        if (Double.compare(memberVO.balance, balance) != 0) return false;
        if (level != memberVO.level) return false;
        if (memberId != null ? !memberId.equals(memberVO.memberId) : memberVO.memberId != null) return false;
        if (updateTime != null ? !updateTime.equals(memberVO.updateTime) : memberVO.updateTime != null) return false;
        if (bonusPoint != null ? !bonusPoint.equals(memberVO.bonusPoint) : memberVO.bonusPoint != null) return false;
        if (bankCard != null ? !bankCard.equals(memberVO.bankCard) : memberVO.bankCard != null) return false;
        if (phone != null ? !phone.equals(memberVO.phone) : memberVO.phone != null) return false;
        if (contact != null ? !contact.equals(memberVO.contact) : memberVO.contact != null) return false;
        if (name != null ? !name.equals(memberVO.name) : memberVO.name != null) return false;
        return password != null ? password.equals(memberVO.password) : memberVO.password == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = memberId != null ? memberId.hashCode() : 0;
        result = 31 * result + (int) state;
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) level;
        result = 31 * result + (bonusPoint != null ? bonusPoint.hashCode() : 0);
        result = 31 * result + (bankCard != null ? bankCard.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (contact != null ? contact.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
