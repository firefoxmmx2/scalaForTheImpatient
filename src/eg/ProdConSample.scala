package eg

object ProdConSample {

	class Product(drop:Drop) extends Runnable{
		val importantInfo :Array[String] = Array("Mares eat oats",
				"Does eat oats",
				"Little lambs  eat ivy",
				"A kid will eat ivy too")
		override def run():Unit = {
			importantInfo.foreach(msg => drop.put(msg))
			drop.put("DONE")
		}
	}
	
	class Consumer(drop:Drop) extends Runnable {
		override def run():Unit = {
			var message = drop.take()
			while(message != "DONE"){
				System.out.format("MESSAGE RECEIVED:%s%n", message)
				message = drop.take()
			}
		}
	}
	
	class Drop{
		var message:String = ""
		var empty : Boolean = true
		var lock:AnyRef = new Object()
		
		def put(x:String):Unit = lock.synchronized {
			await(empty == true)
			empty = false
			message = x
			lock.notifyAll
		}
		
		def take():String = lock.synchronized{
			await(empty == false)
			empty = true
			lock.notifyAll()
			message
		}
		
		private def await(cond: => Boolean) = while(!cond){lock.wait()}
	}
	def main(args: Array[String]): Unit = {
		val drop = new Drop()
		new Thread(new Product(drop)).start()
		new Thread(new Consumer(drop)).start()
	}

}