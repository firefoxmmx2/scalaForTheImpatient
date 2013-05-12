package eg

import scala.io.Source
import java.io.File

object Eg21_2 {
	
	implicit def file2RichFile(from: File) = new RichFile(from)
	def main(args: Array[String]): Unit = {
		val contents = new File("/home/hooxin/google-reader-subscriptions.xml").read
		
		println(contents)
	}

	class RichFile(val from: File) {
		def read: String = Source.fromFile(from).mkString
	}
}