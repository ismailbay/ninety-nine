// Eliminate consecutive duplicates of list elements

object P08 {
  def main(args: Array[String]) {

    // tail recursive
    def f0[T](list: List[T]): List[T] = {
      def tailRec(result: List[T], curList: List[T]): List[T] = curList match {
        case Nil => result
        case head :: tail => tailRec(head :: result, tail.dropWhile(head == _)) 
      }
      tailRec(Nil, list).reverse
    }

    // foldLeft, add element to list if not found
    def f1[T](list: List[T]): List[T] = list match {
      case Nil => Nil
      case ls => ls.foldLeft(List(ls.head))((l, x) => if (l.head == x) l else x :: l).reverse
    }

    // foldRight
    def f2[T](list: List[T]): List[T] = list match {
      case Nil => Nil
      case ls => ls.foldRight(List(ls.last))((x, l) => if (l.head == x) l else x :: l)
    }
      
    val list = List(1,2,2,3,4,5,5,5,2,2)
    println("should print List(1, 2, 3, 4, 5, 2)")
    println(f0(list))
    println(f1(list))
    println(f2(list))
  }
}

