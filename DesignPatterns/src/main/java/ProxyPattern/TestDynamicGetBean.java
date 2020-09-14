package ProxyPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestDynamicGetBean {

	
	public static void main(String[] args) {


		Girl girl = new Girl();

		Person prxyGirl = (Person)Proxy.newProxyInstance(Person.class.getClassLoader(), Girl.class.getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

				System.out.println(method.getName() + " ->> emmmm..at");
				
				if (method.getName().equals("bath")) {
					System.out.println("before");
					Object invoke = method.invoke(girl, args);
					System.out.println("end");
					return invoke;
				}else {
					System.out.println("show");
					Object invoke = method.invoke(girl, args);
					System.out.println("end show");
					return invoke;
				}
			}
		});
		
		
		
		prxyGirl.eat();
		System.out.println("-----");
		prxyGirl.bath();
		
	}
}
