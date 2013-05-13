package eg

object Eg21_1 {
	implicit def int2Fraction(n:Int	) = Fraction(n,1)
	case class Fraction(num:Int,num2:Int){
		def *(target:Fraction):Fraction = Fraction(this.num * target.num ,this.num2*target.num2) 
	}
	
	def main(args: Array[String]): Unit = {
		val result = 3 * Fraction(4,5)
		println(result)
	}

}