package personal.darxan.hostel.vo;

/**
 * Created by darxan on 2017/2/17.
 */
public class CheckOut {
    private Long reservationId;

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    @Override
    public String toString() {
        return "CheckOut{" +
                "reservationId=" + reservationId +
                '}';
    }
}
