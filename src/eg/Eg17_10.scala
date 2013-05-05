package eg

object Eg17_10 {
	def main(args: Array[String]) {
//		给定可变类Pair[S,T],使用类型约束定义一个swap方法,当类型参数相同时可以被调用
//		class Pair[S ,T] (var first:S,var second:T) {
//		}
		
		val juice:Juice = extractor(new Apple, appleOp)
		val juice2:Juice= extractor(new HongFuShi, pearOp)
//		val juice3:Juice = extractor(new Fruit, appleOp)
		
		val juice4:Juice  = extractor(new Pear, pearOp)
		val juice5:Drink  = extractor(new Pear, pearOp)
		
	}
	
	class Fruit
	class Apple extends Fruit
	class HongFuShi extends Apple
	class Pear extends  Fruit
	class YaLi extends  Pear
	
	class Drink
	class Juice extends Drink
	class AppleJuice extends Juice
	class PearJuice extends Juice
	
	
	def appleOp = (a:Apple) => new Juice
	def pearOp = (a:Fruit) => new Juice
	def extractor[T <: Fruit, R <: Drink] (v:T,f:T=>R):R = f(v)
}