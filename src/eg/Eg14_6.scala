package eg

object Eg14_6 {

	def main(args: Array[String]): Unit = {
		val arr = Array(0, 2, 3)

		val result = arr match {
			case Array(0) => "0"
			case Array(x, y, z) => x + " " + y + " " + z
			case Array(0, _*) => "0 ..."
			case _ => "something else"
		}

		println(result)

		//使用"".r返回一个正则表达式匹配 
		val pattern = "([0-9]+) ([a-z]+)".r
		val (x, y) = "99 bottles" match {
			case pattern(num, item) => (num, item)
			case _ => ("somethins", "item")
		}
		//提取器模式实际上是用的 pattern.unapplySeq()函数 对象的unapplySeq函数
		println("(x,y) == "+(x,y))
	}

}