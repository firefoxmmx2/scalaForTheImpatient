package ex

import eg.Eg21_1.Fraction

object Ex21_5 {
	//利用隐式参数进行隐式转换
	def smailer[T](a: T, b: T)(implicit order: T => Ordered[T]) =
		if (order(a) > b) a else b

	def smailer2[T](a: T, b: T)(implicit order: T => Ordered[T]) =
		if (a > b) a else b
		
	def smailer3[T](a:T, b:T) (implicit order:T=>Fraction) =
		if (a < b) a else b
		
	def main(args: Array[String]): Unit = {
		println(smailer3(Fraction(3,2),Fraction(3,1)))
	}

}