package eg

object Eg17_6 {

	def main(args: Array[String]): Unit = {
		def middle[T](x: Iterable[T]) = if (x.size % 2 == 0) x.slice(x.size / 2 - 1, x.size / 2+1) else x.slice(x.size / 2, x.size / 2+1)
		println(middle("strings"))
	}

}