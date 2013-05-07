package ex

object Ex01 {

	//	出一个练手题: def strtr(src:String, from:String, to:String):String
	//from 和 to是等长的字符串, 要求将src中值为from(i)的字符转换成to(i)
	//
	//例如: strtr("abcdaf", "ac", "AC") == "AbCdAf"
	//
	//用scala
	def main(args: Array[String]): Unit = {
		def strtr(src: String, from: String, to: String): String = {
			src.map(x => x match {
				case _ if (from.find(p => p == x) != None) => val a =to.toArray; a(from.indexOf(x))
				case _ => x
			})
		}		
		
		def strtr2(src:String,from:String,to:String):String = {
			val zipped = (from.toList zip to.toList).toMap
			src.map(x => zipped.getOrElse(x,x))
		}
		
		println(strtr2("abcdaf", "ac", "AC"))
		println(strtr("abcdaf", "ac", "AC"))
		
	}

}