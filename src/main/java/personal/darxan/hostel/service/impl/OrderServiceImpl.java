package personal.darxan.hostel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.darxan.hostel.dao.HostelRoomDao;
import personal.darxan.hostel.dao.MemberDao;
import personal.darxan.hostel.dao.ReservationDao;
import personal.darxan.hostel.model.HostelRoom;
import personal.darxan.hostel.model.Member;
import personal.darxan.hostel.model.Reservation;
import personal.darxan.hostel.service.interf.OrderService;
import personal.darxan.hostel.tool.Convert;
import personal.darxan.hostel.tool.MyFunction;
import personal.darxan.hostel.tool.StringConstant;
import personal.darxan.hostel.vo.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by darxan on 2017/2/17.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ReservationDao reservationDao;

    @Autowired
    private HostelRoomDao hostelRoomDao;

    @Autowired
    private MemberDao memberDao;

    private ServiceResult updateReservation(HttpServletRequest httpServletRequest,
                                            Long reservationId,
                                            MyFunction<Object, Reservation> reservationMyFunction) {
        ServiceResult serviceResult = new ServiceResult(true);
        try {

            HostelVO hostelVO = (HostelVO) httpServletRequest
                    .getSession(false).getAttribute(StringConstant.SESSION_LOGIN);
            Reservation reservation = reservationDao.get(reservationId);
            if (reservation.getHostel().getHostelId().equals(hostelVO.getHostelId())) {
                reservationMyFunction.execute(reservation);
                reservation.setUpdateTime(new Date());
                reservationDao.update(reservation);
            } else {
                serviceResult.setSuccess(false);
                serviceResult.setMessage(StringConstant.AUTH_WRONG);
            }
        }catch (Exception e) {
            serviceResult.setSuccess(false);
            serviceResult.setMessage(e.getMessage());
        }
        return serviceResult;
    }

    public ServiceResult checkIn(final CheckIn checkIn,
                                 final HttpServletRequest httpServletRequest) {

        return updateReservation(httpServletRequest, checkIn.getReservationId(),
                new MyFunction<Object, Reservation>() {
                    public Object execute(Reservation reservation) {

                        reservation.setCheckIn(true);
                        reservation.setCheckInTime(new Date());
                        reservation.setPeople(checkIn.getPeople());
                        return null;
                    }
                });
    }

    public ServiceResult checkOut(final CheckOut checkOut,
                                  HttpServletRequest httpServletRequest) {
        return updateReservation(httpServletRequest, checkOut.getReservationId(),
                new MyFunction<Object, Reservation>() {
                    public Object execute(Reservation reservation) {

                        reservation.setCheckOut(true);
                        reservation.setCheckOutTime(new Date());
                        reservationDao.update(reservation);
                        return null;
                    }
                });
    }

    public ServiceResult cancel(Long reservationId,
                                HttpServletRequest httpServletRequest) {

        ServiceResult serviceResult = new ServiceResult(true);
        try {

            MemberVO memberVO = (MemberVO) httpServletRequest
                    .getSession(false).getAttribute(StringConstant.SESSION_LOGIN);
            Reservation reservation = reservationDao.load(reservationId);
            if (reservation.getMember().getMemberId().equals(memberVO.getMemberId())) {
                reservation.setCanceled(true);
                reservationDao.update(reservation);
            }else {
                serviceResult.setSuccess(false);
                serviceResult.setMessage(StringConstant.AUTH_WRONG);
            }

        }catch (Exception e) {
            serviceResult.setSuccess(false);
            serviceResult.setMessage(e.getMessage());
        }
        return serviceResult;

    }

    public ServiceResult reserve(ReservationVO reservationVO,
                                 HttpServletRequest httpServletRequest) {

        ServiceResult serviceResult = new ServiceResult(true);
        try {

            MemberVO memberVO = (MemberVO) httpServletRequest
                    .getSession(false).getAttribute(StringConstant.SESSION_LOGIN);
            Reservation reservation = new Reservation();

            HostelRoom hostelRoom = hostelRoomDao.load(reservationVO.getRoomId());
            reservation.setRefused(true);
            reservation.setUpdateTime(new Date());
            reservation.setMember(memberDao.load(memberVO.getMemberId()));
            reservation.setPrice(hostelRoom.getPrice());
            reservation.setAmount(reservationVO.getAmount());
            reservation.setHostel(hostelRoom.getHostel());
            reservation.setReserveTime(new Date());
            reservation.setHostelRoom(hostelRoom);
            reservationDao.save(reservation);
        }catch (Exception e) {
            serviceResult.setSuccess(false);
            serviceResult.setMessage(e.getMessage());
        }
        return serviceResult;
    }


    public ServiceResult getReservation(final HttpServletRequest httpServletRequest,
                                        final ReservationRestrict reservationRestrict) {
        ServiceResult serviceResult = new ServiceResult(true);
        try {

            Object login = httpServletRequest.getSession(false)
                    .getAttribute(StringConstant.SESSION_LOGIN);
            if (!(login instanceof AdministerVO) ) {
                throw  new Exception(StringConstant.AUTH_WRONG);
            }
            PaginationResult paginationResult = reservationDao.getReservation(reservationRestrict);
            List<Reservation> reservationList = paginationResult.getItems();
            List<ReservationShowMember> show =
                    new ArrayList<ReservationShowMember>(reservationList.size());
            for (Reservation reservation:reservationList) {
                show.add(Convert.convertForMember(reservation));
            }
            paginationResult.setItems(show);
            serviceResult.setValue(paginationResult);

        }catch (Exception e) {
            e.printStackTrace();
            serviceResult.setSuccess(false);
            serviceResult.setMessage(e.getMessage());
        }
        return serviceResult;
    }

    private ServiceResult getByUser(final HttpServletRequest httpServletRequest,
                                    final ReservationRestrict reservationRestrict,
                                    final   MyFunction<PaginationResult,Object> function
                                    ) {
        ServiceResult serviceResult = new ServiceResult(true);
        try {

            Object login = httpServletRequest.getSession(false)
                    .getAttribute(StringConstant.SESSION_LOGIN);
            Long memberId = null;
            if (login instanceof Member) {
                memberId = ((Member)login).getMemberId();
            } else if (login instanceof AdministerVO) {
                memberId = reservationRestrict.getReservationOwner();
            }
            if (memberId==null) {
                throw new Exception(StringConstant.PARAMETER_WRONG+StringConstant.AUTH_WRONG);
            }

            PaginationResult paginationResult = function.execute(memberId);
            List<Reservation> reservationList = paginationResult.getItems();
            List<ReservationShowMember> show =
                    new ArrayList<ReservationShowMember>(reservationList.size());
            for (Reservation reservation:reservationList) {
                show.add(Convert.convertForMember(reservation));
            }
            paginationResult.setItems(show);
            serviceResult.setValue(paginationResult);

        }catch (Exception e) {
            e.printStackTrace();
            serviceResult.setSuccess(false);
            serviceResult.setMessage(e.getMessage());
        }
        return serviceResult;
    }

    public ServiceResult getReservationByUser(final HttpServletRequest httpServletRequest,
                                              final ReservationRestrict reservationRestrict) {

        return getByUser(httpServletRequest,reservationRestrict,
                new MyFunction<PaginationResult, Object>() {
                    public PaginationResult execute(Object id) {
                        return reservationDao.getReservationByUser(id, reservationRestrict);
                    }
                }
        );
    }

    public ServiceResult getCheckInByUser(HttpServletRequest httpServletRequest,
                                          final ReservationRestrict reservationRestrict) {

        return getByUser(httpServletRequest,reservationRestrict,
                new MyFunction<PaginationResult, Object>() {
                    public PaginationResult execute(Object id) {
                        return reservationDao.getCheckInByUser(id, reservationRestrict);
                    }
                }
        );
    }

    public ServiceResult getPaymentByUser(HttpServletRequest httpServletRequest,
                                          final ReservationRestrict reservationRestrict) {

        return getByUser(httpServletRequest,reservationRestrict,
                new MyFunction<PaginationResult, Object>() {
                    public PaginationResult execute(Object id) {
                        return reservationDao.getPaymentByUser(id, reservationRestrict);
                    }
                }
        );
    }


    private ServiceResult getByHostel(final HttpServletRequest httpServletRequest,
                                      final ReservationRestrict reservationRestrict,
                                      final MyFunction<PaginationResult,Object> function
                                      ) {
        ServiceResult serviceResult = new ServiceResult(true);
        try {

            Object login = httpServletRequest.getSession(false)
                    .getAttribute(StringConstant.SESSION_LOGIN);
            Long hostelID = null;
            if (login instanceof Member) {
                hostelID = ((HostelVO)login).getHostelId();
            } else if (login instanceof AdministerVO) {
                hostelID = reservationRestrict.getReservationOwner();
            }
            if (hostelID==null) {
                throw new Exception(StringConstant.PARAMETER_WRONG+StringConstant.AUTH_WRONG);
            }

            PaginationResult paginationResult = function.execute(hostelID);
            List<Reservation> reservationList = paginationResult.getItems();
            List<ReservationShowHostel> show =
                    new ArrayList<ReservationShowHostel>(reservationList.size());
            for (Reservation reservation:reservationList) {
                show.add(Convert.convertForHostel(reservation));
            }
            paginationResult.setItems(show);
            serviceResult.setValue(paginationResult);

        }catch (Exception e) {
            e.printStackTrace();
            serviceResult.setSuccess(false);
            serviceResult.setMessage(e.getMessage());
        }
        return serviceResult;
    }

    public ServiceResult getReservationByHostel(HttpServletRequest httpServletRequest,
                                                final ReservationRestrict reservationRestrict) {

        return getByHostel(httpServletRequest,reservationRestrict,
                new MyFunction<PaginationResult, Object>() {
                    public PaginationResult execute(Object id) {
                        return reservationDao.getReservationByHostel(id, reservationRestrict);
                    }
                }
        );
    }

    public ServiceResult getCheckInByHostel(HttpServletRequest httpServletRequest,
                                            final ReservationRestrict reservationRestrict) {

        return getByHostel(httpServletRequest,reservationRestrict,
                new MyFunction<PaginationResult, Object>() {
                    public PaginationResult execute(Object id) {
                        return reservationDao.getCheckInByHostel(id, reservationRestrict);
                    }
                }
        );
    }

    public ServiceResult getPaymentByHostel(HttpServletRequest httpServletRequest,
                                            final ReservationRestrict reservationRestrict) {

        return getByHostel(httpServletRequest,reservationRestrict,
                new MyFunction<PaginationResult, Object>() {
                    public PaginationResult execute(Object id) {
                        return reservationDao.getPaymentByHostel(id, reservationRestrict);
                    }
                }
        );
    }



    public ServiceResult userPay(HttpServletRequest httpServletRequest,
                                 Long reservationId) {

        ServiceResult serviceResult = new ServiceResult(true);
        try {
            Reservation reservation = reservationDao.load(reservationId);
            HttpSession session = httpServletRequest.getSession(false);
            if (session!=null) {
                Object login = session.getAttribute(StringConstant.SESSION_LOGIN);
                if (login instanceof MemberVO) {
                    MemberVO memberVO = (MemberVO)login;
                    if (memberVO.getMemberId().equals(
                            reservation.getMember().getMemberId())) {
                        Member member = memberDao.load(memberVO.getMemberId());
                        double balance = member.getBalance() -
                                reservation.getPrice()*reservation.getAmount();

                        if (balance>=0) {
                            member.setBalance(balance);
                            memberVO.setBalance(member.getBalance());
                            memberDao.update(member);
                            reservation.setPayment(true);
                            reservation.setPaymentTime(new Date());
                            reservationDao.update(reservation);
                            return serviceResult;
                        }
                        throw new Exception(StringConstant.NOENOUGH_BALANCE);
                    }
                }
            }

            throw new Exception(StringConstant.AUTH_WRONG);
        }catch (Exception e) {
            serviceResult.setSuccess(false);
            serviceResult.setMessage(e.getMessage());
        }
        return serviceResult;
    }

}
