package Factory;

import com.self.edu.springlearn.DesignPattern.Factory.Entities.ICourse;
import com.self.edu.springlearn.DesignPattern.Factory.Entities.JavaCourse;
import com.self.edu.springlearn.DesignPattern.Factory.Entities.PythonCourse;

import java.util.Calendar;

/**
 * 简单工厂优化
 * 简单工厂在JDK源码里面参考Calendar.getInstance()
 * 所以简单工厂的缺点是？
 */
public class SampleFactory {

    /**
     * Class<? extends ICourse> clazz 这样传参数，返回值就不需要做强制转化，肯定是ICourse
     * @param clazz
     * @return
     */
    public ICourse CreateClazz(Class<? extends ICourse> clazz) {

        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        //正常的new
        ICourse course = new JavaCourse();
        //sample工厂的
        SampleFactory sampleFactory = new SampleFactory();
        //1.通过字符串
        ICourse pythonCourse = sampleFactory.Create("com.self.edu.springlearn.DesignPattern.Factory.Entities.PythonCourse");
        //2.通过Class
        pythonCourse = sampleFactory.CreateClazz(PythonCourse.class);
        pythonCourse.record();
        //看源码
        Calendar.getInstance();
    }

    /**
     * 创建方法
     * {@code Class t = Class.forName("java.lang.Thread")}
     */
    public ICourse Create(String className) {

        try {
            return (ICourse) Class.forName(className).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
