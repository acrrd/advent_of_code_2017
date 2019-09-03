package aoc

import collection.mutable.{Seq => MSeq, Set => MSet}
import scala.io.Source
import util.control.Breaks._

object Day06  {
  def main(args: Array[String]): Unit = {
    val banks: Seq[Int] = Source.stdin.mkString.trim.split("\\s+").map(_.toInt)

    println(Part1.redistributionsBeforeLoop(banks))
  }

  def getMaxIdx = (bs: Seq[Int]) => bs.zipWithIndex.maxBy{ case (n,i) => (n, -i) }._2
  def wrappingIdxStream: (Int, Int) => Stream[Int] = (n: Int,i: Int) => {
    val w = i % n
    w #:: wrappingIdxStream(n, w + 1)
  }

  object Part1 {
    def redistributionsBeforeLoop(banks: Seq[Int]) : Int = {
      val nbs = banks.length
      var bs = banks

      var steps = 0
      val visited = MSet[Seq[Int]]()

      while(!visited.contains(bs)) {
        steps += 1

        visited.add(bs)

        val idx = getMaxIdx(bs)
        val v = bs(idx)
        val (q, r) = ( v / nbs, v % nbs)

        bs = bs.updated(idx, 0)

        bs = bs.map(n => n + q)
        bs = wrappingIdxStream(nbs, idx+1).take(r).foldLeft(bs)((bs,i) => bs.updated(i, bs(i) + 1))
      }

      steps
    }
  }
}

