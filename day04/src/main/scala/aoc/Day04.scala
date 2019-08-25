package aoc

import scala.io.Source

object Day04 {
  def main(args: Array[String]): Unit = {
    val passwords = Source.stdin.getLines().toSeq

    val count = Part1.countValidPasswords(passwords)
    println(count)
  }

  object Part1 {
    def countValidPasswords(passwords: Seq[String]) = {
      passwords.filter(isPasswordValid).length
    }

    def isPasswordValid(password: String) = {
      val words = password.split(" ")
      val uniqueWords = words.foldLeft(Set[String]())( (uwords: Set[String], word: String) => {
        uwords + word
      })

      words.length == uniqueWords.size
    }
  }
}
