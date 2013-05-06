package eg

object Eg14_10 {

	abstract class Amount
	case class Dollar(value: Double) extends Amount
	case class Currency(value: Double, unit: String) extends Amount
	case object Nothing extends Amount
	
	def main(args: Array[String]): Unit = {
		val amt = Currency(29.95,"EUR")
		val price = amt.copy()
		val price1  = amt.copy(value=19.25)
		val price2 = amt.copy(unit = "CHF")
		
		println(price)
		println(price1)
		println(price2)
		
	}

}