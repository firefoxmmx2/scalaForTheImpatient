package ex

object Ex14_5 {

	def main(args: Array[String]): Unit = {
		val lst = List(1, 2, 3, List(4, 5, 6, List(7, 8, 9)))
		def leafSum(treeList: List[Any]):Int = {
			var s = 0
			treeList match {
				case List(arr @ _*) => arr.map(x => x match {
					case x:Int => s += x
					case List(arrx @ _*) => s += leafSum(arrx.toList)
				})
			}
			s
		}
		
		println(leafSum(lst))
		println(1+2+3+4+5+6+7+8+9)
		println((1+2+3+4+5+6+7+8+9) == leafSum(lst))
	}

}