import scala.sys.SystemProperties

object Main extends App {
  val props = new SystemProperties
  props.get("sun.cpu.endian").foreach {
    case "little" => println("LittleEndian")
    case "big" => println("BigEndian")
  }
}
