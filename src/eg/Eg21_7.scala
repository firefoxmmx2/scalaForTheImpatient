package eg

object Eg21_7 {

	class Pair[T: Ordering](val first: T, val second: T) {
		def smailler(implicit ord: Ordering[T]) =
			if (ord.compare(first, second) < 0) first else second
	}

	class Pair2[T: Ordering](val first: T, val second: T) {
		def smaller = if (implicitly[Ordering[T]].compare(first, second) < 0) first else second
	}
	
	class Pair3[T:Ordering] (val first:T,val second:T){
		def smailler = {
			import Ordered._
			if(first<second) first else second
		}
	}
	def main(args: Array[String]): Unit = {
		val p1 = new Pair(13,32)
		println(p1.smailler)
		val p2 = new Pair(13,32)
		println(p2.smailler)
	}

}