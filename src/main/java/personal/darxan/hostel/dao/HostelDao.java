package personal.darxan.hostel.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import personal.darxan.hostel.dao.base.BaseDao;
import personal.darxan.hostel.dao.base.SQLAppend;
import personal.darxan.hostel.model.Hostel;
import personal.darxan.hostel.tool.MyPair;
import personal.darxan.hostel.vo.PaginationResult;
import personal.darxan.hostel.vo.UsersRestrict;

import java.util.List;

/**
 * Created by darxan on 2017/2/15.
 */
@Repository
public class HostelDao extends BaseDao<Hostel, Long> {

    public PaginationResult search(UsersRestrict usersRestrict) {
        SQLAppend sqlAppend = new SQLAppend(getSession(), "Hostel");
        sqlAppend.addLike("hostel", usersRestrict.getKeyword());
        sqlAppend.addLike("name", usersRestrict.getKeyword());
        if (usersRestrict.getDateLower()!=null&&usersRestrict.getDateUpper()!=null) {
            sqlAppend.addGE("createTime", "?");
            sqlAppend.addLE("createTime", "?");
        }
        Query query = sqlAppend.fetchCount();
        if (usersRestrict.getDateLower()!=null&&usersRestrict.getDateUpper()!=null) {
            query.setDate(0, usersRestrict.getDateLower());
            query.setDate(1, usersRestrict.getDateUpper());
        }
        PaginationResult paginationResult = new PaginationResult();
        paginationResult.setTotalPages(Integer.parseInt(query.uniqueResult().toString()));

        query = sqlAppend.fetchList();
        if (usersRestrict.getDateLower()!=null&&usersRestrict.getDateUpper()!=null) {
            query.setDate(0, usersRestrict.getDateLower());
            query.setDate(1, usersRestrict.getDateUpper());
        }
        query.setFirstResult(usersRestrict.getPageSize()*(usersRestrict.getPage()-1));
        query.setMaxResults(usersRestrict.getPageSize());
        List list = query.list();
        paginationResult.setItems(list);

        return paginationResult;
    }
}
