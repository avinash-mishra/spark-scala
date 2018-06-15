package com.spark
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object Application {
  def countWords(sc: SparkContext) = {
    // Load our input data
    val input = sc.textFile("data/word_cound.txt")
    // Split it up into words
    val words = input.flatMap(line => line.split(" "))
    // Transform into pairs and count
    val counts = words.map(word => (word, 1)).reduceByKey { case (x, y) => x + y }
    // Save the word count back out to a text file, causing evaluation.
    counts.saveAsTextFile("data/result.txt")
    print("count is "+counts);
  }

  def main(args: Array[String]): Unit = {
    /*
      This is the entry point for spark, most likely need to change these to the actual location of spark master. A
      config file could be used like type safe config.
     */
    val conf = new SparkConf().setAppName("SparkDemo").setMaster("local[*]")
    val sc =  SparkContext.getOrCreate(conf)
    sc.setLogLevel("WARN")
    countWords(sc)
    // Now we can do whatever we want with spark!

    /*
      Always remember to stop spark when done, otherwise an error will be thrown cause its mad.
     */
    sc.stop()
  }
}
