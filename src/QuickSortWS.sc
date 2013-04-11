object QuickSortWS {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def quickSort(list: List[Int]): List[Int] = {
    if (list.length <= 1) list
    else {
      val pivot = list.head
      val listLEG: Map[String, List[Int]] = list.groupBy(makeLEG(_, pivot))
      quickSort(listLEG.get("less").getOrElse(Nil)):::
      	listLEG.get("equal").getOrElse(Nil):::
      	quickSort(listLEG.get("greater").getOrElse(Nil))
    }
  }                                               //> quickSort: (list: List[Int])List[Int]

  def makeLEG(item: Int, pivot: Int): String = {
    if( item < pivot) "less"
    else if( item == pivot) "equal"
    else "greater"
  }                                               //> makeLEG: (item: Int, pivot: Int)String

	quickSort(List(3,1,4,1,5,9,2,6,5,3,5,9))  //> res0: List[Int] = List(1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9, 9)
}