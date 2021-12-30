package com.situ.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.situ.model.Department;

@Mapper
public interface DepartmentDAO {
	/**
	 * 根据一个编号查询部门
	 */
	public Department findById(Integer id);

	/**
	 * 根据部门编号查询
	 */
	public List<Department> findAll();
}
