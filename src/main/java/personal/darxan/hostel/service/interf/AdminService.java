package personal.darxan.hostel.service.interf;

import personal.darxan.hostel.vo.SearchRestrict;
import personal.darxan.hostel.vo.ServiceResult;
import personal.darxan.hostel.vo.UsersRestrict;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by darxan on 2017/2/17.
 */
public interface AdminService {

    public ServiceResult payHostel(HttpServletRequest httpServletRequest, Long id);

    public ServiceResult listHostels(HttpServletRequest httpServletRequest, UsersRestrict restrict) ;

    public ServiceResult listUsers(HttpServletRequest httpServletRequest, UsersRestrict restrict) ;
}
