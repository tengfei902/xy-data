package com.xy.data.service.dsn.impl;

import com.google.gson.Gson;
import com.xy.data.dao.DsnDao;
import com.xy.data.enums.DsnStatus;
import com.xy.data.service.datasource.ConnectPreCheck;
import com.xy.data.service.dsn.DsnService;
import com.xy.data.service.dsn.model.bo.DsnDTO;
import com.xy.data.service.dsn.model.po.DsnPO;
import com.xy.infrustruction.definition.connection.ConnectInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DsnServiceImpl implements DsnService {
    @Autowired
    private DsnDao dsnDao;

    /**
     * 创建dsn
     * 1.检查用户权限
     * 2.检查dsn连接是否成功
     * 3.保存dsn
     * 4.创建连接池
     * @param dsn
     */
    @Override
    public void createDsn(DsnDTO dsn) {
        DsnPO dsnPO = new DsnPO();
        dsnPO.setDbType(dsn.getDbType().name());
        dsnPO.setDsn(dsn.getDsnName());
        dsnPO.setConnectInfo(new Gson().toJson(dsn.getConnectInfo()));
        dsnDao.insertSelective(dsnPO);
        //pre connect
        if(ConnectPreCheck.preCheck(dsn.getDbType(),dsn.getConnectInfo())) {
            DsnPO updateDsnStatus = new DsnPO();
            updateDsnStatus.setId(dsnPO.getId());
            updateDsnStatus.setStatus(DsnStatus.VALID.getCode());
            dsnDao.updateByPrimaryKeySelective(updateDsnStatus);
        }
    }

    @Override
    public void checkDsn(ConnectInfo connectInfo) {

    }

    @Override
    public DsnDTO getDsn(String dsn) {
        return null;
    }
}
