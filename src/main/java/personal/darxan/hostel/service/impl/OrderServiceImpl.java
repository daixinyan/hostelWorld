package personal.darxan.hostel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.darxan.hostel.dao.HostelRoomDao;
import personal.darxan.hostel.dao.ReservationDao;
import personal.darxan.hostel.model.HostelRoom;
import personal.darxan.hostel.model.Reservation;
import personal.darxan.hostel.service.interf.OrderService;
import personal.darxan.hostel.tool.Convert;
import personal.darxan.hostel.tool.MyFunction;
import personal.darxan.hostel.tool.StringConstant;
import personal.darxan.hostel.vo.*;

import javax.servlet.http.HttpServletRequest;
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
            reservation.setMember(Convert.convert(memberVO));
            reservation.setPrice(hostelRoom.getPrice());
            reservation.setAmount(reservationVO.getAmount());
            reservation.setHostel(hostelRoom.getHostel());
            reservation.setReserveTime(new Date());
            reservationDao.save(reservation);
        }catch (Exception e) {
            serviceResult.setSuccess(false);
            serviceResult.setMessage(e.getMessage());
        }
        return serviceResult;
    }


    private ServiceResult getByUser(HttpServletRequest httpServletRequest,
                                      MyFunction<PaginationResult,Object> function) {
        ServiceResult serviceResult = new ServiceResult(true);
        try {
            MemberVO memberVO = (MemberVO) httpServletRequest.
                    getSession(false).getAttribute(StringConstant.SESSION_LOGIN);

            PaginationResult paginationResult = function.execute(memberVO.getMemberId());
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

    public ServiceResult getReservationByUser(HttpServletRequest httpServletRequest,
                                              final ReservationRestrict reservationRestrict) {

        return getByUser(httpServletRequest,
                new MyFunction<PaginationResult, Object>() {
                    public PaginationResult execute(Object id) {
                        return reservationDao.getReservationByUser(id, reservationRestrict);
                    }
                }
        );
    }

    public ServiceResult getCheckInByUser(HttpServletRequest httpServletRequest,
                                          final ReservationRestrict reservationRestrict) {

        return getByUser(httpServletRequest,
                new MyFunction<PaginationResult, Object>() {
                    public PaginationResult execute(Object id) {
                        return reservationDao.getCheckInByUser(id, reservationRestrict);
                    }
                }
        );
    }

    public ServiceResult getPaymentByUser(HttpServletRequest httpServletRequest,
                                          final ReservationRestrict reservationRestrict) {

        return getByUser(httpServletRequest,
                new MyFunction<PaginationResult, Object>() {
                    public PaginationResult execute(Object id) {
                        return reservationDao.getPaymentByUser(id, reservationRestrict);
                    }
                }
        );
    }


    private ServiceResult getByHostel(HttpServletRequest httpServletRequest,
                                      MyFunction<PaginationResult,Object> function) {
        ServiceResult serviceResult = new ServiceResult(true);
        try {
            HostelVO hostelVO = (HostelVO) httpServletRequest.
                    getSession(false).getAttribute(StringConstant.SESSION_LOGIN);

            PaginationResult paginationResult = function.execute(hostelVO.getHostelId());
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

        return getByHostel(httpServletRequest,
                new MyFunction<PaginationResult, Object>() {
                    public PaginationResult execute(Object id) {
                        return reservationDao.getReservationByHostel(id, reservationRestrict);
                    }
                }
        );
    }

    public ServiceResult getCheckInByHostel(HttpServletRequest httpServletRequest,
                                            final ReservationRestrict reservationRestrict) {

        return getByHostel(httpServletRequest,
                new MyFunction<PaginationResult, Object>() {
                    public PaginationResult execute(Object id) {
                        return reservationDao.getCheckInByHostel(id, reservationRestrict);
                    }
                }
        );
    }

    public ServiceResult getPaymentByHostel(HttpServletRequest httpServletRequest,
                                            final ReservationRestrict reservationRestrict) {

        return getByHostel(httpServletRequest,
                new MyFunction<PaginationResult, Object>() {
                    public PaginationResult execute(Object id) {
                        return reservationDao.getPaymentByHostel(id, reservationRestrict);
                    }
                }
        );
    }



}
