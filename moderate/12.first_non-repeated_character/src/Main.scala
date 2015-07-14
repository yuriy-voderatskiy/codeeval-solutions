object Main extends App {
  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines().filter(_.length > 0)
  for (line <- lines) {
    val counts = line.toCharArray.groupBy(c => c).mapValues(_.length)
    val ones = counts.toList.filter(t => t._2 == 1).sortBy(t => line.indexOf(t._1))
    ones.headOption.foreach(r => println(r._1))
  }
}
