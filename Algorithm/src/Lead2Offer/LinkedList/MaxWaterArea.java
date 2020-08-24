package Lead2Offer.LinkedList;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2020/8/20-4:52 PM
 * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
 */
public class MaxWaterArea {

    /**
     * maxArea
     *
     */
    public int maxArea(int[] height) {
        //左指针，右指针
        int l = 0, r = height.length - 1;
        // 面积
        int ans = 0;
        while (l < r) {
            //Math.min(height[l], height[r])取决于两边最小 为高/* 乘以宽。的为面积。
            int area = Math.min(height[l], height[r]) * (r - l);
            //比较之前最大面积
            ans = Math.max(ans, area);
            //继续循环。 left,right 其中哪个小，哪个移动
            if (height[l] <= height[r]) {
                ++l;
            }
            else {
                //right小，right移动
                --r;
            }
        }
        return ans;
    }
}
