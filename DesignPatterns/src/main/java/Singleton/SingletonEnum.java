package Singleton;

/**
 * 受枚举单例反编译启发，容器注册式单例，实现后续的容器式单例和ThreadLocal
 */

public enum SingletonEnum {
    //解决线程同步，还防止反序列化
    INSTANCE;
    private Object data;

    public void setData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public SingletonEnum getInstance() {
        return INSTANCE;
    }

}
