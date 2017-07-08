package chapter15.caseClasses.and.pattern.matching

import ArithmeticExpressionPattern.simplifyExpr
import math.{E, Pi}

object EntryPoint extends App{

  def listOfThreeElementsStartingWithZero(l: List[Int]) : Unit = {
    l match {
      case List(0, _, _) => println("found it")
      case _ =>
    }
  }

  def listWithoutSizeRestrictions(l: List[Int]) : Unit = {
    l match {
      case List(0, _*) => println("found it")
    }
  }

  def tupleDemo(x: Any) : Unit = {
    x match {
      case (a, b, c) => println(a, b, c)
      case _ =>
    }
  }

  def typePattern(x: Any) = x match {
    case s: String => s.length
    case m: Map[_,_] => m.size
    case _ => -1
  }

  def variableBinding(expression: Expr) = expression match {
    case UnOp("abs", e @ UnOp("abs", _)) => e
  }

  // pattern guards
  def additionToMultiplication(e: Expr) = e match {
    case BinOp("+", x, y) if x == y => BinOp("*", x, Number(2))
  }

  println(simplifyExpr(UnOp("-", UnOp("-", Var("x")))))

  E match {
    case Pi => println(Pi)
    case _ =>
  }

  E match {
    case pi => println(pi) // this will print the constant E because it's a variable pattern and catches everything
                           // scala identifies a variable pattern if the name starts with a lowercase letter
  }

  listOfThreeElementsStartingWithZero(List(0, 1, 2))
}
