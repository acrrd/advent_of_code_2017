package aoc

import org.scalatest._

class Day04Spec extends FlatSpec with Matchers {
  "Day04 Part 1" should "pwd 'aa bb cc dd ee' is valid" in {
    Day04.Part1.isPasswordValid("aa bb cc dd ee") shouldEqual true
  }

  "Day04 Part 1" should "pwd 'aa bb cc dd aa' is valid" in {
    Day04.Part1.isPasswordValid("aa bb cc dd aa") shouldEqual false
  }

  "Day04 Part 1" should "pwd 'aa bb cc dd aaa' is valid" in {
    Day04.Part1.isPasswordValid("aa bb cc dd aaa") shouldEqual true
  }
}
