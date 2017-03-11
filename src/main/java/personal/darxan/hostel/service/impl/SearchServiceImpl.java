package personal.darxan.hostel.service.impl;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import personal.darxan.hostel.dao.HostelRoomDao;
import personal.darxan.hostel.logic.cache.impl.PageBorder;
import personal.darxan.hostel.logic.cache.impl.SearchCache;
import personal.darxan.hostel.logic.cache.interf.CacheManager;
import personal.darxan.hostel.model.HostelRoom;
import personal.darxan.hostel.service.interf.SearchService;
import personal.darxan.hostel.tool.Convert;
import personal.darxan.hostel.vo.HostelRoomVO;
import personal.darxan.hostel.vo.PaginationResult;
import personal.darxan.hostel.vo.SearchRestrict;
import personal.darxan.hostel.vo.ServiceResult;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by darxan on 2017/2/17.
 */
@Service
public class SearchServiceImpl implements SearchService{

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private HostelRoomDao hostelRoomDao;

    private static final boolean enableCache = false;

    public ServiceResult search(SearchRestrict searchRestrict,
                                HttpServletRequest httpServletRequest) {
        SearchCache searchCache = null;
        ServiceResult serviceResult = new ServiceResult(true);


        Long lower = null;
        Long upper = null;
        int skip = (searchRestrict.getPageSize())*(searchRestrict.getPage()-1);

        if ( (searchRestrict.getOrder()==null||searchRestrict.getOrder().trim().length()==0)
                &&enableCache) {
            //默认排序可以使用缓存
            Object searchRestrictCache = cacheManager.get(searchRestrict);
            if (searchRestrictCache!=null && searchRestrictCache instanceof SearchCache) {
                searchCache = (SearchCache)searchRestrictCache;
            }
            if (searchCache!=null) {
                PageBorder pageBorder = searchCache.getNearestPageBorder(searchRestrict.getPage());
                if (pageBorder!=null) {
                    if (pageBorder.getPage()<searchRestrict.getPage()) {
                        lower = pageBorder.getUpper();
                        skip = (searchRestrict.getPageSize())*(searchRestrict.getPage()-(int)pageBorder.getPage()-1);
                    }else {
                        upper = pageBorder.getLower();
                        searchRestrict.setAsc(!searchRestrict.isAsc());
                        skip  = (searchRestrict.getPageSize())*((int)pageBorder.getPage()-searchRestrict.getPage()-1);
                    }
                }
            }
        }


        try {

            PaginationResult paginationResult = hostelRoomDao.search(lower, upper, skip, searchRestrict);

            List<HostelRoom> hostelRoomList = paginationResult.getItems();
            List<HostelRoomVO> hostelRoomVOList = new ArrayList<HostelRoomVO>(hostelRoomList.size());
            for (HostelRoom roomEntity:hostelRoomList) {
                hostelRoomVOList.add(Convert.convert(roomEntity));
            }
            paginationResult.setItems(hostelRoomVOList);
            serviceResult.setValue(paginationResult);

            if ( (searchRestrict.getOrder()==null||searchRestrict.getOrder().trim().length()==0)
                    && enableCache) {
                //默认排序可以使用缓存
                if (searchCache==null ) {
                   searchCache = new SearchCache();
                }
                PageBorder pageBorder = new PageBorder();
                pageBorder.setPage(searchRestrict.getPage());

                if (searchRestrict.isAsc()) {
                    pageBorder.setLower(hostelRoomList.get(0).getRoomId());
                    pageBorder.setUpper(hostelRoomList.get(hostelRoomList.size()-1).getRoomId());
                } else {
                    pageBorder.setUpper(hostelRoomList.get(0).getRoomId());
                    pageBorder.setLower(hostelRoomList.get(hostelRoomList.size()-1).getRoomId());
                }

                searchCache.addPageBorder(pageBorder);
                cacheManager.put(searchRestrict, searchCache);
            }
        }catch (HibernateException e) {
            serviceResult.setSuccess(false);
            serviceResult.setMessage(e.getMessage());
            e.printStackTrace();
        }


        return serviceResult;
    }

}
