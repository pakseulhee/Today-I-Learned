package chapter5;

public class StringEqualsExample {
	public static void main(String[] args) {
		String var1 = "슬희";
		String var2 = "슬희"; //같은 메모리에 저장된 객체를 동일하게 참조한 값이다.
		
		if(var1 == var2){
			System.out.println("var1과 var2는 참조가 같음");
		}else {
			System.out.println("var1과 var2는 참조가 다름");
		}
		
		if(var1.equals(var2)) {
			System.out.println("var1과 var2는 문자열이 같음");
		}
		
		String var3 = new String("슬희");
		String var4 = new String("슬희"); //새로운 객체를 생성하였으므로 주소가 다르다.
		
		if(var3 == var4){
			System.out.println("var3과 var4는 참조가 같음");
		}else {
			System.out.println("var3과 var4는 참조가 다름");
		}
		
		if(var3.equals(var4)) {
			System.out.println("var3과 var4는 문자열이 같음");
		}
	}
}
