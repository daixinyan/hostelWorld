package personal.darxan.hostel.service.interf;

import personal.darxan.hostel.vo.HostelRoomVO;
import personal.darxan.hostel.vo.HostelVO;
import personal.darxan.hostel.vo.ServiceResult;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by darxan on 2017/2/17.
 */
public interface HostelService {

    public ServiceResult scheduleIncrement(HttpServletRequest httpServletRequest, Long id, int count);
    public ServiceResult updateSchedule(HttpServletRequest httpServletRequest, HostelRoomVO hostelRoom);
    public ServiceResult addSchedule(HttpServletRequest httpServletRequest, HostelRoomVO hostelRoom);
    public ServiceResult schedule(HttpServletRequest httpServletRequest);
    public ServiceResult updateHostel(HttpServletRequest httpServletRequest, HostelVO hostel);


    public ServiceResult verifyHostel(HttpServletRequest httpServletRequest, Long id, boolean pass);
    public ServiceResult getRoomById(HttpServletRequest httpServletRequest, Long id);

    public ServiceResult getHostels(HttpServletRequest httpServletRequest, Long id);

}
