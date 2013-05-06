package eg

object Eg14_12 {

	abstract class Item
	case class Article(description: String, price: Double) extends Item
	case class Bundle(description: String, discount: Double, items: Item*) extends Item

//	嵌套匹配
	def main(args: Array[String]): Unit = {
		val t = Bundle("father's day special", 20.0,
			Article("Scala for the Impatient", 39.95),
			Bundle("anchor distillery sampler", 10.0),
			Article("old potrero straight rye whisky", 79.95),
			Article("junipero ggin", 32.95))
		t match {
			case Bundle(_, _, Article(descr, _), _*) => println(descr)
		}

		t match {
//			使用@符号,可以把匹配内容绑定到一个 变量上.
			case Bundle(_, _, art @ Article(_, _), rest @ _*) => println(art + " and " + rest)
		}

	}

}