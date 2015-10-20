package com.rich.storm.topology;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.utils.Utils;

import com.rich.storm.bolt.WordCounterBolt;
import com.rich.storm.bolt.WordSpitterBolt;
import com.rich.storm.spout.LineReaderSpout;

/**
 * Execute word-count topology, which use String.split function implement.
 * @author rich
 *
 */
public class WordCountTopology {

    public static void main(String[] args) {
        if (args == null || args.length < 1) {
            System.out.println("Please input inputFile file path!!");
            System.exit(-1);
        }
        
        Config config = new Config();
        config.put("inputFile", args[0]);
        config.setDebug(true);
        config.put(Config.TOPOLOGY_MAX_SPOUT_PENDING, 1);
        
        TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout("line-reader-spout", new LineReaderSpout());
        builder.setBolt("word-spitter", new WordSpitterBolt()).shuffleGrouping("line-reader-spout");
        builder.setBolt("word-counter", new WordCounterBolt()).shuffleGrouping("word-spitter");
        
        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology("HelloStorm-WordCount", config, builder.createTopology());
        Utils.sleep(10000);
        
        cluster.killTopology("HelloStorm-WordCount");
        cluster.shutdown();
    }

}
