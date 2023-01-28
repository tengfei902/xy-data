package com.xy.data.service.dsn;

import com.xy.data.service.dsn.model.bo.DsnDTO;
import com.xy.infrustruction.definition.connection.ConnectInfo;

public interface DsnService {

    void createDsn(DsnDTO dsn);

    void checkDsn(ConnectInfo connectInfo);

    DsnDTO getDsn(String dsn);
}
