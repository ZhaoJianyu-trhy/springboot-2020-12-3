package com.zjy.mapper;

import com.zjy.pojo.Department;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentMapper {

    //模拟数据库中的数据
    private static Map<Integer, Department> departments;

    static {
        departments = new HashMap<>();
        departments.put(101, new Department(101, "开发部"));
        departments.put(102, new Department(102, "测试部"));
        departments.put(103, new Department(103, "运维部"));
        departments.put(104, new Department(104, "销售部"));
        departments.put(105, new Department(105, "行政部"));
    }

    public Collection<Department> getDepartments() {
        //我还是第一次知道这个方法
        return departments.values();
    }

    public Department getDepartmentById(Integer id) {
        return departments.get(id);
    }
}
