package aoc

import org.scalatest._

class Day02Spec extends FlatSpec with Matchers {
  "Day02.Part1" should "checksum" in {
    Day02.Part1.checksum("5 1  9 5\n7   5  3\n2   4   6 8") shouldEqual 18
  }

  "Day02.Part2" should "checksum" in {
    Day02.Part2.checksum("5 9 2 8\n9 4 7 3\n3 8 6 5") shouldEqual 9
  }
}
