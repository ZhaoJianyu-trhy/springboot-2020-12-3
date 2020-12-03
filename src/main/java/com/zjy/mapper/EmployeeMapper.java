package com.zjy.mapper;

import com.zjy.pojo.Department;
import com.zjy.pojo.Employee;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeMapper {

    //模拟数据库中的数据
    private static Map<Integer, Employee> employees;
    @Resource
    private DepartmentMapper departmentMapper;
    private static Integer primaryId = 6;

    static {
        employees = new HashMap<>();
        employees.put(1, new Employee(1, "小赵", "zjyhhube@163.com", 1, new Department(101, "开发部"), new Date(1996-10-1)));
        employees.put(2, new Employee(2, "小张", "zhangyujuan@hhu.com", 1, new Department(101, "开发部"), new Date(1997-2-1)));
        employees.put(3, new Employee(3, "小傅", "fuwenqina@dlut.com", 1, new Department(101, "开发部"), new Date(1996-11-1)));
        employees.put(4, new Employee(4, "小方", "fangsiyue@hhu.com", 1, new Department(101, "开发部"), new Date(1997-8-1)));
        employees.put(5, new Employee(5, "小李", "liyangmeng@hhu.com", 1, new Department(101, "开发部"), new Date(1997-6-1)));
    }

    public Employee getEmployeeById(Integer id) {
        return employees.get(id);
    }

    public int addEmployee(Employee employee) {
        employee.setId(primaryId++);
        employee.setDepartment(departmentMapper.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
        return 1;
    }

    public Collection<Employee> selectEmployees() {
        return employees.values();
    }

    public int deleteEmployeeById(Integer id) {
        employees.remove(id);
        return 1;
    }
}
