package personal.darxan.hostel.tool;

import personal.darxan.hostel.model.*;
import personal.darxan.hostel.vo.*;

import java.util.Date;

/**
 * Created by darxan on 2017/2/15.
 */
public final class Convert {

    public static final Member convert(MemberVO memberVO) {

        Member member = new Member();

        member.setMemberId(memberVO.getMemberId());

        member.setName(memberVO.getName());
        member.setPassword(memberVO.getPassword());
        member.setBalance(memberVO.getBalance());
        member.setBankCard(memberVO.getBankCard());
        member.setBonusPoint(memberVO.getBonusPoint());
        member.setContact(memberVO.getContact());
        member.setLevel(memberVO.getLevel());
        member.setPhone(memberVO.getPhone());
        member.setState(memberVO.getState());
        member.setUpdateTime(new Date());

        return member;
    }

    public static final MemberVO convert(Member memberEntity) {
        MemberVO member = new MemberVO();

        member.setMemberId(memberEntity.getMemberId());

        member.setName(memberEntity.getName());
        member.setPassword(memberEntity.getPassword());
        member.setBalance(memberEntity.getBalance());
        member.setBankCard(memberEntity.getBankCard());
        member.setBonusPoint(memberEntity.getBonusPoint());
        member.setContact(memberEntity.getContact());
        member.setLevel(memberEntity.getLevel());
        member.setPhone(memberEntity.getPhone());
        member.setState(memberEntity.getState());
        member.setUpdateTime(new Date());

        return member;
    }

    public static final Hostel convert(HostelVO hostelVO) {

        Hostel hostel = new Hostel();

        hostel.setHostelId(hostelVO.getHostelId());

        hostel.setName(hostelVO.getName());
        hostel.setState(hostelVO.getState());
        hostel.setPhone(hostelVO.getPhone());
        hostel.setAdd_1(hostelVO.getAdd_1());
        hostel.setAdd_2(hostelVO.getAdd_2());
        hostel.setAdd_3(hostelVO.getAdd_3());
        hostel.setAdd_4(hostelVO.getAdd_4());
        hostel.setAddress(hostelVO.getAddress());
        hostel.setBankcard(hostelVO.getBankcard());
        hostel.setContact(hostelVO.getContact());
        hostel.setCreateTime(hostelVO.getCreateTime());
        hostel.setHostel(hostelVO.getHostel());
        hostel.setImage(hostelVO.getImage());
        hostel.setPassword(hostelVO.getPassword());

        return hostel;
    }

    public static final HostelVO convert(Hostel hostelEntity) {
        HostelVO hostel = new HostelVO();

        hostel.setHostelId(hostelEntity.getHostelId());

        hostel.setName(hostelEntity.getName());
        hostel.setState(hostelEntity.getState());
        hostel.setPhone(hostelEntity.getPhone());
        hostel.setAdd_1(hostelEntity.getAdd_1());
        hostel.setAdd_2(hostelEntity.getAdd_2());
        hostel.setAdd_3(hostelEntity.getAdd_3());
        hostel.setAdd_4(hostelEntity.getAdd_4());
        hostel.setAddress(hostelEntity.getAddress());
        hostel.setBankcard(hostelEntity.getBankcard());
        hostel.setContact(hostelEntity.getContact());
        hostel.setCreateTime(hostelEntity.getCreateTime());
        hostel.setHostel(hostelEntity.getHostel());
        hostel.setImage(hostelEntity.getImage());
        hostel.setPassword(hostelEntity.getPassword());
        hostel.setPhone(hostelEntity.getPhone());

        return hostel;
    }

    public static final Administer convert(AdministerVO administerVO) {
        Administer administer = new Administer();

        administer.setName(administerVO.getName());
        administer.setPassword(administerVO.getPassword());
        administer.setCreateTime(administerVO.getCreateTime());
        administer.setAdminsterId(administerVO.getAdminsterId());

        return administer;
    }

    public static final AdministerVO convert(Administer administerEntity) {
        AdministerVO administer = new AdministerVO();
        administer.setName(administerEntity.getName());
        administer.setPassword(administerEntity.getPassword());
        administer.setCreateTime(administerEntity.getCreateTime());
        administer.setAdminsterId(administerEntity.getAdminsterId());
        return administer;
    }

    public static final HostelRoom convert(HostelRoomVO vo) {
        HostelRoom hostelRoom = new HostelRoom();
        hostelRoom.setCount(vo.getCount());
        hostelRoom.setImage(vo.getImage());
        hostelRoom.setAirCondition(vo.isAirCondition());
        hostelRoom.setCapacity(vo.getCapacity());
        hostelRoom.setComputer(vo.isComputer());
        hostelRoom.setNumOfBed(vo.getNumOfBed());
        hostelRoom.setDescription(vo.getDescription());
        hostelRoom.setPrice(vo.getPrice());
        hostelRoom.setRoomId(vo.getRoomId());
        hostelRoom.setStartDate(vo.getStartDate());
        hostelRoom.setEndDate(vo.getEndDate());

        return hostelRoom;
    }

    public static final HostelRoomVO convert(HostelRoom entity) {
        HostelRoomVO hostelRoom = new HostelRoomVO();
        hostelRoom.setCount(entity.getCount());
        hostelRoom.setImage(entity.getImage());
        hostelRoom.setAirCondition(entity.isAirCondition());
        hostelRoom.setCapacity(entity.getCapacity());
        hostelRoom.setComputer(entity.isComputer());
        hostelRoom.setNumOfBed(entity.getNumOfBed());
        hostelRoom.setDescription(entity.getDescription());
        hostelRoom.setPrice(entity.getPrice());
        hostelRoom.setRoomId(entity.getRoomId());
        hostelRoom.setStartDate(entity.getStartDate());
        hostelRoom.setEndDate(entity.getEndDate());

        if (entity.getHostel()!=null) {
            hostelRoom.setHostelId(entity.getHostel().getHostelId());
            hostelRoom.setState(entity.getHostel().getState());
            hostelRoom.setPhone(entity.getHostel().getPhone());
            hostelRoom.setAdd_1(entity.getHostel().getAdd_1());
            hostelRoom.setAdd_2(entity.getHostel().getAdd_2());
            hostelRoom.setAdd_3(entity.getHostel().getAdd_3());
            hostelRoom.setAdd_4(entity.getHostel().getAdd_4());
            hostelRoom.setAddress(entity.getHostel().getAddress());
            hostelRoom.setBankcard(entity.getHostel().getBankcard());
            hostelRoom.setContact(entity.getHostel().getContact());
            hostelRoom.setCreateTime(entity.getHostel().getCreateTime());
            hostelRoom.setHostel(entity.getHostel().getHostel());
            hostelRoom.setImage(entity.getHostel().getImage());
            hostelRoom.setPhone(entity.getHostel().getPhone());
        }

        return hostelRoom;
    }

    public static final ReservationShowHostel convertForHostel(Reservation reservation) {
        ReservationShowHostel reservationShowHostel = new ReservationShowHostel();

        reservationShowHostel.setReservationId(reservation.getReservationId());
        reservationShowHostel.setReserved(reservation.isReserved());
        reservationShowHostel.setReserveTime(reservation.getReserveTime());
        reservationShowHostel.setCheckIn(reservation.isCheckIn());
        reservationShowHostel.setCheckInTime(reservation.getCheckInTime());
        reservationShowHostel.setCheckOut(reservation.isCheckOut());
        reservationShowHostel.setCheckOutTime(reservation.getCheckOutTime());
        reservationShowHostel.setPayment(reservation.isPayment());
        reservationShowHostel.setPaymentTime(reservation.getPaymentTime());

        reservationShowHostel.setRefused(reservation.isRefused());
        reservationShowHostel.setRefused(reservation.isRefused());

        reservationShowHostel.setAmount(reservation.getAmount());
        reservationShowHostel.setCanceled(reservation.isCanceled());

        reservationShowHostel.setPeople(reservation.getPeople());
        reservationShowHostel.setPrice(reservation.getPrice());

        Member member = reservation.getMember();
        reservationShowHostel.setMemberId(member.getMemberId());
        reservationShowHostel.setState(member.getState());
        reservationShowHostel.setLevel(member.getLevel());
        reservationShowHostel.setBonusPoint(member.getBonusPoint());
        reservationShowHostel.setAvatar(member.getAvatar());
        reservationShowHostel.setBankCard(member.getBankCard());
        reservationShowHostel.setPhone(member.getPhone());
        reservationShowHostel.setContact(member.getContact());
        reservationShowHostel.setName(member.getName());


        return reservationShowHostel;
    }

    public static final ReservationShowMember convertForMember(Reservation reservation) {

        ReservationShowMember reservationShowMember = new ReservationShowMember();

        reservationShowMember.setReservationId(reservation.getReservationId());
        reservationShowMember.setReserved(reservation.isReserved());
        reservationShowMember.setReserveTime(reservation.getReserveTime());
        reservationShowMember.setCheckIn(reservation.isCheckIn());
        reservationShowMember.setCheckInTime(reservation.getCheckInTime());
        reservationShowMember.setCheckOut(reservation.isCheckOut());
        reservationShowMember.setCheckOutTime(reservation.getCheckOutTime());
        reservationShowMember.setPayment(reservation.isPayment());
        reservationShowMember.setPaymentTime(reservation.getPaymentTime());

        reservationShowMember.setRefused(reservation.isRefused());
        reservationShowMember.setRefused(reservation.isRefused());

        reservationShowMember.setAmount(reservation.getAmount());
        reservationShowMember.setCanceled(reservation.isCanceled());

        reservationShowMember.setPeople(reservation.getPeople());

        HostelRoom room = reservation.getHostelRoom();
        reservationShowMember.setRoomId(room.getRoomId());
        reservationShowMember.setHostelId(room.getHostel().getHostelId());
        reservationShowMember.setStartDate(room.getStartDate());
        reservationShowMember.setEndDate(room.getEndDate());
        reservationShowMember.setPrice(room.getPrice());
        reservationShowMember.setCount(room.getCount());
        reservationShowMember.setCapacity(room.getCapacity());
        reservationShowMember.setNumOfBed(room.getNumOfBed());

        reservationShowMember.setAirCondition(room.isAirCondition());
        reservationShowMember.setComputer(room.isComputer());
        reservationShowMember.setDescription(room.getDescription());
        reservationShowMember.setImage(room.getImage());

        return reservationShowMember;
    }
}
