package aoc

import collection.mutable.{Seq => MSeq, Set => MSet, Map => MMap}
import scala.io.Source
import util.control.Breaks._

object Day06  {
  def main(args: Array[String]): Unit = {
    val banks: Seq[Int] = Source.stdin.mkString.trim.split("\\s+").map(_.toInt)

    println(Part1.redistributionsBeforeLoop(banks))
    println(Part2.loopLength(banks))
  }

  def getMaxIdx = (bs: Seq[Int]) => bs.zipWithIndex.maxBy{ case (n,i) => (n, -i) }._2
  def wrappingIdxStream: (Int, Int) => Stream[Int] = (n: Int,i: Int) => {
    val w = i % n
    w #:: wrappingIdxStream(n, w + 1)
  }

  def redistribute(banks: Seq[Int]) : (Int, Int) = {
    val nbs = banks.length
    var bs = banks

    var steps = 0
    var firstVisited = Map[Seq[Int], Int]()

    while(!firstVisited.contains(bs)) {
      firstVisited = firstVisited + (bs -> steps)
      steps += 1

      val idx = getMaxIdx(bs)
      val v = bs(idx)
      val (q, r) = ( v / nbs, v % nbs)

      bs = bs.updated(idx, 0)

      bs = bs.map(n => n + q)
      bs = wrappingIdxStream(nbs, idx+1).take(r).foldLeft(bs)((bs,i) => bs.updated(i, bs(i) + 1))
    }

    (steps, firstVisited(bs))
  }

  object Part1 {
    def redistributionsBeforeLoop(banks: Seq[Int]) : Int = {
      redistribute(banks)._1
    }
  }

  object Part2 {
    def loopLength(banks: Seq[Int]) : Int = {
      val (steps, firstStep) = redistribute(banks)
      steps - firstStep
    }
  }
}

