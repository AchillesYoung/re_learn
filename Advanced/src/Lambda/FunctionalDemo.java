package Lambda;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * TODO
 *java内置的接口函数式
 */
public class FunctionalDemo {
    @Test
    public void LambdaGrammar() {
        /**
         * 内置的cusumer，predit
         */
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("price"+"_"+aDouble);
            }
        });
        System.out.println("*****lambda*****");

        happyTime(300, aDouble -> System.out.println("lambda"+"_"+aDouble));
    }
    public void happyTime(double price, Consumer<Double> con) {
        con.accept(price);
    }
}
