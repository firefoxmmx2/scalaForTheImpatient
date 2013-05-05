package eg

import scala.collection.mutable.ArrayBuffer
import java.awt.Rectangle
import java.awt.geom.Area

object Eg18_6 {

	def main(args: Array[String]): Unit = {
//		同时满足的泛型.
		val image = new ArrayBuffer[java.awt.Shape with java.io.Serializable]
		val rect = new Rectangle(5,10,20,30)
		image += rect
//		image += new Area(rect) 他应该是错的
		
	}

}