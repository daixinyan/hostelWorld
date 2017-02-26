package personal.darxan.hostel.vo;

import personal.darxan.hostel.vo.base.BaseVO;

/**
 * Created by darxan on 2017/2/15.
 */
public class LoginVO extends BaseVO {

    protected String name;

    protected String password;

    protected String loginType;

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

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    @Override
    public String toString() {
        return "LoginVO{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", loginType='" + loginType + '\'' +
                '}';
    }
}
