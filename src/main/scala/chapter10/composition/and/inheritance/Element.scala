package chapter10.composition.and.inheritance


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
    new ArrayElement(this.contents ++ that.contents)
  }

  def beside(that: Element) : Element = {
    new ArrayElement(for {
      (line1, line2) <- this.contents zip that.contents
    } yield line1 + line2)
  }
}
