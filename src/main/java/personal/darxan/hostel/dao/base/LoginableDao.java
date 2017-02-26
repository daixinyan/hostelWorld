package personal.darxan.hostel.dao.base;

import personal.darxan.hostel.model.base.Loginable;

import java.io.Serializable;

/**
 * Created by darxan on 2017/2/15.
 */
public class LoginableDao<T extends Loginable, ID extends Serializable>
        extends BaseDao<T,ID> {

    public T getByName(String name) {
        return getByPair("name", name);
    }
}
