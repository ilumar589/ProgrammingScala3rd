package chapter10.composition.and.inheritance


private final class LineElement(line: String) extends Element {
  override def contents: Array[String] = Array(line)
  override def width: Int = line.length
  override def height: Int = 1
}
