object Main extends App {
  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)

  def cleanSymbols(s: String, symbols: Set[Char]): String = {
    s.toCharArray.filterNot(symbols.contains).mkString
  }

  for (l <- lines) {
    l.split(", ").toList match {
      case string :: symbols :: Nil =>
        println(cleanSymbols(string, symbols.toSet))
    }
  }
}