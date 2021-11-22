package com.mio4.mapper;

import com.mio4.domain.Employee;
import org.apache.ibatis.jdbc.SQL;

import java.util.HashMap;
import java.util.Map;

public class EmployeeDynaSqlProvider {
    public String selectWithParams(Map<String,Object> param){
        return new SQL(){
            {
                SELECT("*");
                FROM("tb_employee");
                if (param.get("id") != null) {
                    WHERE("id = #{id}");
                }
                if (param.get("loginname") != null) {
                    WHERE("loginname = #{loginname}");
                }
                if (param.get("password") != null) {
                    WHERE("password = #{password}");
                }
                if(param.get("name") != null){
                    WHERE("name = #{name}");
                }
                if(param.get("sex") != null){
                    WHERE("sex = #{sex}");
                }
                if(param.get("age") != null){
                    WHERE("age = #{age}");
                }
                if(param.get("phone") != null){
                    WHERE("phone = #{phone}");
                }
                if(param.get("sal") != null){
                    WHERE("sal = #{sal}");
                }
                if(param.get("state") != null){
                    WHERE("state = #{state}");
                }
            }
        }.toString();
    }

    public String insertEmployee(Employee employee){
        return new SQL(){
            {
                INSERT_INTO("TB_EMPLOYEE");
                if(employee.getLoginname() != null){
                    VALUES ("loginname","#{loginname}");
                }
                if(employee.getPassword() != null){
                    VALUES ("password","#{password}");
                }
                if(employee.getSex() != null){
                    VALUES ("sex","#{sex}");
                }
                if(employee.getAge() != null){
                    VALUES ("age","#{age}");
                }
                if(employee.getPhone() != null){
                    VALUES ("phone","#{phone}");
                }
                if(employee.getSal() != null){
                    VALUES ("sal","#{sal}");
                }
                if(employee.getState() != null){
                    VALUES ("state","#{state}");
                }

            }
        }.toString();

    }




















}
