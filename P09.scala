// Pack consecutive duplicates of list elements into sublists

object P09 {
  def main(args: Array[String]) {
    
    // span, splits the list into two lists, according to given predicate
    def f0[T](list: List[T]): List[List[T]] = list match {
      case Nil => Nil
      case head :: tail =>
        // a becomes the list, b the remaining part
        val (prefix, suffix) = tail.span(_ == head)
        (head :: prefix) :: f0(suffix)                           
    }   

    val list = List(1, 1, 2, 3, 3, 3)
    println("should print List(List(1, 1), List(2), List(3, 3, 3))")
    println(f0(list))
  }
}
