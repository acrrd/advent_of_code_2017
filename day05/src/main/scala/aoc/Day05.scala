package aoc

import collection.mutable.{Seq => MSeq}
import scala.io.Source

object Day05 {
  def main(args: Array[String]): Unit = {
    val offsets = Source.stdin.getLines().toSeq.map(_.toInt)

    println(Part1.countStepsToExit(offsets))
    println(Part2.countStepsToExit(offsets))
  }

  def countStepsToExitCommon(offsets: Seq[Int], newValue: Int => Int): Int = {
    var os = MSeq[Int]()
    os ++= offsets
    var steps = 0
    var index = 0


    while (index >= 0 && index < os.length) {

      steps += 1
      val oldIndex = index
      val offset = os(index)
      index += offset
      os(oldIndex) += newValue(offset)
    }

    steps
  }

  object Part1 {
    def countStepsToExit(offsets: Seq[Int]): Int = countStepsToExitCommon(offsets, _ => 1)
  }

  object Part2 {
    def countStepsToExit(offsets: Seq[Int]): Int = countStepsToExitCommon(offsets, offset => if (offset >= 3) {
      -1
    } else {
      1
    })

  }

}
