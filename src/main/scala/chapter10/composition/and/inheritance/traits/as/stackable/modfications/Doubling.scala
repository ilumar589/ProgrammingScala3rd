package chapter10.composition.and.inheritance.traits.as.stackable.modfications

trait Doubling extends IntQueue{
  abstract override def put(x: Int) = super.put(2 * x)
}
