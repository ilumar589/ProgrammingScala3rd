package chapter10.composition.and.inheritance

import Element.elem

object Element {
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
    elem(contents ++ that.contents)
  }

  def beside(that: Element) : Element = {
    elem(for {
      (line1, line2) <- contents zip that.contents
    } yield line1 + line2)
  }

  override def toString: String = contents mkString "\n"
}
