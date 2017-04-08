package personal.darxan.hostel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.darxan.hostel.dao.MemberDao;
import personal.darxan.hostel.tool.MyLogger;

import java.util.Calendar;

/**
 * Created by darxan on 2017/3/14.
 */
public class MemberCleaner implements Runnable {

    @Autowired
    private MemberDao memberDao;

    public void run() {


        MyLogger.log("executed!!");

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR)-1);
        memberDao.updateNearlyNoPaymentMember(calendar.getTime());

    }
}
