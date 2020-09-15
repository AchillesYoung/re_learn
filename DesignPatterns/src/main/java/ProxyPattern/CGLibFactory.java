//package ProxyPattern;
//
//import java.lang.reflect.Method;
//
//import org.springframework.cglib.proxy.Enhancer;
//import org.springframework.cglib.proxy.MethodInterceptor;
//import org.springframework.cglib.proxy.MethodProxy;
//
//public class CGLibFactory implements MethodInterceptor {
//
//
//
//	private Object target;
//
//
//	public CGLibFactory () {
//		super();
//	}
//	public CGLibFactory(Object taObject) {
//		super();
//		this.target = taObject;
//	}
//
//
//	public Object createXXOO() {
//		//��ǿ��
//		Enhancer enhancer = new Enhancer();
//		// �������࣬��Ϊ������
//		enhancer.setSuperclass(Girl.class);
//		// ���ûص���
//		enhancer.setCallback(this);
//		return enhancer.create();
//	}
//
//
//	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
//
//		System.out.println("Ǯ");
//		method.invoke(target, args);
//		System.out.println("��");
//		return null;
//	}
//
//
//
//}
