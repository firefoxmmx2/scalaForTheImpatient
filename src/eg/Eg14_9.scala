package eg

object Eg14_9 {

	abstract class Amount
	case class Dollar(value: Double) extends Amount
	case class Currency(value: Double, unit: String) extends Amount
	case object Nothing extends Amount
	def main(args: Array[String]): Unit = {
		val amt: AnyRef = Currency(123, "sss")
		println(amt match {
			case Dollar(v) => "$" + v
			case Currency(_, u) => "Oh noes, I got " + u
			case Nothing => ""
		})
	}
	//样例类 一种特殊的类,被经过优化以被用于模式匹配的类. 
//	当你声明样例类的时候,有下面几个事情会自动发生
//	1. 构造器中的每一个参数都成了val,除非用var显式声明
//	2. 在伴生对象中提供apply方法
//	3. 提供unapply方法让模式匹配可以工作
//	4. 将生成toString,equals, hashCode, copy方法,除非显式的声明了这些方法.
}