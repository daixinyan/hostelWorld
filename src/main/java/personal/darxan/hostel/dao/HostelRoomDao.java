package personal.darxan.hostel.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import personal.darxan.hostel.dao.base.BaseDao;
import personal.darxan.hostel.dao.base.SQLAppend;
import personal.darxan.hostel.model.HostelRoom;
import personal.darxan.hostel.vo.PaginationResult;
import personal.darxan.hostel.vo.SearchRestrict;

/**
 * Created by darxan on 2017/2/17.
 */
@Repository
public class HostelRoomDao extends BaseDao<HostelRoom, Long> {

    public PaginationResult search(
            Long lower, Long upper, int skip, SearchRestrict searchRestrict) {

        SQLAppend sqlAppend = new SQLAppend(getSession(),"HostelRoom", "hostel");
        sqlAppend.addEq("numOfBed", searchRestrict.getNumOfBed());
        sqlAppend.addGT("hostelId", lower);
        sqlAppend.addLT("hostelId", upper);
        sqlAppend.addEq("airCondition", searchRestrict.getAirCondition());
        sqlAppend.addEq("capacity", searchRestrict.getCapacity());
        sqlAppend.addEq("numOfBed", searchRestrict.getNumOfBed());
        sqlAppend.addEq("computer", searchRestrict.getComputer());
        sqlAppend.addEq("add1", searchRestrict.getAdd1());
        sqlAppend.addEq("add2", searchRestrict.getAdd2());
        sqlAppend.addEq("add3", searchRestrict.getAdd3());
        sqlAppend.addEq("add4", searchRestrict.getAdd4());
        sqlAppend.addLike("description", searchRestrict.getKeyword());
        sqlAppend.addLike("address", searchRestrict.getAddress());
        sqlAppend.addOrder(searchRestrict.getOrder(), searchRestrict.isAsc());

        if (searchRestrict.getDateLower()!=null&&searchRestrict.getDateUpper()!=null) {
            sqlAppend.addGE("endDate", "?");
            sqlAppend.addLE("startDate", "?");
        }
        Query query = sqlAppend.fetchCount();
        if (searchRestrict.getDateLower()!=null&&searchRestrict.getDateUpper()!=null) {
            query.setDate(0, searchRestrict.getDateLower());
            query.setDate(1, searchRestrict.getDateUpper());
        }


        PaginationResult paginationResult = new PaginationResult();
        paginationResult.setTotalPages(Integer.parseInt(query.uniqueResult().toString()));


        query = sqlAppend.fetchList();
        if (searchRestrict.getDateLower()!=null&&searchRestrict.getDateUpper()!=null) {
            query.setDate(0, searchRestrict.getDateLower());
            query.setDate(1, searchRestrict.getDateUpper());
        }
        query.setMaxResults(searchRestrict.getPageSize());
        query.setFirstResult(skip);
        paginationResult.setItems(query.list());

        return paginationResult;
    }

}
