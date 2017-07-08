package chapter10.composition.and.inheritance.traits.as.stackable.modfications

import scala.collection.mutable.ArrayBuffer

class BasicIntQueue extends IntQueue {
  private val buffer = new ArrayBuffer[Int]

  def get = buffer.remove(0)
  override def put(x: Int) = buffer += x
}

class MyQueue extends BasicIntQueue with Doubling // seems very verbose but it seems that
// you can't just use the final class that has your desired behaviour defined with a stackable trait.
// you have to create a separate class which extends the final behaviour class and combine traits there or
// add the traits when instantiating
