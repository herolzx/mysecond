package com.situ.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.situ.model.Employee;
import com.situ.model.EmployeeSearchBean;

@Mapper
public interface EmployeeDAO {

	public List<Employee> findAll(EmployeeSearchBean ssb);

	/**
	 * 根据编号唯一查询
	 */
	public Employee findById(Map<String, Object> params);

	/**
	 * 根据编号批量删除
	 * 
	 * @param ids
	 * @return
	 */
	public int deleteByIds(@Param(value = "ids") List<Integer> ids);

	/**
	 * 添加
	 */
	public int save(Employee employee);

	/**
	 * 修改
	 */
	public int update(Employee emp);

}
