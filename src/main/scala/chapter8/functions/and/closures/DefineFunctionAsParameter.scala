package chapter8.functions.and.closures


object DefineFunctionAsParameter {
                                              // this is a shorthand for Function2[Int, Int, Int]
  def testFunctionAsParameter(a: Int, b: Int, function2: (Int, Int) => Int): Int = function2(a, b)

  def functionAssignmentSource(a: Int, b: Int) : Int = a + b

  val functionAssignmentDestination: (Int, Int) => Int = (a: Int, b: Int) => a + b // you can only assign a function literal to a val or var
                                                                                   // I think only this function can be passed as a parameter
}
