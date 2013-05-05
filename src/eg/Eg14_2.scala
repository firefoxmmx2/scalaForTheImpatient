package eg

object Eg14_2 {

	def main(args: Array[String]): Unit = {
		val ch = '9'

		val sign = ch match {
			case '+' => 1
			case '-' => 2
			case '*' => 3
			case _ if Character.isDigit(ch) => Character.digit(ch, 10)
			case _ => 0

		}
		
		println(sign);
	}

}