interface I{
	void method();
}
class A{
	
}
class B extends A{
	
}
class C extends B implements I{
	public void method() {}
}
class D extends A implements I{
	public void method() {}
}
public class InterfaceSample3 {
	public static void Func(I e) {
		e.method();
	}
	
	public static void main(String[] args) {
		Func(new C());
		Func(new D());

	}

}
