package personal.darxan.hostel.service.interf;

import personal.darxan.hostel.vo.SearchRestrict;
import personal.darxan.hostel.vo.ServiceResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by darxan on 2017/2/16.
 */
public interface SearchService {

    public ServiceResult search(SearchRestrict searchRestrict, HttpServletRequest httpServletRequest);
}
