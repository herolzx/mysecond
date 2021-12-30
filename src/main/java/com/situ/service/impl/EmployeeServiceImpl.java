package com.situ.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.dao.EmployeeDAO;
import com.situ.model.Employee;
import com.situ.model.EmployeeSearchBean;
import com.situ.service.EmployeeService;

/**
 * 实现
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
	private static final Log LOGGER = LogFactory.getLog(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeDAO dao;

	@Autowired
	private SqlSessionFactory sqlSessionFactory;// 自动注入一个会话工厂

	/**
	 * 返回所有学生
	 */
	public List<Employee> findAll(EmployeeSearchBean ssb) {

		// long start = System.currentTimeMillis();
		// LOGGER.info("检测查询全体学生");

		List<Employee> employee = dao.findAll(ssb);

		// long during = System.currentTimeMillis() - start;
		// LOGGER.info("检测到查询全体学生结束，用时：" + during + "ms");
		return employee;
	}

	/**
	 * 根据编号唯一查询
	 */
	public Employee findById(Integer id) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		return dao.findById(map);// 自动查询
		// 创建一个SqlSession会话 手动查询
//		SqlSession session = sqlSessionFactory.openSession();
//		Employee emp = session.selectOne("com.situ.dao.EmployeeDAO.findById", map);
//		session.close();// 关闭会话
//		return emp;

	}

	/**
	 * 根据id删除
	 */
	public int deleteByIds(Integer[] ids) {
		return dao.deleteByIds(Arrays.asList(ids));
	}

	/**
	 * 添加
	 */
	public boolean save(Employee employee) {

		try {
			int id = dao.save(employee);
			System.out.println("返回主键为：" + employee.getId());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 修改
	 */
	public boolean update(Employee employee) {
		return dao.update(employee) > 0;
	}

}
