package com.zjy.mapper;

import com.zjy.pojo.Department;
import com.zjy.pojo.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        employees = new HashMap<>();
       try {
           employees.put(1, new Employee(1, "小赵", "zjyhhube@163.com", 1, new Department(101, "开发部"), format.parse("1996-10-1")));
           employees.put(2, new Employee(2, "小张", "zhangyujuan@hhu.com", 0, new Department(102, "测试部"), format.parse("1997-2-1")));
           employees.put(3, new Employee(3, "小傅", "fuwenqina@dlut.com", 0, new Department(103, "运维部"), format.parse("1996-11-1")));
           employees.put(4, new Employee(4, "小方", "fangsiyue@hhu.com", 0, new Department(104, "销售部"), format.parse("1997-8-1")));
           employees.put(5, new Employee(5, "小李", "liyangmeng@hhu.com", 0, new Department(105, "行政部"), format.parse("1997-6-1")));
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

    public Employee getEmployeeById(Integer id) {
        return employees.get(id);
    }

    public int addEmployee(Employee employee) {
        if (employee.getId() == null) employee.setId(primaryId++);
        employee.setDepartment(departmentMapper.getDepartmentById(employee.getDepartment().getId()));
        System.out.println("添加了~~" + employee);
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
    @Test
    public void testDate() {
        System.out.println(getEmployeeById(1));
    }

    @Test
    public void allEmps() {
        System.out.println(selectEmployees());
    }
}
