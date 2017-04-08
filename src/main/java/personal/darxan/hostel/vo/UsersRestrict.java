package personal.darxan.hostel.vo;

import personal.darxan.hostel.tool.DateFormatter;

import java.util.Date;

/**
 * Created by darxan on 2017/3/9.
 */
public class UsersRestrict {

    private String keyword;

    private Integer page = 1;

    private Integer pageSize = 10;

    private Date dateLower = new Date(System.currentTimeMillis()-15*24*60*60*1000);

    private Date dateUpper = new Date(System.currentTimeMillis()+24*60*60*1000);


    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Date getDateLower() {
        return dateLower;
    }

    public void setDateLower(Date dateLower) {
        this.dateLower = dateLower;
    }

    public Date getDateUpper() {
        return dateUpper;
    }

    public void setDateUpper(Date dateUpper) {
        this.dateUpper = dateUpper;
    }

    public String getDateLowerString() {
        return DateFormatter.dateFormat.format(dateLower);
    }


    public String getDateUpperString() {
        return DateFormatter.dateFormat.format(dateUpper);
    }

}
