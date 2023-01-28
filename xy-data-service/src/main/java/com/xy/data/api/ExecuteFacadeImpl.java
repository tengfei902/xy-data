package com.xy.data.api;

import com.xy.data.service.datasource.AclFactory;
import com.xy.data.service.dsn.DsnService;
import com.xy.data.service.dsn.model.bo.DsnDTO;
import com.xy.data.service.execute.ExecuteService;
import com.xy.data.service.execute.model.bo.ExecuteQuery;
import com.xy.data.vo.request.ExecuteRequest;
import com.xy.data.vo.request.QueryRequest;
import com.xy.data.vo.request.UpsertRequest;
import com.xy.data.vo.response.DataResponse;
import com.xy.data.vo.response.QueryResult;
import com.xy.inf.acl.model.AclRequest;
import com.xy.inf.acl.model.SearchRequest;
import com.xy.inf.acl.model.SearchResult;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@DubboService(version = "${dubbo.server.version}")
public class ExecuteFacadeImpl implements ExecuteFacade {
    @Autowired
    private DsnService dsnService;

    @Override
    public <T> DataResponse<QueryResult<T>> select(QueryRequest request) {
        DsnDTO dsn = dsnService.getDsn(request.getDsn());
        SearchRequest searchRequest = SearchRequest.build(request.getSql(), request.getParams()).needTotalHit(request.isNeedTotalHit()).compare(request.getCompare()).build();
        SearchResult<Map<String, Object>> searchResult = AclFactory.getInstance().getAcl(dsn).select(searchRequest);
        return DataResponse.success(QueryResult.newResult(searchResult.getRecords(),searchResult.getTotalHit()));
    }

    @Override
    public DataResponse<Integer> update(UpsertRequest request) {
        DsnDTO dsn = dsnService.getDsn(request.getDsn());
        AclRequest aclRequest = new AclRequest(request.getSql(),request.getParams());
        int cnt = AclFactory.getInstance().getAcl(dsn).update(aclRequest);
        return DataResponse.success(cnt);
    }

    @Override
    public DataResponse<Boolean> ddl(ExecuteRequest request) {
        DsnDTO dsn = dsnService.getDsn(request.getDsn());
        AclFactory.getInstance().getAcl(dsn).ddl(request.getSql());
        return DataResponse.success(true);
    }
}
