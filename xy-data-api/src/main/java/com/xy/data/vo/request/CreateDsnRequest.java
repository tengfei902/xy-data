package com.xy.data.vo.request;

import com.xy.infrustruction.definition.DbType;
import com.xy.infrustruction.definition.connection.ConnectInfo;
import lombok.Data;

import java.io.Serializable;

@Data
public class CreateDsnRequest implements Serializable {
    private String dsn;
    private DbType dbType;
    private Long accountId;
    private ConnectInfo connectInfo;
}
