package chapter10.composition.and.inheritance.traits.as.stackable.modfications

trait Filtering extends IntQueue {
  abstract override def put(x: Int) = if (x > 0) super.put(x)
}
