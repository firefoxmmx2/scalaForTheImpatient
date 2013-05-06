package eg

object Eg14_15 {

	sealed abstract class TrafficLightColor
	case class Dollar(value: Double) extends TrafficLightColor
	case object Red extends TrafficLightColor
	case object Yellow extends TrafficLightColor
	case object Green extends TrafficLightColor

	def main(args: Array[String]): Unit = {
		val color:AnyRef = Red
		val messge = color match {
			case Red => "stop"
			case Yellow => "hurry up"
			case Green => "go"
		}
		
		println(messge)
	}

}