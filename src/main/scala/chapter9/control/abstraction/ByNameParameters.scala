package chapter9.control.abstraction

object ByNameParameters {
  def myAssert(predicate: () => Boolean) = if (!predicate()) throw new AssertionError()
//  call would be myAssert(() => 5 > 3)
//  You would really prefer to leave out the empty parameter list and => symbol
//  in the function literal and write the code like this:
//  myAssert(5 > 3)
  def byNameAssert(predicate: => Boolean) = if (!predicate) throw new AssertionError()
//  myAssert(5 > 3)
}
