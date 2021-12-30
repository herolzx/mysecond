package com.situ.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Employee {
	private Integer id;
	private String employeeId;
	private String name;
	private String departmentId;
	private String sex;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	private Double salary;
	private String phone;
	private Department department;// 关联的对象
	// private String localBirthday;

	private String portrait;// 头像

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	/**
	 * 返回本地日期格式
	 * 
	 * @return
	 */

	/*
	 * public void setLocalBirthday(String birthday) { SimpleDateFormat sdf = new
	 * SimpleDateFormat("yyyy-MM-dd"); if (birthday != null) { try { this.birthday =
	 * sdf.parse(birthday); } catch (ParseException e) { e.printStackTrace(); } }
	 * 
	 * }
	 */

	public String getLocalBirthday() {
		if (birthday == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(birthday);
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

}
