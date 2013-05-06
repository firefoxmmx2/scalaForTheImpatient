package eg


object Eg14_14 {

//	密封类
	sealed abstract class Amount
	case class Dollar(value:Double) extends Amount
	case class Currency(value:Double) extends Amount
	case class Euro(value:Double) extends Amount
	
	def main(args: Array[String]): Unit = {
		
	}

}