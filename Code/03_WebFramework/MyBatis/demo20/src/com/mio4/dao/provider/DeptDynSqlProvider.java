package com.mio4.dao.provider;

import com.mio4.domain.Dept;
import org.apache.ibatis.jdbc.SQL;

import static com.mio4.util.common.HrmConstants.DEPTTABLE;

public class DeptDynSqlProvider {

    //动态更新
    public String updateDept(Dept dept){
        return new SQL(){
            {
                UPDATE(DEPTTABLE);
                if(dept.getName() != null){
                    SET(" name = #{name}");
                }
                if(dept.getRemark() != null){
                    SET(" remark = #{remark}");
                }
                WHERE("id = #{id}");
            }
        }.toString();
    }
}
