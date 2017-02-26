package personal.darxan.hostel.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import personal.darxan.hostel.dao.base.BaseDao;
import personal.darxan.hostel.model.Payment;

import java.util.List;

/**
 * Created by darxan on 2017/2/19.
 */
@Repository
public class PaymentDao extends BaseDao<Payment, Long> {

    public List<Payment> getByUser(Long userId, int skip, int pageSize) {
        Query query = getSession().createQuery("from Payment ");
        query.setParameter((int)1, userId);
        query.setFirstResult(skip);
        query.setMaxResults(pageSize);
        return query.list();
    }

    public List<Payment> getByHostel(Long hostelId, int skip, int pageSize) {
        Query query = getSession().createQuery("from Payment where ");
        query.setParameter((int)1, hostelId);
        query.setFirstResult(skip);
        query.setMaxResults(pageSize);
        return query.list();
    }
}
