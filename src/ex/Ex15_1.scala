package ex

import org.junit.Test
import org.junit.Assert

object Ex15_1 {
	class JunitTestCase {
		@Test def testPrintln(): Unit = {
			println("testPrintln done")
			Assert.assertEquals(1, 1)
		}
		@Test(timeout=3000) def testSum: Unit = {
			println("testSum start ...")
			def sum(iArray: Array[Int]): Int = {
				iArray.sum
			}
			Assert.assertEquals((1 + 2 + 3), sum(Array(1, 2, 3)))

			println("testSum done ...")

		}
	}

}