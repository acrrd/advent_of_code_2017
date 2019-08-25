package aoc

import org.scalatest._

class Day03Spec extends FlatSpec with Matchers {

  "Day03 Part 1" should "steps for 1" in {
    Day03.Part1.stepsForData(1) shouldEqual 0
  }

  "Day03 Part 1" should "steps for 12" in {
    Day03.Part1.stepsForData(12) shouldEqual 3
  }

  "Day03 Part 1" should "steps for 23" in {
    Day03.Part1.stepsForData(23) shouldEqual 2
  }

  "Day03 Part 1" should "steps for 1024" in {
    Day03.Part1.stepsForData(1024) shouldEqual 31
  }

  "Day03 Part 2" should "first larger than 1" in {
    Day03.Part2.firstLarger(1) shouldEqual 2
  }

  "Day03 Part 2" should "first larger than 2" in {
    Day03.Part2.firstLarger(2) shouldEqual 4
  }

  "Day03 Part 2" should "first larger than 4" in {
    Day03.Part2.firstLarger(4) shouldEqual 5
  }

  "Day03 Part 2" should "first larger than 24" in {
    Day03.Part2.firstLarger(24) shouldEqual 25
  }
}
