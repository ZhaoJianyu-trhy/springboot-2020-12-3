package com.zjy.controller;

import com.zjy.mapper.EmployeeMapper;
import com.zjy.pojo.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Collection;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

    @Resource
    EmployeeMapper employeeMapper;

    @RequestMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeMapper.selectEmployees();
        model.addAttribute("emps", employees);
        return "/emp/list";
    }

    @RequestMapping("/toAddPage")
    public String toAddPage() {
        return "/emp/toAddPage";
    }

    @RequestMapping("/addEmp")
    public String toAddPage(Employee employee) {
        employeeMapper.addEmployee(employee);
        return "/emp/list";
    }
}
