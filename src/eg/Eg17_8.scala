package eg

object Eg17_8 {

	def main(args: Array[String]): Unit = {
		class Pair[+T] (val first:T,val second:T) {
			def replaceFirst[R >: T] (newFirst:R) = new Pair(newFirst,second) 
		}
		
		var p = new Pair[Int](1,2)
		p = p.replaceFirst(4)
		println(p)
	}

}