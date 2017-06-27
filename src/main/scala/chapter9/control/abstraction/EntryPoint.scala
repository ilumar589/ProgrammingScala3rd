package chapter9.control.abstraction

import java.io.{File, PrintWriter}
import java.util.Date

import Currying.twice
import Currying.withPrintWriter
import Currying.curriedWithPrintWriter

object EntryPoint extends App{
//  Explicit version
  twice((x: Double) => x + 1, 5)
//  Short version
  twice(_ + 1, 5)

//  Explicit version
  withPrintWriter(new File("data.txt"),
    (writer: PrintWriter) => writer.println(new Date()))

//  Short version
  withPrintWriter(new File("data.txt"),
    _ println new Date())

// Curried short version - this is suppose to be the more natural way to call it I guess. Doesn't seem so to me at the moment ( or is it seeing as the function is between
//  parentheses and looks just like a function body)
  curriedWithPrintWriter(new File("data.txt")) {
    _ println new Date()
  }
}
