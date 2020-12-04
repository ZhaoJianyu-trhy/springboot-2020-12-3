package com.zjy.controller;

import com.zjy.mapper.DepartmentMapper;
import com.zjy.mapper.EmployeeMapper;
import com.zjy.pojo.Department;
import com.zjy.pojo.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

    @Resource
    EmployeeMapper employeeMapper;

    @Resource
    DepartmentMapper departmentMapper;

    @RequestMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeMapper.selectEmployees();
        model.addAttribute("emps", employees);
        return "/emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model) {
        Collection<Department> departments = departmentMapper.getDepartments();
        model.addAttribute("dep", departments);
        return "/emp/toAddPage";
    }

    @PostMapping("/emp")
    public String toAddPage(Employee employee) {
        System.out.println(employee);
        employeeMapper.addEmployee(employee);
        return "redirect:/emp/emps";
    }

    @GetMapping("/edit")
    public String editEmp(@RequestParam("id") Integer id, Model model) {
        Employee employee = employeeMapper.getEmployeeById(id);
        model.addAttribute("editInfo", employee);
        Collection<Department> departments = departmentMapper.getDepartments();
        model.addAttribute("dep", departments);
        return "/emp/toEditPage";
    }

    @RequestMapping("/delete")
    public String editEmp(@RequestParam("id") Integer id) {
        employeeMapper.deleteEmployeeById(id);
        return "redirect:/emp/emps";
    }
}
