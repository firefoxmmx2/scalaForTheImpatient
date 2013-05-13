package eg

object Eg21_1 {
	implicit def int2Fraction(n:Int	) = Fraction(n,1)
	case class Fraction(num:Int,num2:Int){
		def * (target:Fraction):Fraction = new  Fraction(this.num * target.num ,this.num2*target.num2)
		def < (target:Fraction):Boolean = 
			if(this.num < target.num) true
			else if(this.num == target.num && this.num2 < this.num2) true
			else false
//		def apply(n:Int,n2:Int) = new Fraction(n,n2)
//		def unapply()
	}
	class Fraction2(val num:Int,val num2:Int){
		def * (target:Fraction2) = new Fraction2(this.num * target.num, this.num2 * target.num2)
	}
	def main(args: Array[String]): Unit = {
		val f = Fraction(4,5)
		val result = 3 * f
		println(result)
	}

}