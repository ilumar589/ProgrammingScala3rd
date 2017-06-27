package chapter10.composition.and.inheritance


class UniformElement (
                     ch: Char,
                     override val width: Int,
                     override val height: Int
                     ) extends Element {

  private val line = ch.toString * width

  override def contents: Array[String] = Array.fill(height)(line)
}