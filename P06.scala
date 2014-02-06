// Find out whether a list is a palindrome

object P06 {
  def main(args: Array[String]) {

    // built-in functions
    def f0[T](list: List[T]): Boolean = {
      list == list.reverse
    }

    // zip
    def f1[T](list: List[T]): Boolean = {
      list.zip(list.reverse).forall(p => p._1 == p._2)
      // alternative syntax with pattern matching
      // list.zip(list.reverse).forall{case (a, b) => a == b)}
    }

    // zip, map tuples, filter all for true
    def f2[T](list: List[T]): Boolean = {
      list.zip(list.reverse).map{case (a, b) => a == b}.forall(_ == true)
    }

    val list = List(1,2,3,2,1)
    println("should print true for list: " + list)
    println(f0(list))
    println(f1(list))
    println(f2(list))
  }
}

