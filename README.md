## Apache Storm(http://storm.apache.org/)
Apache Storm is a free and open source distributed realtime computation system. Storm makes it easy to reliably process unbounded streams of data, doing for realtime processing what Hadoop did for batch processing. 

---------------
Storm users define topologies for how to process the data when it comes streaming in from the spout. When the data comes in, it is processed and the results are passed into Hadoop or Database.

######STORM module:######
* Tuples – an ordered list of elements.
* Streams – an unbounded sequence of tuples.
* Spouts – sources of streams in a computation (e.g. a Twitter API)
* Bolts – process input streams and produce output streams. They can: run functions; filter, aggregate, or * join data; or talk to databases.
* Topologies – the overall calculation, represented visually as a network of spouts and bolts (as in the following diagram)

---------------

This project implement WordCountTopology which include WordSpitterBolt and WordCounterBolt.
