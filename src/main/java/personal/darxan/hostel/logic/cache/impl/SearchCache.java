package personal.darxan.hostel.logic.cache.impl;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by darxan on 2017/2/17.
 */
public class SearchCache {

    private List<PageBorder> pageBorderList;

    private static final PageBorder largestPage = new PageBorder(Long.MAX_VALUE);

    private static final PageBorder smallestPage = new PageBorder(Long.MIN_VALUE);

    public SearchCache() {
        pageBorderList = new ArrayList<PageBorder>();
    }

    /**
     * 获得距离上最近的缓冲page
     * @param page
     * @return
     */
    public PageBorder getNearestPageBorder(long page) {

        int size = size();

        if (size==0) {
            return null;
        }

        int smallerPageIndex = getSmallerPageIndex(0, size, page);
        PageBorder lowerPage = smallestPage;
        PageBorder upperPage = largestPage;

        if (smallerPageIndex!=-1) {
            lowerPage = pageBorderList.get(smallerPageIndex);
        }
        if (smallerPageIndex+1<size) {
            upperPage = pageBorderList.get(smallerPageIndex+1);
        }

        if (upperPage.getPage()-page>page-lowerPage.getPage()) {
            return upperPage==largestPage?null:upperPage;
        } else {
            return lowerPage==smallestPage?null:lowerPage;
        }
    }

    /**
     * 增加缓冲
     * @param pageBorder
     */
    public void addPageBorder(PageBorder pageBorder) {

        long page = pageBorder.getPage();
        int lowerPageIndex = getSmallerPageIndex(0, size(), page);

        pageBorderList.add(lowerPageIndex, pageBorder);
    }

    /**
     * 获取最大的小于{page}的页码缓冲
     * @param start
     * @param end
     * @param page
     * @return
     */
    protected int getSmallerPageIndex(int start, int end, long page) {

        if (end-start==1) {
            PageBorder pageBorder = pageBorderList.get(start);
            if (pageBorder.getPage()>=page) {
                return -1;
            }else {
                return start;
            }
        }
        int mid = (start+end)/2;
        long midPage = pageBorderList.get(mid).getPage();
        if (midPage>=page) {
            return getSmallerPageIndex(start, mid-1, page);
        } else {
            int smallerPageIndex = getSmallerPageIndex(mid, end, page);
            return smallerPageIndex;
        }
    }

    public int size() {
        return pageBorderList.size();
    }
}
