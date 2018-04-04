package bba.com.a.model;
import java.io.Serializable;
/*------------------------------------------------------------
 *memberDto
 *-----------------------------------------------------------*/

public class Bb_MemberDto {
/////
	private int seq;
	private String id;
	private String password;
	private String bday;
	private String name;
	private String phone;
	private int sex;
	private int mileage;
	private int grade;
	private int exp;
	private int del;
	
	public Bb_MemberDto(int seq, String id, String password, String bday, String name, String phone, int sex, int mileage,
			int grade, int exp, int del) {
		super();
		this.seq = seq;
		this.id = id;
		this.password = password;
		this.bday = bday;
		this.name = name;
		this.phone = phone;
		this.sex = sex;
		this.mileage = mileage;
		this.grade = grade;
		this.exp = exp;
		this.del = del;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
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
	public String getBday() {
		return bday;
	}
	public void setBday(String bday) {
		this.bday = bday;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getDel() {
		return del;
	}
	public void setDel(int del) {
		this.del = del;
	}
	
	@Override
	public String toString() {
		return "KhMemberDto [seq=" + seq + ", id=" + id + ", password=" + password + ", bday=" + bday + ", name=" + name
				+ ", phone=" + phone + ", sex=" + sex + ", mileage=" + mileage + ", grade=" + grade + ", exp=" + exp
				+ ", del=" + del + "]";
	}
	
	
}
