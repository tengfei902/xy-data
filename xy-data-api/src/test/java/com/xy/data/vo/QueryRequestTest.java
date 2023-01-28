package com.xy.data.vo;

import com.google.gson.Gson;
import com.xy.data.vo.request.QueryRequest;
import com.xy.data.vo.request.UpsertRequest;
import org.junit.Test;

import java.util.HashMap;

public class QueryRequestTest {

    @Test
    public void testBuildQueryRequest() {
        String dsn = "";
        String sql = "";
        QueryRequest queryRequest = QueryRequest.build(dsn,sql).params(new HashMap<>()).compare(null).needTotalHit(false).build();
        System.out.println(new Gson().toJson(queryRequest));
    }

    @Test
    public void testBuildUpsertRequest() {
        String dsn = "";
        String sql = "";
        UpsertRequest upsertRequest = UpsertRequest.build(dsn,sql).params(new HashMap<>()).build();
        System.out.println(new Gson().toJson(upsertRequest));
    }
}
