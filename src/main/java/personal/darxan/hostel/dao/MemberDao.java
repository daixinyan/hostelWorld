package personal.darxan.hostel.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import personal.darxan.hostel.dao.base.BaseDao;
import personal.darxan.hostel.dao.base.SQLAppend;
import personal.darxan.hostel.model.Member;
import personal.darxan.hostel.tool.MyLogger;
import personal.darxan.hostel.vo.PaginationResult;
import personal.darxan.hostel.vo.UsersRestrict;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by darxan on 2017/2/15.
 */
@Repository
public class MemberDao extends BaseDao<Member, Long> {

    public PaginationResult search(UsersRestrict usersRestrict) {
        SQLAppend sqlAppend = new SQLAppend(getSession(), "Member");
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


    public Object updateNearlyNoPaymentMember(Date dateLimit) {

        String hql = "update  from Member member set member.state=? where member.updateTime<?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, -1);

        //last year
        query.setParameter(1, dateLimit);
        return query.executeUpdate();
    }

    public static void main(String args[]) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR)-1);
        MyLogger.log(calendar.getTime());
    }
}
