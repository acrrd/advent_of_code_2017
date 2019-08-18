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

}
