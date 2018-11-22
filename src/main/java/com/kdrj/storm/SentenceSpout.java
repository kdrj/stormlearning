package com.kdrj.storm;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;
import backtype.storm.utils.Utils;

import java.util.Map;

public class SentenceSpout extends BaseRichSpout {
    SpoutOutputCollector collector;
    private String[] sentences={
            "my dog has fleas",
            "i like cold beverages",
            "don't have a cove man",
            "i don't think i like fleas",
            "don't have a cow man"
    };
    private int index=0;
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("sentence"));
    }
    public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {
        this.collector=spoutOutputCollector;
    }

    public void nextTuple() {
        this.collector.emit(new Values(sentences[index]));
        index++;
        if(index>=sentences.length){
            index=0;
        }
        Utils.sleep(1);
    }


}
