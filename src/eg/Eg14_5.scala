package eg

object Eg14_5 {

	def main(args: Array[String]): Unit = {
		val arr = Array(0, 2, 3)

		val result = arr match {
			case Array(0) => "0"
			case Array(x, y) => x + " " + y
			case Array(0, _*) => "0 ..."
			case _ => "something else"
		}
		println(result);

		val lst = List(0, 2)
		val result2 = lst match {
			case 0 :: Nil => "0"
			case x :: y :: Nil => x + " " + y
			case 0 :: tail => "0 ..."
			case _ => "somthing else"
		}

		println(result2)

		val tuple = (0, 0)
		val result3 = tuple match {
			case (y, 0) => y + " 0"
			case (0, _) => "0 ..."
			case _ => "something else"

		}

		println(result3)
	}

}