package ex

object Ex15_2 {

	def main(args: Array[String]): Unit = {
		val test = new AnnotationTest
		test.test
		test.preTest
	}

	
	class AnnotationTest {
		@deprecated(message="this method will be deleted. using preTest method")
		def test:Unit = {
			println("tesing")
		}
		
		def preTest:Unit = {
			println("preTest")
		}
	}
}