package aoc

import org.scalatest._

class Day06Spec extends FlatSpec with Matchers {
  "Day06 Part1 " should "return 5 on [0, 2, 7, 0] " in {
    Day06.Part1.redistributionsBeforeLoop(List(0, 2, 7, 0)) shouldEqual 5
  }
}
