package com.xy.data.api;

import com.xy.data.vo.request.ExecuteRequest;
import com.xy.data.vo.request.QueryRequest;
import com.xy.data.vo.request.UpsertRequest;
import com.xy.data.vo.response.DataResponse;
import com.xy.data.vo.response.QueryResult;

public interface ExecuteFacade {
    /**
     * 查询
     * @param request
     * @return
     * @param <T>
     */
    <T> DataResponse<QueryResult<T>> select(QueryRequest request);

    /**
     * update、insert、delete
     * @param request
     * @return
     */
    DataResponse<Integer> update(UpsertRequest request);

    /**
     * ddl
     * @param request
     * @return
     */
    DataResponse<Boolean> ddl(ExecuteRequest request);
}
