package ProxyPattern;

public class Girl implements Person{

	public Person personInterface =null;

	@Override
	public void eat() {
		personInterface =null;
		System.out.println("Em mmm.. mm..");
	}

	@Override
	public void bath() {
		System.out.println("biubiubiu~");
	}
}
