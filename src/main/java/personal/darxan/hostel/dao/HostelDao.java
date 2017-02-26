package personal.darxan.hostel.dao;

import org.springframework.stereotype.Repository;
import personal.darxan.hostel.dao.base.LoginableDao;
import personal.darxan.hostel.model.Hostel;

/**
 * Created by darxan on 2017/2/15.
 */
@Repository
public class HostelDao extends LoginableDao<Hostel, Long> {
}
