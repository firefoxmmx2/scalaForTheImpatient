package eg

import scala.collection.mutable.ArrayBuffer

object Eg18_2 {

	def main(args: Array[String]): Unit = {
		val chatter = new Network
		val myFace = new Network
		val fred = chatter.join("Frad")
		val barney = myFace.join("Barner")
//		Description	Resource	Path	Location	Type
//type mismatch;  found   : myFace.Member  required: chatter.Member	Eg18_2.scala	/scala_test/src/eg	line 12	Scala Problem
//
//		fred.contacts += barney
		
//		val ff = new Network#Member
	}

	class Network {
		class Member(val name:String){
			val contacts = new ArrayBuffer[Network#Member]
		}
		
		private val members = new ArrayBuffer[Member]
		
		def join(name:String) = {
			val m = new Member(name)
			members += m
			m
		}
	}
}