package chapter4

import scala.collection.mutable

object ChecksumAccumulator {
  private val cache = mutable.HashMap.empty[String, Int]

  def calculate(s: String): Int = {
    if (cache.contains(s))
      cache(s)
    else {
      val accumulator = new ChecksumAccumulator
      for (character <- s)
        accumulator.add(character.toByte)
      val cs = accumulator.checksum()
      cache += (s -> cs)
      cs
    }
  }
}

class ChecksumAccumulator {
  private var sum = 0
  def add(b: Byte) : Unit = sum += b
  def checksum() : Int = ~(sum & 0xFF) + 1
}
