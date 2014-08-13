# Hadoop Samples
A project with samples of hadoop mapreduce and hdfs programs.

## Dependencies
Just install dependencies described in ivy file (ivy.xml).

More about [apache ivy](http://ant.apache.org/ivy/) and [apache ivy plugin for eclipse](http://ant.apache.org/ivy/ivyde/).

## Exporting jar file
In eclipse, just run the exportjar.jardesc file. Will build jar into `/tmp/hadoop-samples.jar`

## Running samples

* Word count sample
`hadoop jar hadoop-sample.jar com.hadoopsample.samples.WordCountSample /path-to-input-file.csv /path-to-output-folder`
