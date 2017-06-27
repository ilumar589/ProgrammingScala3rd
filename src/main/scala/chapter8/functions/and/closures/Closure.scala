package chapter8.functions.and.closures


object Closure {
  def returnAFunction(more: Int) = (x: Int) => x + more // this returns a function
                                                        // I first thought that a function literal is assigned to the function definition !!WRONG
}
