package aoc

import org.scalatest._

class Day01Spec extends FlatSpec with Matchers {
  "Day01.Part1" should "solve captcha 1122" in {
    Day01.Part1.solve("1122") shouldEqual 3
  }

  "Day01.Part1" should "solve captcha 1111" in {
    Day01.Part1.solve("1111") shouldEqual 4
  }

  "Day01.Part1" should "solve captcha 1234" in {
    Day01.Part1.solve("1234") shouldEqual 0
  }

  "Day01.Part1" should "solve captcha 91212129" in {
    Day01.Part1.solve("91212129") shouldEqual 9
  }

  "Day01.Part2" should "solve captcha 1212" in {
    Day01.Part2.solve("1212") shouldEqual 6
  }

  "Day01.Part2" should "solve captcha 1221" in {
    Day01.Part2.solve("1221") shouldEqual 0
  }

  "Day01.Part2" should "solve captcha 123425" in {
    Day01.Part2.solve("123425") shouldEqual 4
  }

  "Day01.Part2" should "solve captcha 123123" in {
    Day01.Part2.solve("123123") shouldEqual 12
  }

  "Day01.Part2" should "solve captcha 12131415" in {
    Day01.Part2.solve("12131415") shouldEqual 4
  }
}
