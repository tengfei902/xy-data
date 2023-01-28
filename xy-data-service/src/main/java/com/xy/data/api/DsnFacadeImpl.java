package com.xy.data.api;

import com.xy.data.vo.request.CreateDsnRequest;
import com.xy.data.vo.response.DataResponse;
import com.xy.data.vo.response.DsnBriefVO;
import com.xy.data.vo.response.DsnDetailVO;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.List;

@DubboService(version = "${dubbo.server.version}")
public class DsnFacadeImpl implements DsnFacade {
    @Override
    public DataResponse<Boolean> createDsn(CreateDsnRequest createDsnRequest) {
        return null;
    }

    @Override
    public DataResponse<Boolean> deleteDsn(Long accountId, Long dsnId) {
        return null;
    }

    @Override
    public DataResponse<DsnDetailVO> getDsn(Long accountId, Long dsnId) {
        return null;
    }

    @Override
    public DataResponse<List<DsnBriefVO>> getDsnList(Long accountId) {
        return null;
    }
}
