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

  def filesEndingWith(query: String) = filesMatching(_ endsWith query)

  def filesContaining(query: String) = filesMatching(_ contains query)

  def filesFromRegex(query: String) = filesMatching(_ matches query)
}
