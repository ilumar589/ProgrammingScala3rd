package chapter15.caseClasses.and.pattern.matching


object CaseSeqAsPartialFunctions {
  // So case sequences are basically similar to function literals
  // but have cases inside the body

  // this is the syntax for a function literal
  val opt: Option[Int] => Int = {
    case Some(x) => x
    case None => 0
  }

  // use it like opt(Some(10))

  // functions like these are used in akka
//  val receiver = {
//    case   ...
//    case   ...
//  }

  // this is the syntax for an anonymous function used directly in another function
  //(opt: Optional[Int]) => {//function body}

  // application with partial functions

//  val second: List[Int] => Int = {
//    case x :: y :: _ => y
//  }

//  val second: PartialFunction[List[Int],Int] = {
//    case x :: y :: _ => y
//  }
}
