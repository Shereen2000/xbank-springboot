//Ignore this service i use it to test some of the terminologies i encounter when debugging some of the projects code
package com.tumiso.xbank.services;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ExampleService {

    private final String alert = "lunch time";

    @PostConstruct
    public void init() {
        log.info(String.format("***** %S INIT *****", alert));
    }

    @Scheduled(cron = "0 34 13 * * ?")
    public synchronized  void execute() {
        log.info(String.format("***** %S EXECUTE *****", alert));
        System.out.println(String.format("***** %S END *****", alert));
    }
}
