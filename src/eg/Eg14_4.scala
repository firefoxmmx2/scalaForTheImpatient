package eg

object Eg14_4 {

	def main(args: Array[String]): Unit = {
		val obj: Any = Map("x"->"y")
		println(obj.getClass.getName())
		val result = obj match {
			case Int => 1
//			绑定变量
			case s: String => 2
			case c: Char => 3
			case _: BigInt => 4
			case m: Map[_,_] => 5
			case _ => 0
		}
		
		println(result);
	}

}