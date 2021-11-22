package com.mio4.mapper;

import com.mio4.domain.Employee;

import java.util.HashMap;
import java.util.List;

public interface EmployeeMapper {
    List<Employee> selectEmployeeByIdLike(HashMap<String,Object> params);
    List<Employee> selectEmployeeChoose(HashMap<String,Object> params);

    Employee selectEmployeeWithId(Integer id);
    void updateEmployeeIfNecessary(Employee employee);
}
