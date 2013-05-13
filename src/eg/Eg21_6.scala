package eg

object Eg21_6 {
	//利用隐式参数进行隐式转换
	def smailer[T](a: T, b: T)(implicit order: T => Ordered[T]) =
		if (order(a) > b) a else b

	def smailer2[T](a: T, b: T)(implicit order: T => Ordered[T]) =
		if (a > b) a else b
	def main(args: Array[String]): Unit = {
		println(smailer(5, 7))
		println(smailer("hello", "world"))
		println(smailer2(5, 7))
		println(smailer2("hello", "world"))
	}

}