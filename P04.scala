// Find the number of elements of a list.

object P04 {
  def main(args: Array[String]) {

    // built in function
    def f0[T](list: List[T]): Int = {
      list.length
    }

    // recursive
    def f1[T](list: List[T]): Int = list match {
      case Nil => 0
      case _ :: tail => 1 + f1(tail)
    }

    // map each element to 1 and sum
    def f2[T](list: List[T]): Int = {
      list.map(_ => 1).sum
    }

    // use view to avoid creating a temporary list
    def f3[T](list: List[T]): Int = {
      list.view.map(_ => 1).sum
    }

    // tail recursive
    def f4[T](list: List[T]): Int = {
      def tailRec(n: Int, ls: List[T]): Int = ls match { 
        case Nil => n
        case _ :: tail => tailRec(n + 1, tail)
      }
      tailRec(0, list)
    }

    // fold
    def f5[T](list: List[T]): Int = {
      list.foldLeft(0)((x, _) => x + 1)
    }

    val list = List(1, 2, 3, "Str")
    println("should print 4")
    println(f0(list))
    println(f1(list))
    println(f2(list))
    println(f3(list))
    println(f4(list))
    println(f5(list))
  }
}
