package chapter10.composition.and.inheritance.traits.as.stackable.modfications

trait Incrementing extends IntQueue {
  abstract override def put(x: Int) = super.put(x + 1)
}
