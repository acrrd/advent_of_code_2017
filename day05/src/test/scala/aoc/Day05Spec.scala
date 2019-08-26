package aoc

import org.scalatest._

class Day05Spec extends FlatSpec with Matchers {
  "Day05 Part 1" should "exit in 3 steps with [0, 3,  0,  1, -3]" in {
    Day05.Part1.countStepsToExit(List(0, 3,  0,  1, -3)) shouldEqual 5
  }
}
