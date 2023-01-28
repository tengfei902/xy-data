package com.xy.data.service.execute.impl;

import com.xy.data.service.datasource.AclFactory;
import com.xy.data.service.execute.ExecuteService;
import com.xy.data.service.execute.model.bo.ExecuteQuery;
import com.xy.data.service.execute.model.bo.QueryResult;
import com.xy.inf.acl.model.SearchResult;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ExecuteServiceImpl implements ExecuteService {

    @Override
    public QueryResult select(ExecuteQuery request) {
        return null;
    }

    @Override
    public Integer update(ExecuteQuery request) {
        return null;
    }

    @Override
    public Boolean ddl(ExecuteQuery request) {
        return null;
    }

    @Override
    public String explain(ExecuteQuery request) {
        return null;
    }
}
