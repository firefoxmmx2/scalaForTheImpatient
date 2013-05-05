package eg

object Eg18_1 {

	def main(args: Array[String]): Unit = {
		object Title
		class Document {
			private var useNextArgAs: Any = null
			def set(obj:Title.type): this.type = {useNextArgAs = obj; this}
			def to(value : String) = if (useNextArgAs == Title) value
		}
		
		class Book extends Document {
			var chapterList = List[String]()
			var title:String = null
			def addChapter(chapter:String) = {chapterList.addString(new StringBuilder(chapter)); this}
			def setTitle(title:String):this.type = {this.title = title; this}
			
		}
		
		val book = new Book()
		book set Title to "scala for the impatient"
		
	}

}