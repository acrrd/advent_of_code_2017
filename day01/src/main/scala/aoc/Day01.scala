package aoc

import scala.io.Source

object Day01 {
  def main(args: Array[String]): Unit = {
    val captcha = Source.stdin.getLines.mkString

    println(Part1.solve(captcha))
  }

  def parseCaptcha(captcha: String): Seq[Int] = {
    captcha.map(_.asDigit)
  }

  object Part1 {
    def solve(captcha: String): Int = {
      solve(parseCaptcha(captcha))
    }

    def solve(digits: Seq[Int]): Int = {
      digits.zip(digits.tail ++ List(digits(0))).filter({ case (a, b) => a == b }).foldLeft(0)((acc, p) => acc + p._1)
    }
  }
}