package eg

object Eg17_1 {

	/**
	 * 定义一个不可变类型Pair[T,S],带一个swap方法,返回组件交换过位置的新对偶
	 * @param args
	 */
	def main(args: Array[String]): Unit = {
		class Pair[T,S](val first:T,val second:S) {
			def swap = new Pair(second,first)
			override def toString = "("+first+","+second+")"
		}
		
		val p = new Pair[Int,String](1,"2")
		println(p)
		println(p.swap)
	}

}