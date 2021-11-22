package com.mio4.dao;

import com.mio4.dao.provider.JobDynSqlProvider;
import com.mio4.domain.Job;
import org.apache.ibatis.annotations.UpdateProvider;

public interface JobDao {

    //动态更新
    @UpdateProvider(type = JobDynSqlProvider.class, method = "")
    void update(Job job);
}
