import scala.collection.immutable.List
import scala.collection.immutable.Nil
import scala.collection.immutable.Stream.consWrapper
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.SortedSet
import scala.io.Source
import scala.math.BigInt.int2bigInt
import scala.collection.mutable.Map
import java.io.FileInputStream

object Test2 {

	def main(args: Array[String]): Unit = {

		val digits = List(4, 2)
		println(9 :: List(4, 2))
		println(9 :: 4 :: 2 :: Nil)
		def sum(lst: List[Int]): Int = if (lst == Nil) 0 else lst.head + sum(lst.tail)
		println(sum(digits))
		val lst = scala.collection.mutable.LinkedList(1, -2, 7, -9)
		var cur = lst
		while (cur != Nil) {
			if (cur.elem < 0) cur.elem = 0
			cur = cur.next
		}
		println(lst)
		val a = 1
		var b = a
		b = 2
		println(a)

		val set = Set(2, 0, 1) + 3 + 4 + 5
		println(set)
		val weekdays = scala.collection.mutable.LinkedHashSet("Mo", "Tu", "We", "Th", "Fr")
		println(weekdays)
		println(1 to 2)
		val sorted = SortedSet
		val digits1 = Set(1, 7, 2, 9)
		println(digits1 contains 0)
		println(Set(1, 2) subsetOf digits1)
		val primes = Set(2, 3, 5, 7)
		println(primes | digits1)
		println(primes ++ digits1)
		println(primes & digits1)
		println(primes &~ digits1)
		println((primes & digits1) == (primes ++ digits1))
		println(Vector(1, 2, 3) :+ 5)
		println(1 +: Vector(1, 2, 3))
		val numbers = ArrayBuffer(1, 2, 3)
		numbers += 5
		println(numbers)
		var numbers1 = Set(1, 2, 3)
		numbers1 += 5
		var numberVector = Vector(1, 2, 3)
		numberVector :+= 5

		println(numbers1)
		println(numberVector)
		var orgset = Set(1, 2, 3)
		val diffSet = orgset - 2
		//    orgset -= 2
		println(diffSet == orgset)
		orgset - 2
		println(orgset)

		val names = List("peter", "Paul", "Mary")
		val names1 = names.map(_.toUpperCase())
		println(names1)
		val names2 = for (n <- names) yield n.toUpperCase()
		println(names2)
		def ulcase(s: String) = Vector(s.toUpperCase(), s.toLowerCase())
		println(names.map(ulcase))
		println(names.flatMap(ulcase))
		println("-3+4".collect { case '+' => 1; case '-' => -1 })
		names.foreach(println)
		//化简 或者左右合并
		println(List(1, 7, 2, 9).reduceLeft(_ * _))
		println(List(1, 7, 2, 9).reduceRight(_ - _))
		//折叠
		println()
		//拉链
		val prices = List(5.0, 20.0, 9.95)
		val quantitles = List(10, 2, 1)
		println(prices zip quantitles)
		println((prices zip quantitles) map { p => p._1 * p._2 })
		//求和
		println(((prices zip quantitles) map { p => p._1 * p._2 }) sum)
		println(List(5.0, 20.0, 9.95).zipAll(List(10, 2), 0, 1))
		println("scala".zipWithIndex)

		//流
		def numsFrom(n: BigInt): Stream[BigInt] = n #:: numsFrom(n + 1)
		val tenorMore = numsFrom(10)
		println(tenorMore)
		println(tenorMore.tail.tail.tail)
		val squres = numsFrom(1).map(x => x * x)
		println(squres)
		println(squres.take(5).force)
		//    println(squres.force)
		val gs = new Array[String](3)
		gs(0) = "aa"
		gs(1) = "bb"
		gs(2) = "cc"
		gs.foreach(print)
		println
		val ns = Array("11", "22", "33")
		ns.foreach(print)
		println
		val ll = List(1, 2, 3)
		println(ll)
		// :: 把一个元素加到列表的头上，用:::连接两个列表
		println(0 :: ll)
		val ll2 = List(4, 5, 6)
		println(ll ::: ll2)
		// 一个元素也没有的列表用Nil表示，作为一个空列表
		val n1 = 1 :: 2 :: 3 :: Nil
		println(n1)

		val thrill = "will" :: "fill" :: "until" :: Nil

		List("a", "b") ::: List("c", "d")
		thrill(2)
		thrill.count(s => s.length() == 4)
		thrill.drop(2)
		thrill.dropRight(2)
		thrill.exists(s => s == "until")
		thrill.filter(s => s.length() == 4)
		thrill.forall(s => s.endsWith("1"))
		thrill.foreach(s => print(s))
		thrill.foreach(println)
		thrill.head
		thrill.init
		thrill.isEmpty
		thrill.last
		thrill.length
		thrill.map(s => s + "y")
		thrill.mkString(",")
		thrill.reverse
		thrill.tail

		val pair = (99, "Luft")
		println(pair._1)
		println(pair._2)

		//    Set继承关系
		var jetSet = Set("Boeing", "Airbus")
		jetSet += "Lear"
		println(jetSet contains "Cessna")
		println(jetSet)
		jetSet -= "Boeing"
		println(jetSet)
		//可变版本 Set
		val movieSet = scala.collection.mutable.Set("Hitch", "Poltergeist")
		movieSet += "Shrek"
		println(movieSet)
		movieSet.remove("Shrek")

		val args = Array(1, 2, 3, 4, 5)
		for (arg <- args) println(arg)

		args.foreach(println)
		//文件IO
		val filePath = "/home/hooxin/自动保存 .xmi"
		import scala.io.Source
		Source.fromFile(filePath).getLines.foreach(line => println(line.length + " " + line))

		//符号
		val s = 'aSymbol
		s.name
		//    符号能用来，更新函数记录
		def updateRecordByName(field: Symbol, value: Any) {}
		updateRecordByName('pcOk, "Ok computer")

		//    中缀操作符
		val str = "Hello, World!"
		str indexOf ('o')
		str indexOf ('o', 5)
		//    前缀操作符
		-2.0
		(2.0).unary_-
		//    后缀操作符
		"Hello".toLowerCase
		"Hello" toLowerCase

		//    对象相等性
		1 == 2
		1 != 2
		List(1, 2, 3) == List(1, 2, 3)
		List(1, 2, 3) == List(4, 5, 6)
		1 == 1.0
		List(1, 2, 3) == "hello"
		List(1, 2, 3) == null
		null == List(1, 2, 3)
		("he" + "llo") == "hello"

		class ChecksumAccumulator {
			private var sum = 0
			def add(b: Byte) = sum += b

			def checksum(): Int = ~(sum & 0XFF) + 1

		}
		val c1 = new ChecksumAccumulator
		println(c1.add(1))

		class Rational(n: Int, d: Int) {
			require(d != 0)

			private val g = gcd(n, d)

			val numer = n / g
			val denom = d / g

			def this(n: Int) = this(n, 1)

			private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

			def +(that: Rational): Rational = add(that)
			def *(that: Rational): Rational = new Rational(numer * that.numer, denom * that.denom)

			/**
			 * 显示结果
			 */
			def showRational = println("Created " + numer + "/" + denom)
			/**
			 * 加法
			 * @param that
			 * @return
			 */
			def add(that: Rational): Rational = new Rational(numer * that.denom + that.numer * denom,
				denom * that.denom)
			/**
			 * 小于
			 * @param that
			 * @return
			 */
			def lessThan(that: Rational) = this.numer * that.denom < that.numer * this.denom

			/**
			 * 最大值
			 * @param that
			 * @return
			 */
			def max(that: Rational) = if (this.lessThan(that)) that else this

			/**
			 * 函数覆盖
			 * @return
			 */
			override def toString = n + "/" + d

			//      重载函数

			/**
			 * 加法
			 * @param i
			 * @return
			 */
			def +(i: Int): Rational = new Rational(numer + i * denom, denom)

			/**
			 * 减法
			 * @param that
			 * @return
			 */
			def -(that: Rational): Rational = new Rational(
				numer * that.denom - that.numer * denom,
				denom * that.denom)

			/**
			 * 减法整数
			 * @param i
			 * @return
			 */
			def -(i: Int): Rational = new Rational(numer - i * denom, denom)
			def *(i: Int): Rational = new Rational(numer * i, denom)

			/**
			 * 除法
			 * @param that
			 * @return
			 */
			def /(that: Rational): Rational = new Rational(
				numer * that.denom,
				denom * that.numer)
			/**
			 * 除法 整数
			 * @param i
			 * @return
			 */
			def /(i: Int): Rational = new Rational(numer * i, denom)

		}

		val r1 = new Rational(1, 2)
		val r2 = new Rational(3, 4)

		(r1 + r2).showRational
		(r1 + r1 * r2).showRational
		((r1 + r1) * r2).showRational

		val x = new Rational(2, 3)
		r1 * 2
		//    但在这里不能使用2 * r1 要是用的话必须先要，声明一个转化
		implicit def intToRational(x: Int) = new Rational(x)
		//    然后就可以 2*r1了
		2 * r1
		//    单例对象
		object SingleObjectTest {

		}

		//    伴生对象
		object ChecksumAccumulator {
			import scala.collection.mutable.Map
			private val cache = Map[String, Int]()

			def caculate(s: String): Int = {
				if (cache contains (s))
					cache(s)
				else {
					val acc = new ChecksumAccumulator
					for (c <- s) acc.add(c.toByte)
					val cs = acc.checksum
					cache += (s -> cs)
					cs
				}
			}
		}

		val res1 = ChecksumAccumulator.caculate("Every value is an object")
		println(res1)
		val res2 = ChecksumAccumulator.caculate("So simple!")
		println(res2)

		//    内建控制结构
		//    if表达式
		var filename = if (args.isEmpty) args(0) else "default.txt"
		println(if (!args.isEmpty) args(0) else "default.txt")
		//    while循环
		def gcdLoop(x: Long, y: Long): Long = {
			var a = x; var b = y
			while (a != 0) {
				val temp = a; a = b % a; b = temp
			}
			b
		}

		//    do-while
		var line = ""
		do {
			readLine.foreach(x => println("Read:" + x))
		} while (line != "")

		def gcd(x: Long, y: Long): Long = if (y == 0) x else gcd(x, x % y)

		val fileList = (new java.io.File(".")).listFiles
		for (file <- fileList) println(file)
		for (file <- fileList if file.getName().endsWith(".scala")) println(file)
		//    for 嵌套循环
		def fileLines(file: java.io.File) =
			scala.io.Source.fromFile(file).getLines.toList

		def grep(pattern: String) =
			for {
				file <- fileList
				if file.getName().endsWith(".scala")
				line <- fileLines(file)
				trimmed = line.trim()
				if trimmed.matches(pattern)
			} println(file + ": " + trimmed)

		grep(".*b.*")

		def scalaFiles = for {
			file <- fileList if file.getName().endsWith(".scala")
		} yield file

		println(scalaFiles)

		//      模式匹配
		val sc: Any = Array(1, 2, 3)
		val ch = sc match {
			case x: String => 1
			case y: Array[Int] => 2
			case z: Int => 3
			case _ => 4
		}
		println(ch);

		//  提取信息
		val pattern = "([0-9]+) ([a-z]+([0-9]*))".r
		println("99 bottles20" match {
			case pattern(num, word, wordNumber) => (num, word, wordNumber)
			case _ => 1
		})

		//	变量模式与常量模式的区别
		import Math.{ E, PI }
		E match {
			case PI => "strange math? Pi = " + PI
			case _ => "OK"

		}
		
		val s1 = ""
		s1.getClass().getTypeParameters()
		
		import java.io._
		import scala.io._
		
		println(Source.fromFile("/home/hooxin/dead.letter", "utf8").mkString);
		

	}

}