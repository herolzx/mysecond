package com.situ.service;

import java.util.List;

import com.situ.model.Employee;
import com.situ.model.EmployeeSearchBean;

/**
 * EmployeeService接口
 */
public interface EmployeeService {

	public List<Employee> findAll(EmployeeSearchBean ssb);

	public int deleteByIds(Integer[] ids);

	public boolean save(Employee employee);

	public Employee findById(Integer id);

	public boolean update(Employee employee);

}
