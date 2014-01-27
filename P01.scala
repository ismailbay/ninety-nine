// P01: Find the last element of a list 

object P01 {
  def main(args: Array[String]) {
    // built-in function
    def f0[T](list: List[T]): T = list.last

    // tail recursion
    def f1[T](list: List[T]): T = list match {
      case h :: Nil => h
      case _ :: t => f1(t)
      case _ => throw new NoSuchElementException("list is empty")
    }

    // built-in functions chained
    def f2[T](list: List[T]): T = list.reverse.head

    // folding
    def f3[T](list: List[T]): T = {
      if (list.isEmpty) throw new NoSuchElementException("list is empty")
      else list.reduce((a, b) => b)
    }

    println("should print '3'")
    println(f0(List(1, 2, 3)))
    println(f1(List(1, 2, 3)))
    println(f2(List(1, 2, 3)))
    println(f3(List(1, 2, 3)))
  }
}
