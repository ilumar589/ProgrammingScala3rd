package chapter15.caseClasses.and.pattern.matching

object ArithmeticExpressionPattern {
  def simplifyExpr(expr: Expr) : Expr = expr match {
      case UnOp("-", UnOp("-", e)) => e
      case BinOp("+", e, Number(0)) => e
      case BinOp("*", e, Number(1)) => e
      case _ => expr
  }
}
