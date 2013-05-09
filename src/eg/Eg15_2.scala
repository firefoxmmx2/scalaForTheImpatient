package eg

object Eg15_2 {

//	自定义一个个注解
	class uncheck2 extends annotation.Annotation {
	}
	
	class Test(@uncheck2 val property:String)
	
	def main(args: Array[String]): Unit = {
		
		
	}

}