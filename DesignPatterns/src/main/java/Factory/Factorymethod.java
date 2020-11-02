package Factory;

import com.self.edu.springlearn.DesignPattern.Factory.Entities.ICourse;

/**
 *工厂方法模式主要解决产品扩展的问题
 * 工厂方法缺点:
 * 1、类的个数容易过多，增加复杂度。
 * 2、增加了系统的抽象性和理解难度。
 */
public class Factorymethod {
    public static void main(String[] args) {
        ICourseFactory factory = new PythonFactory();
        ICourse course = factory.create();
        course.record();
        factory = new JavaFactory();
        course = factory.create();
        course.record();
    }
}

interface ICourseFactory {
    ICourse create();
}

class JavaFactory implements ICourseFactory {

    @Override
    public ICourse create() {
        return null;
    }
}

class PythonFactory implements ICourseFactory {

    @Override
    public ICourse create() {
        return null;
    }
}