package chapter6.functional.objects

object EntryPoint extends App{
  implicit def intToRational(x: Int) = new Rational(x)
  println(new Rational(66, 42))
}
