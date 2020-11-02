package Prototype;

import java.io.*;

/**
 */
//深度clone的两中方法，1。序列化 2。利用两次原始clone去克隆成员变量
public class DeepCloneableDemo implements Serializable, Cloneable {

    private static final long serialVersionUID = -1505512514616148776L;


    private String cloneName;

    private MemberCloneable protoType;
    private String cloneClass;

    public DeepCloneableDemo() {
    }

    //构造器
    public DeepCloneableDemo(String cloneName, String cloneClass) {
        this.cloneName = cloneName;
        this.cloneClass = cloneClass;
    }
    //深拷贝 - 方式 1 通过对象的序列化实现 (推荐)

    public Object deepClone() {
        //创建流对象
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        DeepCloneableDemo copyObj = null;
        try {
            //序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this); //当前这个对象以对象流的方式输出
            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            copyObj = (DeepCloneableDemo) ois.readObject();
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
            return copyObj;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return copyObj;
        } finally {
            //关闭流
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            } catch (Exception e2) {
                System.out.println(e2.getMessage());
            }
        }
        return copyObj;
    }

    //深拷贝 - 方式 2。利用两次原始clone去克隆成员变量
    @Override
    public Object clone() throws CloneNotSupportedException {
        Object deep = null;
        //这里完成对基本数据类型(属性)和 String 的克隆
        deep = super.clone();
        //对引用类型的属性，进行单独处理
        DeepCloneableDemo deepProtoType = (DeepCloneableDemo) deep;
        deepProtoType.protoType = (MemberCloneable) protoType.clone();
        return deepProtoType;
    }


    public static void main(String[] args) throws Exception {
        DeepCloneableDemo p = new DeepCloneableDemo();
        p.cloneName = "宋江";
        p.protoType = new MemberCloneable("大牛", "小牛");

        //方式 1  完成深拷贝
        DeepCloneableDemo p1 = (DeepCloneableDemo) p.clone();

        System.out.println("p.name=" + p.cloneName + "p.protoType=" + p.protoType.hashCode());
        System.out.println("p1.name=" + p1.cloneName + "p1.protoType=" + p1.protoType.hashCode());
        //方式 2  完成深拷贝
        //p.name=宋江p.protoType=621009875
        //p2.name=宋江p2.protoType=793589513 新的p2
        DeepCloneableDemo p2 = (DeepCloneableDemo) p.deepClone();

        System.out.println("p.name=" + p.cloneName + "p.protoType=" + p.protoType.hashCode());
        System.out.println("p2.name=" + p2.cloneName + "p2.protoType=" + p2.protoType.hashCode());
    }
}

class MemberCloneable implements Serializable, Cloneable {

    private static final long serialVersionUID = -852425408646046728L;


    private String cloneName;


    private String cloneClass;

    //构造器
    public MemberCloneable(String cloneName, String cloneClass) {
        this.cloneName = cloneName;
        this.cloneClass = cloneClass;
    }

    //因为该类的属性，都是 String, 因此我们这里使用默认的 clone 完成即可
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
