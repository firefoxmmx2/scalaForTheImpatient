package eg

import scala.util.parsing.combinator.RegexParsers
import scala.util.parsing.combinator.syntactical.StandardTokenParsers


object Eg19 {

	def main(args: Array[String]): Unit = {
		val parser = new ExpreParser
		val result = parser.parseAll(parser.expr, "3-4*5")
		if (result.successful) println(result.get)
		
		val parser2 = new ExpreParser2
		val result2 = parser2.parseAll(parser2.expr, "(3-4)*5")
		if(result2.successful) println(result2.get)
		
	}

	class ExpreParser extends RegexParsers {
			val number = "[0-9+]".r
			
			def expr:Parser[Any] = term ~ opt(("+"|"-") ~ expr)
			def term: Parser[Any] = factor ~ rep("*" ~ factor)
			def factor:Parser[Any] = number | "(" ~ expr ~ ")"
//			def term : Parser[Int] = factor ~ rep("*" ~ factor) ^^ {
//				case f ~ r => f * r.map(_._2).product
//			}
//			def factor:Parser[Int] = number ^^ {_.toInt}
//			def expr:Parser[Int ] = term ~ opt(("+"|"-") ~ expr) ^^ 
//			{
//				case t ~ None => t
//				case t ~ Some("+"~e) => t+e
//				case t ~ Some("-"~e) => t-e
//			}
		}
		
	class ExpreParser2 extends StandardTokenParsers{
		lexical.delimiters += ("+","-","*","(",")")
		
		def expr : Parser[Any] = term ~ rep(("+"|"-")~term)
		def term: Parser[Any] = factory ~ rep("*"~>factory)
		def factory: Parser[Any] = numericLit | "("~>expr~>")"
		
		def parseAll[T](p:Parser[T],in:String): ParseResult[T] =
			phrase(p)(new lexical.Scanner(in))
	}
}