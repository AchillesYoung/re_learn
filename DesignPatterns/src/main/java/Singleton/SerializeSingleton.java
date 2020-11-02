package Singleton;

/**
 */

class SerializeHungary {
    //如果不加final，会可能被人为用反射机制给覆盖掉，加了final不可能被改掉
    private static final SerializeHungary instance = new SerializeHungary();

    private SerializeHungary() {

    }

    public static SerializeHungary getInstance() {


        return instance;
    }
    //重写readResolve方法就可以解决序列化破坏单例的问题,返回的覆盖了序列化创建的对象，之前反序列化的会被回收期回收
    private Object readResovle(){
        return instance;
    }
}
public class SerializeSingleton {

}
