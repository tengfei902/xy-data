package com.xy.data.service.datasource;

import com.xy.data.constants.Constants;
import com.xy.data.exception.DataSourceConnectFailedException;
import com.xy.data.exception.DataSourceNotSupportException;
import com.xy.infrustruction.definition.DbType;
import com.xy.infrustruction.definition.connection.ConnectInfo;
import com.xy.infrustruction.definition.connection.impl.RdbmsConnectInfo;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;

@Slf4j
public class ConnectPreCheck {

    public static boolean preCheck(DbType dbType, ConnectInfo connectInfo) {
        switch (dbType) {
            case MYSQL:
                return preCheckForMySQL(connectInfo);
            case ORACLE:
                return preCheckForOracle(connectInfo);
            case SQLSERVER:
                return preCheckForSqlServer(connectInfo);
            case ES:
                return preCheckForEs(connectInfo);
            case TIDB:
                return preCheckForTiDB(connectInfo);
            case DORIS:
                return preCheckForDoris(connectInfo);
            case HIVE:
                return preCheckForHive(connectInfo);
        }
        throw new DataSourceNotSupportException("DataSource not support:"+dbType.name());
    }

    private static boolean preCheckForMySQL(ConnectInfo connectInfo) {
        RdbmsConnectInfo mySqlConnectInfo = (RdbmsConnectInfo) connectInfo;
        Connection connection;
        String url = Constants.MYSQL_URL.replace("{HOST}",mySqlConnectInfo.getHost())
                .replace("{PORT}",String.valueOf(mySqlConnectInfo.getPort()))
                .replace("{SCHEMA}",mySqlConnectInfo.getSchema());
        try {
            Class.forName(Constants.MYSQL_DRIVER_CLASS);
            connection = DriverManager.getConnection(url,mySqlConnectInfo.getUsername(),mySqlConnectInfo.getPassword());
            if(!connection.isClosed()) {
                log.info("dataSource connect success");
            }
            connection.close();
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    private static boolean preCheckForOracle(ConnectInfo connectInfo) {
        return false;
    }

    private static boolean preCheckForSqlServer(ConnectInfo connectInfo) {
        return false;
    }

    private static boolean preCheckForEs(ConnectInfo connectInfo) {
        return false;
    }

    private static boolean preCheckForTiDB(ConnectInfo connectInfo) {
        return false;
    }

    private static boolean preCheckForDoris(ConnectInfo connectInfo) {
        return false;
    }

    private static boolean preCheckForHive(ConnectInfo connectInfo) {
        return false;
    }
}
