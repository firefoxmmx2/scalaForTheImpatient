package ex

object Ex21_3 {

	class RichInt2(i:Int) {
		def xx(n:Int):Int = if(n == 1) 1 else n*xx(n-1)
		def ! :Int = xx(i)
	}
	implicit def int2RichInt2(i:Int) = new RichInt2(i)
	
	def main(args: Array[String]): Unit = {
		print("5! == " + ( 5!).toString())
	}

}