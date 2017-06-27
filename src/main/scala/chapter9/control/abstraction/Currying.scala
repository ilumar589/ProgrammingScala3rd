package chapter9.control.abstraction

import java.io.{File, PrintWriter}

object Currying {
  def plainOldSum(x: Int, y: Int): Int = x + y
//  plainOldSum(1,2)

  def curriedSum(x: Int)(y: Int): Int = x + y
//  curriedSum(1)(2) - two executions back to back
//  Curried partially applied function
//  val partial = curriedSum(1)_
//  val result = partial(2)
//  result = 3

  def simulateCurrying(x: Int) = (y: Int) => x + y
//  val executionOne = simulateCurrying(1)
//  val executionTwo = executionOne(3)
//  executionTwo =

  def twice(op: (Double => Double), x: Double): Double = op(op(x))

  def withPrintWriter(file: File, op: PrintWriter => Unit): Unit = {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }

//  One way in which you can make the client code look a bit more like a built-in control structure is to use curly braces instead of parentheses to surround
//  the argument list. In any method invocation in Scala in which you’re passing in exactly one argument, you can opt to use curly braces to surround
//  the argument instead of parentheses.
  def curriedWithPrintWriter(file: File)(op: PrintWriter => Unit) = {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }
}
