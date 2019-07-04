package kr.co.validation.domain;

import org.springframework.web.multipart.MultipartFile;

public class Report {
	private String name;
	private MultipartFile imgfile;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MultipartFile getImgfile() {
		return imgfile;
	}
	public void setImgfile(MultipartFile imgfile) {
		this.imgfile = imgfile;
	}
	@Override
	public String toString() {
		return "Report [name=" + name + ", imgfile=" + imgfile + "]";
	}
}
