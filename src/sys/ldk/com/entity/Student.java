package sys.ldk.com.entity;

//这个实体类与数据库表中的tb_stu_info这个表对应
//对应表中的字段封装成类中的属性（成员变量）
//表名可以看做一个类名（这个类名不一定要与数据库表名一致）
public class Student {
	
	private String id;//表示数据库ID字段
	private String password;//表示数据库表中的password字段
	private String name;//表示数据库的name字段
	private String sex;
	private int	age;
	private String tele;
	private String email;
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", password=" + password + ", name=" + name + ", sex=" + sex + ", age=" + age
				+ ", tele=" + tele + "]";
	}
	
	public void tString() {
		System.out.println( "Student [id=" + id + ", password=" + password + ", name=" + name + ", sex=" + sex + ", age=" + age
				+ ", tele=" + tele + "]");
	}
	
}