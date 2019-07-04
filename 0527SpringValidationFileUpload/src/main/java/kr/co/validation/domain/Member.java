package kr.co.validation.domain;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Member {
	@NotBlank
	private String id;
	@NotBlank
	@Size(min=8)
	private String pw;
	private String name;
	@NotBlank
	private String nickname;
	private String mobile;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + ", nickname=" + nickname + ", mobile=" + mobile
				+ "]";
	}

	
}
