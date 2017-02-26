package personal.darxan.hostel.service.interf;

import personal.darxan.hostel.vo.ServiceResult;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by darxan on 2017/2/17.
 */
public interface AdminService {

    public ServiceResult payHostel(HttpServletRequest httpServletRequest, Object id);
    public ServiceResult finance(HttpServletRequest httpServletRequest);

}
