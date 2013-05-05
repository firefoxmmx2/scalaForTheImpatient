package eg


object Eg18_5 {

	def main(args: Array[String]): Unit = {
		def appendLines(target:{def append(str:String):Any},lines:Iterable[String]) {
			for(l<-lines) {target.append(l);target.append("\n")}
			
		}
		val sb = new StringBuilder
		appendLines(sb, List("hello","world","oh","yeah"))
		println(sb)
	}

}