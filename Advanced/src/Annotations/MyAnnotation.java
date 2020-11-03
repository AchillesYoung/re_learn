package Annotations;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * TODO
 */
@Retention(RetentionPolicy.RUNTIME)
//只有runtime的RetentionPolicy，后面反射才可以拿到
@Target({ElementType.TYPE,ElementType.METHOD})
//用于指定MyAnnotation可以修饰的类型
@Inherited
//指定该注解，可以被子类继承
public @interface MyAnnotation {

    String value();
    String [] auto();
}
