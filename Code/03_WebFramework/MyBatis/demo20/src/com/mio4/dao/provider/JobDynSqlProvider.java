package com.mio4.dao.provider;

import com.mio4.domain.Job;
import org.apache.ibatis.jdbc.SQL;

import static com.mio4.util.common.HrmConstants.JOBTABLE;

public class JobDynSqlProvider {

    public String updateJob(Job job){
        return new SQL(){
            {
                UPDATE(JOBTABLE);
                if(job.getName() != null){
                    SET("name = #{name}");
                }
                if(job.getRemark() != null){
                    SET("remark = #{remark}");
                }
                WHERE("id = #{id}");
            }
        }.toString();
    }
}
