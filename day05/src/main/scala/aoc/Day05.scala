package aoc

import collection.mutable.{Seq => MSeq}
import scala.io.Source

object Day05 {
  def main(args: Array[String]): Unit = {
    val offsets = Source.stdin.getLines().toSeq.map(_.toInt)
    
    println(Part1.countStepsToExit(offsets))
  }

  object Part1 {
    def countStepsToExit(offsets: Seq[Int]): Int = {
      var os = MSeq[Int]()
      os ++= offsets
      var steps = 0
      var index = 0


      while (index >= 0 && index < os.length) {

        steps += 1
        val oldIndex = index
        index += os(index)
        os(oldIndex) += 1
      }

      steps
    }
  }

}
