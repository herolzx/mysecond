package com.situ.service;

import java.util.List;

import com.situ.model.Department;

public interface DepartmentService {
	/**
	 * 查询所有部门
	 */
	public List<Department> findAll();

}
