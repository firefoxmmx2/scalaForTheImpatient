package eg

object Eg21_4 {

	def main(args: Array[String]): Unit = {
//		隐式转换在如下三种各不相同的情况会被考虑
//		1. 当表达式的类型与预期的类型不同的时候
//		sqrt(Fraction(1,4)) //将调用fraction2Double,因为sqrt预期的是一个Double
//		2. 当对象访问一个不存在的成员的时候
//		new File("Readme").read // 将调用file2RichFile,因为File没有read方法
//		3. 当对象调用某个方法,而该方法的参数声明与传入参数不一致的时候
//		3*Fraction(4,5) //将调用int2Fraction,因为Int的*方法不接受Fraction
	}

}