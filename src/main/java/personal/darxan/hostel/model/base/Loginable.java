package personal.darxan.hostel.model.base;


/**
 * Created by darxan on 2017/2/15.
 */
public abstract class Loginable extends BaseTable{


    public abstract String getName();

    public abstract void setName(String name) ;

    public abstract String getPassword() ;

    public abstract void setPassword(String password);
}
