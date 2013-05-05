package eg

object TypeBound {

	def main(args: Array[String]): Unit = {
		val test1 = new Pair3[Int](4,2)
		println(test1.smaller)
		val test2 = new Pair4[Int](4,2)
		println(test2.smaller)
		
	}

//	给类型加一个上界,必须为Comparable的子类,不然编译器检查不通过
//	val test1 = new Pair[Int](4,2) //当这句代码编译的时候会出错,因为Int不具备Comparable资格
	class Pair[T <: Comparable[T]](val first:T,val second:T) {
		def smaller = if(first.compareTo(second) < 0) first else second
	}
	class Pair2[T](val first:T,val second:T) {
		def replaceFirst(newFirst:T) = new Pair2[T](newFirst,second)
		def replaceFirst2[R >: T](newFirst:R) = new Pair2(newFirst,second)
	}
//	Int 和 RichInt之间存在一个隐式转换,这样以来,就可以通过视图界定达到这个效果,
//	视图界定必须要求参数类型T 和 界定类型V之间必须存在一个T到V的隐式转换
//	val test1 = new Pair3[Int](4,2) //这句就可以正确的编译,
	class Pair3[T <% Comparable[T]] (val first:T,val second:T) {
		def smaller = if(first.compareTo(second) < 0) first else second
	}
//	上下文界定
	class Pair4[T:Ordering](val first:T,val second:T){
		def smaller(implicit ord:Ordering[T]) = if (ord.compare(first, second) < 0) first else second
		def makePair[T : Manifest](first:T,second:T) {
			val r = new Array[T](2);r(0) = first;r(1) = second;r
		}
	}
//	上界可以和多个特质合在一起,限定类型范围,不能有多个上界,如 T <: Comparable[T] <: Ordering
	class Pair5[T <: Comparable[T] with Serializable with Cloneable](val first:T,val second:T){
		def smaller = if(first.compareTo(second) < 0) first else second
	}
	
	class Pair6[T >: java.util.ArrayList[String]](val first:T, val second:T) {
		def smaller = if(first == second ) first else second
	}
//	可有多个视图界定
	class Pair7[T <% Comparable[T] <% String](val first:T,val second : T) {
		def smaller = if(first.compareTo(second) < 0) first else second
	}
//	还可以有多个上下文界定
	class Pair8[T:Ordering:Manifest] (val first:T,val second:T)
}