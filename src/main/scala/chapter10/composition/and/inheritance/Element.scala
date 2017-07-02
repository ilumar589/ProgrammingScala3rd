package chapter10.composition.and.inheritance

import Element.elem

object Element {

  /**
    *
    * @param contents - parametric field (prefixed by val
    *                 It creates a class parameter and field
    *                 at the same time and because Scala has
    *                 methods and fields in the same namespace
    *                 val contents overrides def contents)
    */
  private class ArrayElement (
                               override val contents: Array[String]
                              ) extends Element {}

  private class LineElement(line: String) extends Element {
    override def contents: Array[String] = Array(line)
    override def width: Int = line.length
    override def height: Int = 1
  }

  private class UniformElement (
                                 ch: Char,
                                 override val width: Int,
                                 override val height: Int
                                ) extends Element {

    private val line = ch.toString * width

    override def contents: Array[String] = Array.fill(height)(line)
  }


  def elem(contents: Array[String]) : Element = new ArrayElement(contents)
  def elem(line: String) : Element = new LineElement(line)
  def elem(ch: Char, width: Int, height: Int) : Element = new UniformElement(ch, width, height)
}

abstract class Element {
  /**
    *
    * @return an array of strings, each
    *         string representing an
    *         element's line
    */
  def contents : Array[String]

  /**
    *
    * @return the number of element lines
    */
  def height: Int = contents.length

  /**
    *
    * @return length of the first line
    */
  def width: Int = if (height == 0) 0 else contents(0).length

  def above(that: Element) : Element = {
    val widenedThis = this widen that.width
    val widenedThat = that widen this.width
    elem(widenedThis.contents ++ widenedThat.contents)
  }

  def beside(that: Element) : Element = {
    val heightenedThis = this heighten that.height
    val heightenedThat = that heighten this.height
    elem(for {
      (line1, line2) <- heightenedThis.contents zip heightenedThat.contents
    } yield line1 + line2)
  }

  override def toString: String = contents mkString "\n"

  private def widen(w: Int) : Element = {
    if (w <= width) this
    else {
      val left = elem(' ', (w - width) / 2, height)
      val right = elem(' ', w - width - left.width, height)
      left beside this beside right
    }
  }

  private def heighten(h: Int) : Element = {
    if (h <= height) this
    else {
      val top = elem(' ', width, (h - height) / 2)
      val bot = elem(' ', width, h - height - top.height)
      top above this above bot
    }
  }
}
