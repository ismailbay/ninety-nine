// Flatten a nested list structure

object P07 {
  def main(args: Array[String]) {

    // built-in flatMap with pattern matching, recursive
    def f0[T](list: List[T]): List[T] = list flatMap {
      case xs: List[T] => f0(xs)
      case x => List(x)
    }

    val list = List(List(1, 1), 2, List(3, List(4, List(5))))
    println("should print List(1, 1, 2, 3, 4, 5)")
    println(f0(list))
  }
}

