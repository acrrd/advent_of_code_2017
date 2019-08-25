package aoc

import org.scalatest._

class Day04Spec extends FlatSpec with Matchers {
  "Day04 Part 1" should "pwd 'aa bb cc dd ee' is valid" in {
    Day04.Part1.isPasswordValid("aa bb cc dd ee") shouldEqual true
  }

  "Day04 Part 1" should "pwd 'aa bb cc dd aa' is not valid" in {
    Day04.Part1.isPasswordValid("aa bb cc dd aa") shouldEqual false
  }

  "Day04 Part 1" should "pwd 'aa bb cc dd aaa' is valid" in {
    Day04.Part1.isPasswordValid("aa bb cc dd aaa") shouldEqual true
  }

  "Day04 Part 2" should "pwd 'abcde fghij' is valid" in {
    Day04.Part2.isPasswordValid("abcde fghij") shouldEqual true
  }

  "Day04 Part 2" should "pwd 'abcde xyz ecdab' is not valid" in {
    Day04.Part2.isPasswordValid("abcde xyz ecdab") shouldEqual false
  }

  "Day04 Part 2" should "pwd 'a ab abc abd abf abj' is valid" in {
    Day04.Part2.isPasswordValid("a ab abc abd abf abj") shouldEqual true
  }

  "Day04 Part 2" should "pwd 'iiii oiii ooii oooi oooo' is valid" in {
    Day04.Part2.isPasswordValid("iiii oiii ooii oooi oooo") shouldEqual true
  }

  "Day04 Part 2" should "pwd 'oiii ioii iioi iiio' is not valid" in {
    Day04.Part2.isPasswordValid("oiii ioii iioi iiio") shouldEqual false
  }
}
