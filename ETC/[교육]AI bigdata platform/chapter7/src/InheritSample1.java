class Person{
	int age;
	String name;
	public Person() {}
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String info() {
		return "이름:"+name+", 나이:"+ age;
	}
}

//생성자가 부모것이 먼저 호출이 된다. 그래서 기본생성자를 항상 만들어줘야한다.
class Student extends Person{
	String major;

	public Student(int age, String name, String major) {
		super(age,name);
//		this.age = age;
//		this.name = name;
		this.major = major;
	}
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String info() {
		// 부모꺼 쓰고 내꺼도 추가! (내꺼는 major)
		return super.info() + ", 전공:" +major;
	}
}

public class InheritSample1 {
	public static void main(String[] args) {
		Student s= new Student(20, "고길동", "산업디자인");
		System.out.println(s.info());
	}
}
