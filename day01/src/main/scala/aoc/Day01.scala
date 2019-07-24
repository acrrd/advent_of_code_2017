package aoc

import scala.io.Source

object Day01 {
  def main(args: Array[String]): Unit = {
    val captcha = Source.stdin.getLines.mkString

    println(Part1.solve(captcha))
    println(Part2.solve(captcha))
  }

  def parseCaptcha(captcha: String): Seq[Int] = {
    captcha.map(_.asDigit)
  }

  def solve_common(captcha: String)(getOffset: Seq[Int] => Int): Int = {
    val digits = parseCaptcha(captcha)
    val offset = getOffset(digits)
    digits.zip(digits.drop(offset) ++ digits.take(offset)).filter({ case (a, b) => a == b }).foldLeft(0)((acc, p) => acc + p._1)
  }

  object Part1 {
    def solve(captcha: String): Int = {
      solve_common(captcha)(_ => 1)
    }
  }

  object Part2 {
    def solve(captcha: String): Int = {
      solve_common(captcha)(digits => digits.length/2)
    }
  }
}