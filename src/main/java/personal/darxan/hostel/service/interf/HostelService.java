package personal.darxan.hostel.service.interf;

import personal.darxan.hostel.vo.HostelRoomVO;
import personal.darxan.hostel.vo.HostelVO;
import personal.darxan.hostel.vo.ServiceResult;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by darxan on 2017/2/17.
 */
 public interface HostelService {

     ServiceResult scheduleIncrement(HttpServletRequest httpServletRequest, Long id, int count);
     ServiceResult updateSchedule(HttpServletRequest httpServletRequest, HostelRoomVO hostelRoom);
     ServiceResult addSchedule(HttpServletRequest httpServletRequest, HostelRoomVO hostelRoom);
     ServiceResult schedule(HttpServletRequest httpServletRequest);
     ServiceResult updateHostel(HttpServletRequest httpServletRequest, HostelVO hostel);


     ServiceResult verifyHostel(HttpServletRequest httpServletRequest, Long id, boolean pass);
     ServiceResult getRoomById(HttpServletRequest httpServletRequest, Long id);

     ServiceResult getHostels(HttpServletRequest httpServletRequest, Long id);

     ServiceResult state(HttpServletRequest httpServletRequest, Short state);
}
