package Factory;

/**
 * draft版本的抽象方法清楚的描述了抽象工厂的复杂关系
 * 但是如果我们再想拓展产品加入新的，那么我们的代码从抽象工厂，到具体工厂全部要加代码，不符合开闭原则，
 * 因此缺点是明显的：
 * 1.规定了所有可能被new 的产品集合（在接口中）拓展新产品复杂困难，需要改接口
 */

/**
 * 一个工厂有多个产品，可能不同的工厂生产同样的产品（品牌不同）例如，家电美的，长虹，格力
 * 那么现在定义产品接口
 */
interface IVideo {
    void record();
}

interface INote {
    void write();
}

class JavaVideo implements IVideo {
    @Override
    public void record() {System.out.println("record java video");};
}
class JavaNote implements INote {
    @Override
    public void write() {System.out.println("write java note");};
}
class PythonNote implements INote {
    @Override
    public void write(){System.out.println("write python note");}
}
class PythonVideo implements IVideo {
    @Override
    public void record(){System.out.println("record python note");}
}
/**
 * 创建一个抽象工厂,这是一个用户的主入口
 */
interface CourseFactory {

    IVideo createVideo();
    INote createNote();
}

//创建java产品的具体工厂JavaCourseFactory

class JavaCourseFactory implements CourseFactory{
    @Override
    public IVideo createVideo() { return new JavaVideo(); }
    @Override
    public INote createNote() { return new JavaNote(); }
}

//创建java产品的具体工厂JavaCourseFactory

class PythonCourseFactory implements CourseFactory{
    @Override
    public IVideo createVideo() { return new PythonVideo(); }
    @Override
    public INote createNote() { return new PythonNote(); }
}

/**
 * TODO
 * 抽象工厂模式(Abastract Factory Pattern)是指提供一个创建一系列相关或相互依赖
 * 对象的接口，无须指定他们具体的类
 * 1.(应用层)不依赖于产品类实例如何被创 建、实现等细节
 */
public class AbstractFactory {
    public static void main(String[] args) {


        JavaCourseFactory javaCourseFactory = new JavaCourseFactory();
        javaCourseFactory.createNote().write();
        javaCourseFactory.createVideo().record();
    }
}

