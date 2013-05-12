package eg

object Eg21_5 {

	case class Delimiters(left:String,right:String)
	def quote(what:String)(implicit delims:Delimiters) = 
		delims.left + what + delims.right
	implicit val quoteDelimiters = Delimiters("<<",">>")
	
	def main(args: Array[String]): Unit = {
		println(quote("Bonjour le monde"))
	}

}