package aoc

import scala.io.Source

object Day02 {
  def main(args: Array[String]): Unit = {
    val spreadsheet = Source.stdin.mkString

    def checksumWith: (Seq[Int] => Int) => Int = checksum_common(spreadsheet)

    println(checksumWith(Part1.checksum_row))
    println(checksumWith(Part2.checksum_row))
  }

  def parseSpreadsheet(spreadsheet: String): Iterator[Seq[Int]] = {
    augmentString(spreadsheet).lines.map(_.trim.split("\\s+").map(_.toInt))
  }

  def checksum_common(spreadsheet: String)(getN: Seq[Int] => Int) : Int = {
    parseSpreadsheet(spreadsheet).map(getN).sum
  }

  object Part1 {
    def checksum_row(row: Seq[Int]): Int = {
      row.max - row.min
    }

    def checksum(spreadsheet: String): Int = {
      checksum_common(spreadsheet)(Part1.checksum_row)
    }
  }

  object Part2 {
    def checksum_row(row: Seq[Int]): Int = {
      def ns = for (
        (a, i) <- row.zipWithIndex;
        b <- row.drop(i + 1)
      ) yield if(a > b) (a, b) else (b, a)

      val (a, b) = ns.find{ case (a, b) => a % b == 0} .get

      a / b
    }

    def checksum(spreadsheet: String): Int = {
      checksum_common(spreadsheet)(Part2.checksum_row)
    }
  }
}
