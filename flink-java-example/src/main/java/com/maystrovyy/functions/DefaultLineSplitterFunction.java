package com.maystrovyy.functions;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

import java.util.Arrays;

public class DefaultLineSplitterFunction implements FlatMapFunction<String, Tuple2<String, Integer>> {

    @Override
    public void flatMap(String value, Collector<Tuple2<String, Integer>> collector) {
        Arrays.asList(value.toLowerCase().split("\\W+"))
                .forEach(token -> collector.collect(new Tuple2<>(token, 1)));
    }

}