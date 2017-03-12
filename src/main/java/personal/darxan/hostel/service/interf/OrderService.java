package personal.darxan.hostel.service.interf;

import personal.darxan.hostel.vo.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by darxan on 2017/2/17.
 */
 public interface OrderService {

     ServiceResult checkIn(CheckIn checkIn, HttpServletRequest httpServletRequest);

     ServiceResult checkOut(CheckOut checkOut, HttpServletRequest httpServletRequest);

     ServiceResult cancel(Long reservationId, HttpServletRequest httpServletRequest);
     ServiceResult reserve(ReservationVO reservationVO, HttpServletRequest httpServletRequest);

     ServiceResult getReservationByAdmin(HttpServletRequest httpServletRequest,
                                               ReservationRestrict reservationRestrict);

     ServiceResult getReservationByUser(HttpServletRequest httpServletRequest,
                                              ReservationRestrict reservationRestrict);
     ServiceResult getCheckInByUser(HttpServletRequest httpServletRequest,
                                          ReservationRestrict reservationRestrict);
     ServiceResult getPaymentByUser(HttpServletRequest httpServletRequest,
                                          ReservationRestrict reservationRestrict);

     ServiceResult getPaymentByAdmin(HttpServletRequest httpServletRequest,
                                           ReservationRestrict reservationRestrict);
    
     ServiceResult getReservationByHostel(HttpServletRequest httpServletRequest,
                                                ReservationRestrict reservationRestrict);
     ServiceResult getCheckInByHostel(HttpServletRequest httpServletRequest,
                                            ReservationRestrict reservationRestrict);
     ServiceResult getPaymentByHostel(HttpServletRequest httpServletRequest,
                                            ReservationRestrict reservationRestrict);

     ServiceResult userPay(HttpServletRequest httpServletRequest, Long reservationId);

     ServiceResult adminDeductForHostel(HttpServletRequest httpServletRequest, Long reservationId);
}
