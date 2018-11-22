package com.kdrj.storm;

import backtype.storm.task.ShellBolt;
import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Fields;

import java.util.Map;
public  class SplitSentenceBolt extends ShellBolt implements IRichBolt{
    public  SplitSentenceBolt(){
        super("python","splitsentence.py");
    }
//public class SplitSentenceBolt extends BaseRichBolt {
//    private OutputCollector collector;
//    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
//        this.collector=outputCollector;
//    }
//
//    public void execute(Tuple tuple) {
//        String sentence=tuple.getStringByField("sentence");
//        String[] words=sentence.split(" ");
//        for(String word:words){
//            this.collector.emit(new Values(word));
//        }
//    }

    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("word"));
    }

    public Map<String, Object> getComponentConfiguration() {
        return null;
    }


}
