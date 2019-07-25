package aoc

import scala.io.Source

object Day02 {
  def main(args: Array[String]): Unit = {
    val spreadsheet = Source.stdin.mkString
    
    println(Part1.checksum(spreadsheet))
  }


  def parseSpreadsheet(spreadsheet: String): Iterator[Seq[Int]] = {
    augmentString(spreadsheet).lines.map(_.trim.split("\\s+").map(_.toInt))
  }

  object Part1 {
    def checksum(spreadsheet: String): Int = {
      parseSpreadsheet(spreadsheet).map(vs => {
        vs.max - vs.min
      }).sum
    }
  }

}
