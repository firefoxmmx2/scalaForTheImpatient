package eg

object Eg17_2 {

	def main(args: Array[String]): Unit = {
//		定义一个可变类Pair[T], 带一个swap方法,交换对偶中的组件的位置
		class Pair[T] (var first:T,var second:T) {
			def swap = {var temp = first;first = second;second = temp}
			override def toString = "("+first+","+second+")"
		}
		val p = new Pair[Int](1,2)
		println(p.swap)
		println(p)
	}

}