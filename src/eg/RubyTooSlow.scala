package eg
/**
 * ruby is too slow
 * @author ffmmx
 *
 */
object RubyTooSlow {

	def main(args: Array[String]): Unit = {
		implicit def intWrap(b:Int) = {
			import scala.math.pow
			new {
				def **(n: Int) = pow(b,n).toLong
			}
		}
		val startTime = System.currentTimeMillis()
		val palindrome = (1l to (10 ** 7)) filter {x => isPalindrome(x) && isPalindrome(x * x)}
		println(palindrome)
		println("总时间: "+ (System.currentTimeMillis() - startTime)+" 毫秒")
	}
	
	def isPalindrome(n:Number) = n == n.toString.reverse.toLong
	

}