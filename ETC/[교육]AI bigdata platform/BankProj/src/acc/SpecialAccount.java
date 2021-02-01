package acc;

import exp.AccountException;

/* SpecialAccount
 * grade : VIP,Gold,Silver,Normal
 * 설명: 등급별 입금시마다 입금액을 추가한다.(VIP:0.04,Gold:0.03,Silver:0.01,Normal:0.01)
 *      즉, 등급이 VIP일 경우 10000원 입금시 10400월 입금된다.
 */
public class SpecialAccount extends Account {
	String grade;

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public SpecialAccount() {}
	public SpecialAccount(String id, String name, int money, String grade) {
		super(id,name,money);
		this.grade=grade;
	}

	@Override
	public boolean deposit(int money) throws AccountException {
		double rate=0;
		switch(grade) {
		case "VIP": rate=0.04; break;
		case "Gold": rate=0.03; break;
		case "Silver": rate=0.02; break;
		case "Normal": rate=0.01; break;
		}
		return super.deposit(money+(int)(money*rate));
	}

	@Override
	public String accInfo() {
		// TODO Auto-generated method stub
		return super.accInfo()+", 등급:"+grade;
	}
}
