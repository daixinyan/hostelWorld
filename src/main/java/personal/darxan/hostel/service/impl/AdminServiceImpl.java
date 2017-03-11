package personal.darxan.hostel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.darxan.hostel.dao.HostelDao;
import personal.darxan.hostel.dao.MemberDao;
import personal.darxan.hostel.dao.ReservationDao;
import personal.darxan.hostel.model.Hostel;
import personal.darxan.hostel.model.Member;
import personal.darxan.hostel.model.Payment;
import personal.darxan.hostel.service.interf.AdminService;
import personal.darxan.hostel.tool.Convert;
import personal.darxan.hostel.vo.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by darxan on 2017/2/17.
 */
@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private ReservationDao reservationDao;
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private HostelDao hostelDao;

    public ServiceResult payHostel(
            HttpServletRequest httpServletRequest, Long id) {
        ServiceResult serviceResult = new ServiceResult();
        try {
            Hostel hostel = hostelDao.load(id);
            BigDecimal decimal = null;
            Payment payment = new Payment();
        }catch (Exception e) {
            serviceResult.setMessage(e.getMessage());
            serviceResult.setSuccess(false);
            e.printStackTrace();
        }
        return serviceResult;
    }

    public ServiceResult listHostels(
            HttpServletRequest httpServletRequest, UsersRestrict restrict) {
        ServiceResult serviceResult = new ServiceResult(true);
        try {
            PaginationResult paginationResult = hostelDao.search(restrict);
            List<Hostel> hostelList = paginationResult.getItems();
            List<HostelVO> hostelVOS = new ArrayList<HostelVO>(hostelList.size());
            for (Hostel hostel: hostelList) {
                hostelVOS.add(Convert.convert(hostel));
            }
            paginationResult.setItems(hostelVOS);
            serviceResult.setValue(paginationResult);
        }catch (Exception e) {
            serviceResult.setMessage(e.getMessage());
            serviceResult.setSuccess(false);
            e.printStackTrace();
        }
        return serviceResult;
    }

    public ServiceResult listUsers(
            HttpServletRequest httpServletRequest, UsersRestrict restrict) {
        ServiceResult serviceResult = new ServiceResult(true);
        try {
            PaginationResult paginationResult = memberDao.search(restrict);
            List<Member> memberList = paginationResult.getItems();
            List<MemberVO> memberVOS = new ArrayList<MemberVO>(memberList.size());
            for (Member member:memberList) {
                memberVOS.add(Convert.convert(member));
            }
            paginationResult.setItems(memberVOS);
            serviceResult.setValue(paginationResult);
        }catch (Exception e) {
            serviceResult.setMessage(e.getMessage());
            serviceResult.setSuccess(false);
            e.printStackTrace();
        }
        return serviceResult;
    }
}
