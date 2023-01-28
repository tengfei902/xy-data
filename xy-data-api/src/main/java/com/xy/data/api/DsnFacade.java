package com.xy.data.api;

import com.xy.data.vo.request.CreateDsnRequest;
import com.xy.data.vo.response.DataResponse;
import com.xy.data.vo.response.DsnBriefVO;
import com.xy.data.vo.response.DsnDetailVO;

import java.util.List;

public interface DsnFacade {
    /**
     * add
     * @param createDsnRequest
     * @return
     */
    DataResponse<Boolean> createDsn(CreateDsnRequest createDsnRequest);

    /**
     * remove
     */
    DataResponse<Boolean> deleteDsn(Long accountId, Long dsnId);

    /**
     * get single dsn detail
     * @param accountId
     * @param dsnId
     * @return
     */
    DataResponse<DsnDetailVO> getDsn(Long accountId, Long dsnId);

    DataResponse<List<DsnBriefVO>> getDsnList(Long accountId);
}
