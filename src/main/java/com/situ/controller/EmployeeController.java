package com.situ.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situ.model.Department;
import com.situ.model.Employee;
import com.situ.model.EmployeeSearchBean;
import com.situ.service.DepartmentService;
import com.situ.service.EmployeeService;
import com.situ.util.ExceptionUtil;

@Controller
@RequestMapping("/employee/")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@Autowired
	private DepartmentService ds;

	@GetMapping("/one2many")
	public String testOne2Many() {
		List<Department> depatments = ds.findAll();// 查询所有部门

		return "list";
	}

	/**
	 * 查询
	 */
	@RequestMapping("/list")
	public String List(Map<String, Object> map, Integer pageNo, Integer pageSize, EmployeeSearchBean ssb) {

		// PaginateInfo pi = new PaginateInfo(pageNo, pageSize);
		// 覆盖
		/*
		 * if (pageNo != null) { pi.setPageNo(pageNo); } else {
		 * pi.setPageSize(pageSize); }
		 */

		// 使用分页插件进行分页
		PageHelper.startPage(pageNo == null ? 1 : pageNo, pageSize == null ? 10 : pageSize);

		List<Employee> employee = service.findAll(ssb);
		// 获取PageInfo对象
		PageInfo<Employee> pi = new PageInfo<>(employee);// 把结果放进去进行分页

		map.put("employee", employee);
		map.put("pi", pi);
		map.put("ssb", ssb);
		return "/employee/list";
	}

	/**
	 * 删除
	 */
	@PostMapping(value = "/delete", produces = "application/json;charset=utf-8")
	// @PostMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(Integer[] ids) {
		System.out.println(ids);
		Map<String, Object> resp = new HashMap<>();
		int rows = service.deleteByIds(ids);
		if (rows > 0) {
			resp.put("success", true);
			resp.put("rows", rows);
		} else {
			resp.put("success", false);
			resp.put("error", "删除数据时异常");
		}
		return resp;
	}

	/**
	 * 跳转到添加页面
	 */
	@GetMapping("/add")
	public String gotoAdd() {
		return "employee/add";
	}

	@PostMapping("/add")
	public ModelAndView submitAdd(Employee emp) {
		ModelAndView mav = new ModelAndView();
		if (emp.getEmployeeId() == null || emp.getEmployeeId().trim().length() == 0) {

			mav.addObject("error", "员工编号不允许为空");
			mav.setViewName("employee/add");
			mav.addObject("emp", emp);
			return mav;
		}

		Boolean success = service.save(emp);

		System.out.println(success);
		if (success) {// 成功
			ModelAndView ma = new ModelAndView();
			ma.setViewName("forward:/employee/list");
			return ma;
		} else {
			mav.addObject("error", "员工添加失败");
			// mav.addObject("emp", emp);
			mav.setViewName("forward:/employee/add");
			return mav;
		}
	}

	/**
	 * 跳转到修改页面
	 */
	@GetMapping("/edit")
	public ModelAndView gotoEdit(String id) {
		System.out.println(id);
		ModelAndView mav = new ModelAndView();
		if (id == null || id.trim().length() == 0) {
			mav.addObject("error", "未选择要修改的信息");
			mav.setViewName("employee/list");
			return mav;
		} else {
			Employee employee = service.findById(Integer.valueOf(id));
			if (employee == null) {

				mav.addObject("error", "要修改的员工信息不存在");
				mav.setViewName("employee/list");
				return mav;
			} else {
				mav.addObject("emp", employee);
				mav.setViewName("employee/edit");
				return mav;
			}
		}
	}

	/**
	 * 提交修改表单
	 */
	@PostMapping("/edit")
	public ModelAndView submitEdit(HttpServletRequest req, Employee emp,
			@RequestParam(name = "portrait-pic") MultipartFile file) {
		System.out.println(file.getName());
		System.out.println(file.getSize());
		System.out.println(file.getOriginalFilename());

		ModelAndView mav = new ModelAndView();// 创建对象

		if (emp.getEmployeeId() == null || emp.getEmployeeId().trim().length() == 0) {
			mav.addObject("error", "员工编号不允许为空");
			mav.addObject("emp", emp);
			mav.setViewName("employee/edit");
			return mav;
		}

		String uid = UUID.randomUUID().toString();// 保证不重复的随机数
		String originalName = file.getOriginalFilename();// 获取原始文件名
		int lidx = originalName.lastIndexOf(".");// 获取文件名中“.”的位置
		String ext = originalName.substring(lidx + 1);// 截取"."后的内容,也就上传文件的扩展名 as:jpg
		// 外部路径：
		// String fullName = Global.UPLOAD_PORTRAIT_PATH + uid + "." + ext;// 拼出不重复的文件名
		// 内部路径：
		String portrait = req.getServletContext().getRealPath("upload/image/portrait");// 获取路径
		String fullName = portrait + "/" + uid + "." + ext;
		File target = new File(fullName);

		try {
			file.transferTo(target);
			emp.setPortrait("upload/image/portrait" + "/" + uid + "." + ext);// 给emp头像属性设置地址

			System.out.println(fullName);// 输出路径好判断路径是否正确

		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Boolean success = service.update(emp);
		// 如果成功
		if (success) {
			mav.setViewName("redirect:/employee/list");
			return mav;
		} else {
			mav.addObject("error", "员工修改信息失败");
			mav.addObject("emp", emp);
			mav.setViewName("employee/edit");
			return mav;
		}
	}

	@ExceptionHandler
	public ModelAndView handelException(Exception exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("title", exception.getMessage());// 异常的简短概括
		mav.addObject("exception", ExceptionUtil.exceptionToString(exception));// 调用工具类显示异常的堆栈信息
		mav.addObject("popup", true);// popup是布尔值
		mav.addObject("error", "控制错误");
		mav.setViewName("global/error");
		return mav;
	}

}
