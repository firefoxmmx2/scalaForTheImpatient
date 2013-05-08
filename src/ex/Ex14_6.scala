package ex

object Ex14_6 {

	def main(args: Array[String]): Unit = {
		val tree = Node(Leaf(1),Node(Leaf(2),Leaf(3)))
		println(leafSum(tree))
	}

	def leafSum(tree: BinaryTree): Int = {
		tree match {
			case Leaf(x) => x
			case Node(left, right) => leafSum(left) + leafSum(right)
		}
	}
	sealed abstract class BinaryTree
	case class Leaf(value: Int) extends BinaryTree
	case class Node(leaf: BinaryTree, right: BinaryTree) extends BinaryTree
}