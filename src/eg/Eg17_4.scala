package eg

object Eg17_4 {

	def main(args: Array[String]): Unit = {
//		如果我们想把Pair[Person]的第一个组件换成Student,为什么不需要给replaceFirst方法定一个下界
		class Pair[T](val first:T,val second:T){
			def replaceFirst[T](newFirst:T) = new Pair(newFirst,second)
		}
	}

}