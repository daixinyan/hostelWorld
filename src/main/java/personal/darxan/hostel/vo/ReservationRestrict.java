package personal.darxan.hostel.vo;

import java.util.Date;

/**
 * Created by darxan on 2017/2/19.
 */
public class ReservationRestrict {

    private String keyword;

    private Integer page = 1;

    private boolean asc = true;

    private Integer pageSize = 10;

    private String order;

    private Date dateLower;

    private Date dateUpper;


    @Override
    public String toString() {
        return "ReservationRestrict{" +
                "keyword='" + keyword + '\'' +
                ", page=" + page +
                ", asc=" + asc +
                ", pageSize=" + pageSize +
                ", order='" + order + '\'' +
                ", dateLower=" + dateLower +
                ", dateUpper=" + dateUpper +
                '}';
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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public boolean isAsc() {
        return asc;
    }

    public void setAsc(boolean asc) {
        this.asc = asc;
    }
}
