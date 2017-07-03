package chapter10.composition.and.inheritance

// like in interfaces we can't declare variables or in this case vals/vars
// but because of scala's common namespace for functions and values we can
// declare functions and override there names in the derived class
trait Rectangular {
  def topLeft : Point
  def bottomRight: Point

  def left: Int = topLeft.x
  def right: Int = bottomRight.x
  def width: Int = left - right
}
