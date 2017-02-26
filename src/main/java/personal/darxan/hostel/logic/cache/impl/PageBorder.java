package personal.darxan.hostel.logic.cache.impl;

/**
 * Created by darxan on 2017/2/17.
 */
public class PageBorder {

    public PageBorder() {}

    public PageBorder(long page) {
        this.page = page;
    }

    private long upper;

    private long lower;

    private long page;

    public long getUpper() {
        return upper;
    }

    public void setUpper(long upper) {
        this.upper = upper;
    }

    public long getLower() {
        return lower;
    }

    public void setLower(long lower) {
        this.lower = lower;
    }

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PageBorder that = (PageBorder) o;

        return page == that.page;
    }

    @Override
    public int hashCode() {
        return (int) (page ^ (page >>> 32));
    }
}
