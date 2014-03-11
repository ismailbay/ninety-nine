// Run-length encoding of a list

object P10 {
  import P09.f0

  def f1[T](list: List[T]): List[(Int, T)] = {
    f0(list) map { i => (i.length, i.head) }
  }

  def main(args: Array[String]) {
    val list = List(1, 1, 2, 3, 3, 3)
    println("should print List((2, 1), (1, 2), (3, 3))")
    println(f1(list))
  }
}
   
