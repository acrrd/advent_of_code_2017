package aoc

import scala.io.Source

object Day04 {
  def main(args: Array[String]): Unit = {
    val passwords = Source.stdin.getLines().toSeq

    println(Part1.countValidPasswords(passwords))
    println(Part2.countValidPasswords(passwords))
  }

  def isPasswordValidCommon(password: String, f: String => String) = {
    val words = password.split(" ")
    val uniqueWords = words.foldLeft(Set[String]())( (uwords: Set[String], word: String) => {
      val sw = f(word)
      uwords + sw
    })

    words.length == uniqueWords.size
  }

  object Part1 {
    def countValidPasswords(passwords: Seq[String]) = {
      passwords.filter(isPasswordValid).length
    }

    def isPasswordValid(password: String) = isPasswordValidCommon(password, w => w)
  }

  object Part2 {
    def countValidPasswords(passwords: Seq[String]) = {
      passwords.filter(isPasswordValid).length
    }

    def isPasswordValid(password: String) = isPasswordValidCommon(password, w => w.toCharArray.sorted.mkString)
  }
}
