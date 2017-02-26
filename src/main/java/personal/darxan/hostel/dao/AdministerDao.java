package personal.darxan.hostel.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import personal.darxan.hostel.dao.base.LoginableDao;
import personal.darxan.hostel.model.Administer;

/**
 * Created by darxan on 2017/2/15.
 */
@Repository
public class AdministerDao extends LoginableDao<Administer, Long> {
}
