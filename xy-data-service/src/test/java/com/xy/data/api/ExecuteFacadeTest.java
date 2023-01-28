package com.xy.data.api;

import com.xy.data.BaseTest;
import com.xy.data.vo.request.ExecuteRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ExecuteFacadeTest extends BaseTest {
    @Autowired
    private ExecuteFacade executeFacade;

    @Test
    public void execute() {
        ExecuteRequest executeRequest = new ExecuteRequest();
        executeRequest.setDsn(null);
        executeRequest.setSql(null);


    }
}
