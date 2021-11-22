package com.mio4.mapper;

import com.mio4.domain.Employee;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface EmployeeMapper {

    //动态查询
    @SelectProvider(type = EmployeeDynaSqlProvider.class, method =  "selectWithParams")
    List<Employee> selectWithParams(Map<String,Object> params);

    //动态插入
    @InsertProvider(type = EmployeeDynaSqlProvider.class, method = "insertEmployee")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertEmployee(Employee employee);
}
