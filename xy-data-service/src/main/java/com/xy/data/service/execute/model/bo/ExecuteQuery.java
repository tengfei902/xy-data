package com.xy.data.service.execute.model.bo;

import com.xy.data.service.dsn.model.bo.DsnDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Builder
@Data
public class ExecuteQuery {
    private DsnDTO dsn;
    private String sql;
    private Map<String,Object> params;
    private Compare compare;

    @Data
    public static class Compare {
        private String compareWhere;
        private List<CompareMode> compareModes;
    }

    public enum CompareMode {
        NUMBER,
        INCREASE_NUMBER,
        INCREASE_RATE
    }
}
