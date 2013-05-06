package ex

object Ex14_4 {

	abstract class Item
	case class Multiple(amount: Int, item: Item) extends Item {
		def price(in: Item): Double = in match {
			case Article(name, pri) => pri
			case Bundle(name, discount, articles @ _*) => discount * articles.map(price(_)).sum
		}
		def price: Double = amount * price(item)
	}
	case class Article(description: String, price: Double) extends Item
	case class Bundle(description: String, discount: Double, items: Item*) extends Item

	def main(args: Array[String]): Unit = {
		val t = Multiple(10, Bundle("package", 7.5, Article("t1", 12), Article("t2", 13), Article("t3", 14), Bundle("b2", 7, Article("t4", 20))))
		println(t.price)
		println((7.5 * (12 + 13 + 14 + 7 * 20)) * 10)
	}

}