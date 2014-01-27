// P02: Find the last but one element of a list.

object P02 {
  def main(args: Array[String]) {
    // built-in functions chained
    def f0[T](list: List[T]): T = {
      if (list.isEmpty) throw new NoSuchElementException("list is empty")
      list.reverse.tail.head
    }

    // tail recursion
    def f1[T](list: List[T]): T = list match {
      case Nil => throw new NoSuchElementException("list is empty")
      case h :: Nil => throw new NoSuchElementException("list contains only one element")
      case List(x, _) => x
      case _ :: xs => f1(xs)
    }


    val list = List(1, 2, 3, 4)
    println("should print 3")
    println(f0(list))
    println(f1(list))
  }
}
