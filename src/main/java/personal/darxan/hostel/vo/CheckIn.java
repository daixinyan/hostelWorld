package personal.darxan.hostel.vo;

/**
 * Created by darxan on 2017/2/17.
 */
public class CheckIn {

    private Long reservationId;

    private String people;

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    @Override
    public String toString() {
        return "CheckIn{" +
                "reservationId=" + reservationId +
                ", people='" + people + '\'' +
                '}';
    }
}
