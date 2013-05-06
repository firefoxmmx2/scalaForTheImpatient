package eg

object Eg14_7 {

	def main(args: Array[String]): Unit = {
		//变量声明中的模式
		
		val (x,y) = (1,2)
		val (q,r) = BigInt(10) /% 3
		var arr = Array(0,1,2,3,4,5)
		val Array(first,second,_*) = arr
		val lst = List(1,2,3,4,5)
		val List(a,b,c,d,_*) = lst
		
		println("(x,y) == "+(x,y))
		println("(q,r) == "+(q,r))
		println("(first,second) == "+(first,second));
		println("(a,b,c,d) == "+(a,b,c,d))
		//使用的对象的unapplySeq函数
	}

}