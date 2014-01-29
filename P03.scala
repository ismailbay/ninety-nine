// Find the Kth element of a list

object P03 {
  def main(args: Array[String]) {
    
    // built in function
    def f0[T](n: Int, list: List[T]): T = {
      if (n >=0) list(n)
      else throw new NoSuchElementException("n must be >= 0")
    }

    // built in function
    def f1[T](n: Int, list: List[T]): T = {
      if (n >= 0) list.apply(n)
      else throw new NoSuchElementException("n must be >= 0")
    }

    // tail recursion
    def f2[T](n: Int, list: List[T]): T = (n, list) match {
      case (n, Nil) => throw new NoSuchElementException
      case (0, h :: tail) => h
      case (n, _ :: tail) => f2(n - 1, tail)
    }

    // drop list
    def f3[T](n: Int, list: List[T]): T = {
      if (n >= 0) list.drop(n).head
      else throw new NoSuchElementException
    }

    // split list
    def f4[T](n: Int, list: List[T]): T = {
      if (n >= 0) list.splitAt(n)._2.head
      else throw new NoSuchElementException
    }

    val list = List(1, 2, 3, 4, 5)
    val n = 2
    println("should print 3")
    println(f0(n, list))
    println(f1(n, list))
    println(f2(n, list))
    println(f3(n, list))
    println(f4(n, list))
  }
}
