package interview;
public class singleton {
	private static final singleton ss = new singleton();

	private singleton() {
	}

	public static singleton getInstance() {
		return ss;
	}
}
