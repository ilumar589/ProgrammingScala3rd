package chapter10.composition.and.inheritance.traits.as.stackable.modfications

import scala.collection.mutable.ArrayBuffer

class BasicIntQueue extends IntQueue with Doubling{
  private val buffer = new ArrayBuffer[Int]

  def get = buffer.remove(0)
  override def put(x: Int) = buffer += x
}
