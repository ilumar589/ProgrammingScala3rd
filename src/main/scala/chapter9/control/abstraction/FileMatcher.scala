package chapter9.control.abstraction

import java.io.File

object FileMatcher {

  private def filesInCurrentDirectory = new File(".").listFiles()

  private def filesMatching(query: String, method: (String, String) => Boolean) = {
    for {
      file <- filesInCurrentDirectory
      if method(file.getName, query)
    } yield file
  }

  def filesEndingIn(q: String): Array[File] = {
    filesMatching(q, _ endsWith _)
  }

  def filesContaining(q: String) : Array[File] = {
     filesMatching(q, _ contains _)
  }

  def filesRegex(q: String) : Array[File] = {
//    filesMatching(q, _ matches _)
//    the more explicit form is
    filesMatching(q, (fileName: String, query: String) => fileName.matches(query))
//    ! The way this works is the compiler looks at the signature of the method expected to be passed
//    to fileMatching and each _ is a placeholder for the parameters and _ matches _ is the function body
//    !!! Placeholders only work when the parameter is used only once in the body of the function. In this case
//    both parameters are used only once in the function body
  }
}
