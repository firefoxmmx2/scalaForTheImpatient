package ex

object Ex14_2 {

	def main(args: Array[String]): Unit = {
		println(swap((2,1)))
	}

	def swap(tuple: (Int, Int)) = tuple match {
		case (x, y) => (y, x)
	}

}