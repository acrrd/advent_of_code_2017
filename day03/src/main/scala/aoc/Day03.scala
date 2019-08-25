package aoc

import scala.collection.mutable.Map;

sealed trait Direction
case object Right extends Direction {}
case object Down extends Direction {}
case object Left extends Direction {}
case object Up extends Direction {}

object Day03 {
  def main(args: Array[String]): Unit = {
    val n = scala.io.StdIn.readInt()

    val steps = Part1.stepsForData(n)
    val firstLarger = Part2.firstLarger(n)

    println(steps)
    println(firstLarger)
  }

  def ulamSpiralDirections: Stream [Direction] = {
    /* https://oeis.org/A063826 */
    def ulamSpiralDirectionsN(n: Int): Stream[Direction] =
      Left #::
        Stream.continually(Up).take(2 * n) #:::
        Stream.continually(Right).take(2 * n + 1) #:::
        Stream.continually(Down).take(2 * n + 1) #:::
        Stream.continually(Left).take(2 * n + 1)

    Right #:: Down #:: Left #:: Stream.from(1).flatMap(ulamSpiralDirectionsN)
  }

  def directionToCoordinateOffset(d: Direction): (Int, Int) = d match {
    case Right => (1, 0)
    case Down => (0, -1)
    case Left => (-1, 0)
    case Up => (0, 1)
  }

  def ulamSpiralCoordinates = ulamSpiralDirections.map(directionToCoordinateOffset).scan((0,0)) { case ((a, b), (c, d)) => (a + c, b + d) }

  object Part1 {
    def stepsForData(n: Int): Int = {
      val (x, y) = ulamSpiralCoordinates.take(n).last

      Math.abs(x) + Math.abs(y)
    }
  }

  object Part2 {
    def adjSumSpiral: Stream[Int] = {
      var sums = Map[(Int, Int), Int]()
      sums += (0, 0) -> 1
      val neighborOffset = List((1, 0), (1, -1), (0, -1), (-1, -1), (-1, 0), (-1, 1), (0, 1), (1, 1))

      1 #::
        ulamSpiralCoordinates.tail.map(coord => {
          val sum = neighborOffset.flatMap(offset => sums.get((coord._1 + offset._1, coord._2 + offset._2))).sum
          sums += coord -> sum
          sum
        })
    }

    def firstLarger(n: Int): Int = {
      adjSumSpiral.find(sum => sum > n).get
    }
  }
}
