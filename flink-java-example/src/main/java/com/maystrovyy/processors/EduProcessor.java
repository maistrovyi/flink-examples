package com.maystrovyy.processors;

import com.maystrovyy.functions.DefaultLineSplitterFunction;
import lombok.Builder;
import lombok.SneakyThrows;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.aggregation.Aggregations;
import org.apache.flink.api.java.tuple.Tuple2;

import java.util.Arrays;
import java.util.List;

public class EduProcessor {

    private final List<String> defaultData = Arrays.asList("Hello! This is a text sample", "to represent Apache Flink streaming", "Hello Hello Hello");

    private final DataSet<Tuple2<String, Integer>> data;

    @Builder(builderMethodName = "of", buildMethodName = "create")
    public EduProcessor(ExecutionEnvironment env) {
        this.data = env.fromCollection(this.defaultData)
                .flatMap(new DefaultLineSplitterFunction())
                .groupBy(0)
                .aggregate(Aggregations.SUM, 1);
    }

    @SneakyThrows
    public void printData() {
        this.data.print();
    }

}