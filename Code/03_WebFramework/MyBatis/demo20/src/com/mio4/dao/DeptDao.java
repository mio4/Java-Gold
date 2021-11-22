package com.mio4.dao;

import com.mio4.dao.provider.DeptDynSqlProvider;
import com.mio4.domain.Dept;
import org.apache.ibatis.annotations.SelectProvider;

public interface DeptDao {


    //动态添加部门
    @SelectProvider(type = DeptDynSqlProvider.class,method = "updateDept")
    void update(Dept dept);
}
