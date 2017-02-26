package personal.darxan.hostel.service.interf;

import personal.darxan.hostel.vo.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by darxan on 2017/2/17.
 */
public interface OrderService {

    public ServiceResult checkIn(CheckIn checkIn, HttpServletRequest httpServletRequest);

    public ServiceResult checkOut(CheckOut checkOut, HttpServletRequest httpServletRequest);

    public ServiceResult cancel(Long reservationId, HttpServletRequest httpServletRequest);
    public ServiceResult reserve(ReservationVO reservationVO, HttpServletRequest httpServletRequest);

    public ServiceResult getReservationByUser(HttpServletRequest httpServletRequest,
                                              ReservationRestrict reservationRestrict);
    public ServiceResult getCheckInByUser(HttpServletRequest httpServletRequest,
                                          ReservationRestrict reservationRestrict);
    public ServiceResult getPaymentByUser(HttpServletRequest httpServletRequest,
                                          ReservationRestrict reservationRestrict);

    public ServiceResult getReservationByHostel(HttpServletRequest httpServletRequest,
                                                ReservationRestrict reservationRestrict);
    public ServiceResult getCheckInByHostel(HttpServletRequest httpServletRequest,
                                            ReservationRestrict reservationRestrict);
    public ServiceResult getPaymentByHostel(HttpServletRequest httpServletRequest,
                                            ReservationRestrict reservationRestrict);



}
