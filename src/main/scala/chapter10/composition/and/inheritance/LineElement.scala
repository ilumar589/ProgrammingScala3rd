package chapter10.composition.and.inheritance


class LineElement(line: String) extends ArrayElement(Array(line)){
  override def width: Int = line.length
  override def height: Int = 1
}
