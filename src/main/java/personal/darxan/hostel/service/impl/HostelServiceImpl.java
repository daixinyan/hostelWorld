package personal.darxan.hostel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.darxan.hostel.dao.HostelDao;
import personal.darxan.hostel.dao.HostelRoomDao;
import personal.darxan.hostel.model.Hostel;
import personal.darxan.hostel.model.HostelRoom;
import personal.darxan.hostel.service.interf.HostelService;
import personal.darxan.hostel.tool.*;
import personal.darxan.hostel.vo.AdministerVO;
import personal.darxan.hostel.vo.HostelRoomVO;
import personal.darxan.hostel.vo.HostelVO;
import personal.darxan.hostel.vo.ServiceResult;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by darxan on 2017/2/17.
 */
@Service
public class HostelServiceImpl implements HostelService {

    @Autowired
    private HostelRoomDao hostelRoomDao;

    @Autowired
    private HostelDao hostelDao;

    public ServiceResult scheduleIncrement(HttpServletRequest httpServletRequest,
                                           Long id, int count){

        ServiceResult serviceResult = new ServiceResult(true);
        try {
            HostelVO hostelVO = (HostelVO) httpServletRequest
                    .getSession(false).getAttribute(StringConstant.SESSION_LOGIN);
            HostelRoom hostelRoom = hostelRoomDao.load(id);
            if (!hostelRoom.getHostel().getHostelId().equals(hostelVO.getHostelId())) {
                throw new Exception(StringConstant.AUTH_WRONG);
            }
            hostelRoom.setCount((short)(hostelRoom.getCount()+count));
            hostelRoomDao.update(hostelRoom);
        }catch (Exception e) {
            e.printStackTrace();
            serviceResult.setMessage(e.getMessage());
            serviceResult.setSuccess(false);
        }
        return serviceResult;
    }

    public ServiceResult schedule(HttpServletRequest httpServletRequest){

        ServiceResult serviceResult = new ServiceResult(true);
        try {
            HostelVO hostelVO = (HostelVO) httpServletRequest
                    .getSession(false).getAttribute(StringConstant.SESSION_LOGIN);
            Hostel hostel = hostelDao.load(hostelVO.getHostelId());

            MyLogger.log(hostel);

            Set<HostelRoom> hostelEntities = hostel.getHostelRoomSet();

            MyLogger.log(hostelEntities.size());
            MyLogger.log(hostelEntities);

            List<HostelRoomVO> roomVOList = new ArrayList<HostelRoomVO>(hostelEntities.size());
            for (HostelRoom room:hostelEntities) {
                roomVOList.add(Convert.convert(room));
            }
            serviceResult.setValue(new MyPair<HostelVO,List>(hostelVO,roomVOList));

        }catch (Exception e) {
            e.printStackTrace();
            serviceResult.setMessage(e.getMessage());
            serviceResult.setSuccess(false);
        }
        return serviceResult;
    }

    public ServiceResult updateSchedule(HttpServletRequest httpServletRequest,
                                        HostelRoomVO hostelRoom) {
        ServiceResult serviceResult = new ServiceResult(true);
        try {
            HostelVO hostelVO = (HostelVO) httpServletRequest
                    .getSession(false).getAttribute(StringConstant.SESSION_LOGIN);
            HostelRoom hostelRoomEntity = Convert.convert(hostelRoom);
            HostelRoom hostelRoomPersistent = hostelRoomDao.load(hostelRoom.getRoomId());
            if (!hostelRoomPersistent.getHostel().getHostelId().equals(hostelVO.getHostelId())) {
                throw new Exception(StringConstant.AUTH_WRONG);
            }
            AttributeUpdate.update(hostelRoomPersistent, hostelRoomEntity, HostelRoom.class);
            hostelRoomDao.update(hostelRoomPersistent);
        }catch (Exception e) {
            e.printStackTrace();
            serviceResult.setMessage(e.getMessage());
            serviceResult.setSuccess(false);
        }
        return serviceResult;
    }



    public ServiceResult addSchedule(HttpServletRequest httpServletRequest,
                                     HostelRoomVO hostelRoom) {
        ServiceResult serviceResult = new ServiceResult(true);
        try {
            HostelVO hostelVO = (HostelVO) httpServletRequest
                    .getSession(false).getAttribute(StringConstant.SESSION_LOGIN);
            HostelRoom hostelRoomEntity = Convert.convert(hostelRoom);
            hostelRoomEntity.setHostel(Convert.convert(hostelVO));
            hostelRoomDao.save(hostelRoomEntity);
        }catch (Exception e) {
            e.printStackTrace();
            serviceResult.setMessage(e.getMessage());
            serviceResult.setSuccess(false);
        }
        return serviceResult;
    }


    public ServiceResult updateHostel(HttpServletRequest httpServletRequest,
                                      HostelVO updatedHostelVO){

        ServiceResult serviceResult = new ServiceResult(true);
        try {

            Object login = httpServletRequest.
                    getSession(false).getAttribute(StringConstant.SESSION_LOGIN);
            boolean hostelAuth = (login instanceof HostelVO) &&
                    ((HostelVO) login).getHostelId().equals(updatedHostelVO.getHostelId());
            boolean adminAuth = (login instanceof AdministerVO);
            if ( !hostelAuth && !adminAuth) {
                throw new Exception(StringConstant.AUTH_WRONG);
            }

            Hostel hostelEntity = Convert.convert(updatedHostelVO);
            MyLogger.log(hostelEntity);

            Hostel hostelPersistent = hostelDao.get(updatedHostelVO.getHostelId());
            AttributeUpdate.update(hostelPersistent, hostelEntity, Hostel.class);
            if (hostelAuth){
                AttributeUpdate.update((HostelVO) login, updatedHostelVO, HostelVO.class);
                serviceResult.setValue((HostelVO) login);
            }
            hostelDao.update(hostelPersistent);
        }catch (Exception e) {
            e.printStackTrace();
            serviceResult.setMessage(e.getMessage());
            serviceResult.setSuccess(false);
        }
        return serviceResult;
    }


    public ServiceResult updateHostel(HostelVO updatedHostelVO){

        ServiceResult serviceResult = new ServiceResult(true);
        try {
            Hostel hostelEntity = Convert.convert(updatedHostelVO);
            Hostel hostelPersistent = hostelDao.get(updatedHostelVO.getHostelId());
            AttributeUpdate.update(hostelPersistent, hostelEntity, Hostel.class);
            hostelDao.update(hostelPersistent);
        }catch (Exception e) {
            e.printStackTrace();
            serviceResult.setMessage(e.getMessage());
            serviceResult.setSuccess(false);
        }
        return serviceResult;
    }

    public ServiceResult verifyHostel(HttpServletRequest httpServletRequest,
                                      Long id, boolean pass){

        ServiceResult serviceResult = new ServiceResult(true);
        try {
            AdministerVO administerVO =
                    (AdministerVO) httpServletRequest
                            .getSession(false)
                            .getAttribute(StringConstant.SESSION_LOGIN);
            Hostel hostel = hostelDao.load(id);
            hostel.setState((short)1);
            hostelDao.update(hostel);
        }catch (Exception e) {
            e.printStackTrace();
            serviceResult.setMessage(e.getMessage());
            serviceResult.setSuccess(false);
        }
        return serviceResult;
    }


    public ServiceResult getRoomById(
            HttpServletRequest httpServletRequest, Long id) {

        ServiceResult serviceResult = new ServiceResult(true);
        try {
            HostelRoom hostelRoom = hostelRoomDao.load(id);
            serviceResult.setValue(Convert.convert(hostelRoom));
        }catch (Exception e) {
            e.printStackTrace();
            serviceResult.setMessage(e.getMessage());
            serviceResult.setSuccess(false);
        }
        return serviceResult;
    }

    public ServiceResult getHostels(
            HttpServletRequest httpServletRequest, Long id) {

        ServiceResult serviceResult = new ServiceResult();
        try {
            Hostel hostel = hostelDao.get(id);
            Collection<HostelRoom> hostelRoomCollection = hostel.getHostelRoomSet();

            HostelVO hostelVO = Convert.convert(hostel);
            List<HostelRoomVO> hostelRoomVOList =
                    new ArrayList<HostelRoomVO>(hostelRoomCollection.size());
            for (HostelRoom hostelRoom:hostelRoomCollection) {
                hostelRoomVOList.add(Convert.convert(hostelRoom, false));
            }
            serviceResult.setValue(new MyPair(hostelVO, hostelRoomVOList));

        }catch (Exception e) {
            e.printStackTrace();
            serviceResult.setMessage(e.getMessage());
            serviceResult.setSuccess(false);
        }
        return serviceResult;
    }
}
