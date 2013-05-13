package ex

object Ex21_2 {

	implicit def int2RichIntImp(x:Int) = new {
		def +%(n:Int) = x + x * n/100
	}
	
	def main(args: Array[String]): Unit = {
		println(120 +% 10)
	}

}