// Reverse a list

object P05 {
  def main(args: Array[String]) {

    // built-in function
    def f0[T](list: List[T]): List[T] = {
      list.reverse
    }
    
    // recursion
    def f1[T](list: List[T]): List[T] = list match {
      case Nil => Nil
      case head :: tail => f1(tail) ::: List(head)
    }

    // folding
    def f2[T](list: List[T]): List[T] = {
      list.foldLeft(List[T]())((xs, x) => x :: xs)
    }

    // tail recursive
    def f3[T](list: List[T]): List[T] = {
      def tailRec(result: List[T], curList: List[T]): List[T] = curList match {
        case Nil => result
        case head :: tail => tailRec(head :: result, tail)
      }
      tailRec(Nil, list)
    }

    // for comprehension, ::= adds to the head of the list
    def f4[T](list: List[T]): List[T] = {
      var tmp = List[T]()
      for (i <- list) tmp ::= i
      tmp 
    }

    val list = List(1, 2, 3, 4, 5)
    println("should print List(5, 4, 3, 2, 1)")
    println(f0(list))
    println(f1(list))
    println(f2(list))
    println(f3(list))
    println(f4(list))
  }
}
