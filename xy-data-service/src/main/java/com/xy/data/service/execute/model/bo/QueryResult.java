package com.xy.data.service.execute.model.bo;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class QueryResult {
    private List<Map<String,Object>> records;
    private long offset;
    private long limit;
    private long total;
}
