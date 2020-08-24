package thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

//创建并使用多线程的第四种方法：使用线程池
class MyThread implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}

}

public class ThreadPoolDemo {
	public static void main(String[] args) {
		// 1.调用Executors的newFixedThreadPool(),返回指定线程数量的ExecutorService
		ExecutorService pool = Executors.newFixedThreadPool(10);
		ThreadPoolExecutor service1 = (ThreadPoolExecutor) pool;
		//设置线程池的属性
//        System.out.println(service.getClass());
//        service1.setCorePoolSize(15);
//        service1.setKeepAliveTime();
		// 2.将Runnable实现类的对象作为形参传递给ExecutorService的submit()方法中，开启线程
		// 并执行相关的run()
		pool.execute(new MyThread());
		pool.execute(new MyThread());
		// 3.结束线程的使用
		pool.shutdown();

	}
}
