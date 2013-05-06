package eg

object Eg14_17 {

	def main(args: Array[String]): Unit = {
		
//		偏函数
		val f:PartialFunction[Char,Int] = {case '+' => 1;case '-' => -1	}
		println(f('-')) // 调用f.apply('-')
		println(f.isDefinedAt('0')) //false
//		println(f('0')) //报错
		
		println("-3+4".collect({case '+' => 1;case '-' => -1}))
	}

}