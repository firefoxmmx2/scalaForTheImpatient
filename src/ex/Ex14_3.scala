package ex

object Ex14_3 {

	def main(args: Array[String]): Unit = {
		println(swap(Array(1,2,3,4)).mkString)
	}

	def swap(arr: Array[Int]) = arr match {
		case _ if(arr.length <= 2) => throw new Exception("必须大于2个")
		case Array(first, second, arr @ _*) => Array(second, first) ++ arr
	}
}