package personal.darxan.hostel.dao;

import org.springframework.stereotype.Repository;
import personal.darxan.hostel.dao.base.BaseDao;
import personal.darxan.hostel.dao.base.LoginableDao;
import personal.darxan.hostel.model.Member;

/**
 * Created by darxan on 2017/2/15.
 */
@Repository
public class MemberDao extends LoginableDao<Member, Long> {
}
