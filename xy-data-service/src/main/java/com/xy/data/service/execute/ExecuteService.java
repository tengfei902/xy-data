package com.xy.data.service.execute;

import com.xy.data.service.execute.model.bo.ExecuteQuery;
import com.xy.data.service.execute.model.bo.QueryResult;

public interface ExecuteService {
    QueryResult select(ExecuteQuery request);

    Integer update(ExecuteQuery request);

    Boolean ddl(ExecuteQuery request);

    String explain(ExecuteQuery request);
}
