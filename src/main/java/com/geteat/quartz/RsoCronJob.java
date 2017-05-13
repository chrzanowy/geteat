package com.geteat.quartz;

/**
 * Created by Kuba on 2017-05-13.
 */

import com.geteat.service.IntegrationService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RsoCronJob implements Job {

    //TODO Use JMS
    @Autowired
    private IntegrationService integrationService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        integrationService.fetchLatestRso();
    }
}