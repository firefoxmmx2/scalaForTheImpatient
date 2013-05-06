package eg

object Eg14_16 {

	def main(args: Array[String]): Unit = {
		val scores = Map("Alice" -> "1")
		scores get "Alice" match {
			case Some(score) => println(score)
			case None => println("No score")
		}
		
		val aliceScore = scores.get("Alice")
		if (aliceScore.isEmpty) println("No score")
		else println(aliceScore.get)
		
		println(aliceScore.getOrElse("No score"))
		
		println(scores.getOrElse("back", "No score"))
		
		scores.get("back").foreach(println _)
		
	}

}