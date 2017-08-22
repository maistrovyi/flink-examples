package com.maystrovyy;

import com.maystrovyy.processors.EduProcessor;
import org.apache.flink.api.java.ExecutionEnvironment;

public interface ApplicationStarter {

    static void main(String[] args) throws Exception {
        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        EduProcessor.of()
                .env(env)
                .create()
                .printData();
    }

}