package chapter15.caseClasses.and.pattern.matching

import ArithmeticExpressionPattern.simplifyExpr
import math.{E, Pi}

object EntryPoint extends App{
  println(simplifyExpr(UnOp("-", UnOp("-", Var("x")))))

  E match {
    case Pi => println(Pi)
    case _ =>
  }

  E match {
    case pi => println(pi) // this will print the constant E because it's a variable pattern and catches everything
                           // scala identifies a variable pattern if the name starts with a lowercase letter
  }
}
