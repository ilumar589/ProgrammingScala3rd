package chapter8.functions.and.closures

import Closure.returnAFunction
import DefineFunctionAsParameter.testFunctionAsParameter
import DefineFunctionAsParameter.functionAssignmentDestination

object EntryPoint extends App{
  println(testFunctionAsParameter(1, 2, functionAssignmentDestination))

  val aList  = List(1, 2, 3, 4, 5)
//  aList.foreach(println)   // shorthands for single parameters
//  aList.foreach(println(_))
//  aList.foreach(println _)


//  ! There are two ways to assign a function to a val/var (function value)
  val f = (x: Int) => x // function literal

  def gDef(x: Int) : Int = x
  val g = gDef _ // define a function like you would normally would in a language like Java/C++ and assigning the partially applied version to a function value

  def gDefWithMultipleParameters(x: Int, y: Int, z: Int) = x * y * z
  val gmp = gDefWithMultipleParameters(_: Int, _: Int ,10) // an example with multiple parameters/ now we can call gmp only with 2 params

  val inc1 = returnAFunction(1)
  val inc2 = returnAFunction(999)

  println(inc1(1))
  println(inc2(1))

  // pass variable number of parameters to a function
  def multipleParameters(paramList: Int*) : Seq[Int] = for (param <- paramList) yield param

  println(multipleParameters(1))
  println(multipleParameters(1, 998, 2, 343))

  // for passing an array of appropriate type
  val arrayParam = Array(55, 66)
  println(multipleParameters(arrayParam: _*))

  // tail recursive - the compiler makes a jump to the beginning of of the function !THIS ONLY HAPPENS WHEN THE LAST LINE IS THE FUNCTION CALL ITSELF
  def doSomethingRecursive(x: Int) : Int = {
    if (x == 0) x else doSomethingRecursive(x - 1)
  }

  // assign a partially applied function without defining it first
  val funValue = nestedFun _ // weird how you can define the nested fun function after the assignation, would never had imagined
  def nestedFun(x: Int) : Unit = {
    if (x != 0) {
      println(x)
      funValue(x + 1) // a function value is called last so tail call optimization won't work because of the jvm
    }
  }

  testFunctionAsParameter(1, 2, _ + _)
}
