package com.situ.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.dao.DepartmentDAO;
import com.situ.model.Department;
import com.situ.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDAO dao;

	@Override
	public List<Department> findAll() {
		return dao.findAll();
	}

}
