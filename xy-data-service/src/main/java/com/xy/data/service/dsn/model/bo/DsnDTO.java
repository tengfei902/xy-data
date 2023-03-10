package com.xy.data.service.dsn.model.bo;

import com.xy.infrustruction.definition.DbType;
import com.xy.infrustruction.definition.connection.ConnectInfo;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DsnDTO {
    private Long dsnId;
    private String dsnName;
    private DbType dbType;
    private ConnectInfo connectInfo;
    private Long accountId;
}
