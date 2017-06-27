package chapter10.composition.and.inheritance

/**
  *
  * @param contents - parametric field (prefixed by val
  *                 It creates a class parameter and field
  *                 at the same time and because Scala has
  *                 methods and fields in the same namespace
  *                 val contents overrides def contents)
  */
class ArrayElement (
  override val contents: Array[String]
) extends Element {

}
