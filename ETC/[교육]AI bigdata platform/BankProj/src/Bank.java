import java.util.Scanner;
//발생하는곳에서 던져주면 나머지는 함수에서 중간 호출을 해주는 것이다. 최종 처리는 캐치로 처리해주는 것이다.
import acc.SpecialAccount;
import exp.AccountException;
import exp.BankExpCode;
import acc.Account;
public class Bank {
	Scanner sc = new Scanner(System.in);
	Account[] accs = new Account[100];
	int accCnt;
	
	public int getAccCnt() {
		return accCnt;
	}
	
	public void createAccount() throws AccountException {
		System.out.println("--------");
		System.out.println("일반계좌생성");
		System.out.println("--------");
		System.out.print("계좌번호:");
		String id = sc.nextLine();
		System.out.print("이름:");
		String name = sc.nextLine();
		System.out.print("초기입금액:");
		int money = Integer.parseInt(sc.nextLine());
		try {
			searchAccById(id);
				throw new AccountException(BankExpCode.EXIST_ACC);
		}catch(AccountException e) {
			if (e.getErrCode() == BankExpCode.EXIST_ACC)
				throw e;
			accs[accCnt++] = new Account(id,name,money);
			System.out.println("결과:계좌가 개설되었습니다.");
		}	
	}
	public void createSpecialAccount() throws AccountException {
		System.out.println("--------");
		System.out.println("특수계좌생성");
		System.out.println("--------");
		System.out.print("계좌번호:");
		String id = sc.nextLine();
		System.out.print("이름:");
		String name = sc.nextLine();
		System.out.print("초기입금액:");
		int money = Integer.parseInt(sc.nextLine());
		System.out.print("등급(VIP:1, Gold:2, Silver:3, Normal:4):");
		int ngrade = Integer.parseInt(sc.nextLine());
		String grade = "Normal";
		switch(ngrade) {
		case 1: grade="VIP"; break;
		case 2: grade="Gold"; break;
		case 3: grade="silver"; break;
		case 4: grade="Normal"; break;

		}
		try {
			if(accCnt != 0 && searchAccById(id)!=null)
				throw new AccountException(BankExpCode.EXIST_ACC);
		}catch(AccountException e) {
			accs[accCnt++] = new Account(id,name,money);
			System.out.println("결과:계좌가 개설되었습니다.");
		}
	}
	public void accsList() throws AccountException {
		System.out.println("------------------------");
		System.out.println("1.일반계좌 | 2.특수계좌 | 3.전체");
		System.out.println("------------------------");
		System.out.print("선택>>");
		int sel = Integer.parseInt(sc.nextLine());
		System.out.println("---------");
		
		if(sel == 1) {
			System.out.println("일반계좌목록");
			System.out.println("---------");
			for(int i = 0; i<accCnt ; i++) {
				if(accs[i] instanceof SpecialAccount == false)
					System.out.println(accs[i].accInfo());
			}
		}else if(sel == 2) {
			System.out.println("특수계좌목록");
			System.out.println("---------");
			for(int i = 0; i<accCnt; i++) {
				if(accs[i] instanceof SpecialAccount)
					System.out.println(accs[i].accInfo());
			}
		}else if(sel == 3) {
			System.out.println("전체계좌목록");
			System.out.println("---------");
			for(int i = 0; i<accCnt; i++) {
				System.out.println(accs[i].accInfo());
			}
		}else {
			throw new AccountException(BankExpCode.LIST_MENU);
		}
	}
	
	private Account searchAccById(String id) throws AccountException {
		for(int i = 0; i<accCnt; i++) {
			if(accs[i].getId().equals(id)) {
				return accs[i];
			}
		}
		throw new AccountException(BankExpCode.NOT_ACC);
	}

	public void deposit() throws AccountException{
		System.out.println("--------");
		System.out.println("입금");
		System.out.println("--------");
		System.out.print("계좌번호:");
		String id = sc.nextLine();
		System.out.print("예금액:");
		int money = Integer.parseInt(sc.nextLine());
		Account acc = searchAccById(id);
		boolean flag= acc.deposit(money);
		if(flag)
			System.out.println("결과:예금을 성공하였습니다.");
		else 
			System.out.println("결과:예금을 실패하였습니다.");
	}
	public void withdraw() throws AccountException{
		System.out.println("--------");
		System.out.println("출금");
		System.out.println("--------");
		System.out.print("계좌번호:");
		String id = sc.nextLine();
		System.out.print("출금액:");
		int money = Integer.parseInt(sc.nextLine());
		Account acc = searchAccById(id);
		boolean flag= acc.withdraw(money);
		if(flag)
			System.out.println("결과:출금을 성공하였습니다.");
		else
			System.out.println("결과:잔액이 부족합니다.");
	}
	
	public void accInfo() throws AccountException{
		System.out.println("--------");
		System.out.println("계좌조회");
		System.out.println("--------");
		System.out.print("계좌번호:");
		String id=sc.nextLine();
		Account acc = searchAccById(id);
		if(acc==null) {
			System.out.println("결과:없는 계좌입니다.");
			return;
		}
		System.out.println(acc.accInfo());
		System.out.println("결과:계좌가 조회되었습니다.");
	}	
	
	public int menu() throws AccountException {
		System.out.println("------------------------------------------------");
		System.out.println("1.계좌생성 | 2.계좌조회 | 3.계좌목록 | 4.예금 | 5.출금 | 0.종료");
		System.out.println("------------------------------------------------");
		System.out.print("선택>>");
		int sel = Integer.parseInt(sc.nextLine());
		if(sel>=0 && sel<=5) return sel;
		throw new AccountException(BankExpCode.MAIN_MENU);
	}
	public void accMenu() throws AccountException{
		System.out.println("------------------");
		System.out.println("1.일반계좌 | 2.특수계좌 ");
		System.out.println("------------------");
		System.out.println("선택>>");
		int sel = Integer.parseInt(sc.nextLine());
		if(sel==1) {
			createAccount();
		}else if(sel ==2) {
			createSpecialAccount();
		}else {
			throw new AccountException(BankExpCode.ACC_MENU);
		}
	}
	public static void main(String[] args) {
		Bank bank = new Bank(); //자기자신을 포함한 객체를 생성시킬 수 있다.
		int sel;
		while(true) {
			try {
				sel=bank.menu();
				if(sel==0) break;
				switch(sel) {
				case 1: bank.accMenu(); break;
				case 2: bank.accInfo(); break;
				case 3: bank.accsList(); break;
				case 4: bank.deposit(); break;
				case 5: bank.withdraw(); break;
			}
			}catch(NumberFormatException e) {
				System.out.println("숫자만 입력이 가능합니다.");
			}catch(AccountException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
