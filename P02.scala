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

    // init selects all elements except the last one
    def f2[T](list: List[T]): T = list.init.last

    // with index
    def f3[T](list: List[T]): T = {
      if (list.length > 1) list(list.length - 2)
      else throw new NoSuchElementException
    }

    // TODO: function composing & lifting

    val list = List(1, 2, 3, 4)
    println("should print 3")
    println(f0(list))
    println(f1(list))
    println(f2(list))
    println(f3(list))
  }
}
