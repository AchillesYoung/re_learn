package Factory.Entities;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2020/10/29-12:58 PM
 * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
 */
public class JavaCourse implements ICourse {
    /**
     * 录制视频
     */
    @Override
    public void record() {
        System.out.println("录制java视频");
    }
}
