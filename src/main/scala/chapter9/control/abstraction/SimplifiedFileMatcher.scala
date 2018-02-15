package chapter9.control.abstraction

import java.io.File


object SimplifiedFileMatcher {
  private def filesInCurrentDirectory = new File(".").listFiles()

  private def filesMatching(method: String => Boolean) : Array[File] = {
    for {
      file <- filesInCurrentDirectory
      if method(file.getName)
    } yield file
  }

  /**
    * Regarding this type of syntax _ endsWith query
    * remember that it just expresses the body of the function
    * instead of writing the combination of function definition
    * and body when passing it to the fileMatching function call
    */
  def filesEndingWith(query: String) = filesMatching(_ endsWith query)

  def extendedFilesEndingWith(query: String) = filesMatching((fileName: String) => fileName.endsWith(query))

  def filesContaining(query: String) = filesMatching(_ contains query)

  def filesFromRegex(query: String) = filesMatching(_ matches query)
}
