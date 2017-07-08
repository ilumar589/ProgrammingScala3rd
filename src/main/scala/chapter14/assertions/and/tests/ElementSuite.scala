package chapter14.assertions.and.tests

import chapter10.composition.and.inheritance.Element.elem
import org.scalatest.FunSuite

class ElementSuite extends FunSuite{

  test("elem result should pass width test") {
    val element = elem('x', 2, 3)
    assert(element.width == 2)
  }
}
