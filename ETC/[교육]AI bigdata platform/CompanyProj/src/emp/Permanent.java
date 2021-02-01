package emp;

public class Permanent extends Employee{
	int pay;
	public Permanent(String id, String name, int pay) {
		super(id, name);
		this.pay = pay;
	}
	@Override
	public int getPay() {
		return pay;
	}
	@Override
	public String info() {
		return super.info()+", 급여:"+getPay();
	}	
}
