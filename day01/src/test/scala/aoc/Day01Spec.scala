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
}
