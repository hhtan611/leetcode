package interview;
public class OverlloadingTest {
	public static void main(String[] args) {
		OverlloadingTest test = new OverlloadingTest();
		test.loading(null);
	}
	void loading(Object o){
		System.out.print("Object");
	}
	void loading(String s){
		System.out.print("String");
	}
	
	/*void loading(Integer o){
		System.out.print("Integer");
	}*/
}
