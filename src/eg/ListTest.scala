package eg

object ListTest {

	def main(args: Array[String]): Unit = {
		val lst = List(1, 2, 3, 4, 5)
		assert(lst.scanLeft(0)(_ + _) == List(0, 1, 3, 6, 10, 15))
		assert(lst.scanLeft(0)((x, y) => x + y) == List(0, 1, 3, 6, 10, 15))
		println("no.1 is done")
		assert(lst.scanRight(0)(_ + _) == List(15, 14, 12, 9, 5, 0))
		println("no.2 is done")
		val emp = List[Int]()
		assert(emp.scanLeft(0)(_ + _) == List(0))
		println("no.3 is done")
		assert(emp.scanRight(0)(_ + _) == List(0))
		println("no.4 is done")

		val stream = Stream(1, 2, 3, 4, 5)
		assert(stream.scanLeft(0)(_ + _) == Stream(0, 1, 3, 6, 10, 15))
		println("no.6 is done")
		assert(Stream.from(1).scanLeft(0)(_ + _).take(5) == Stream(0, 1, 3, 6, 10))
		println("no.5 is done")
	}

}