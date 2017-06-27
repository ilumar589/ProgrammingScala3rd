package chapter4

import ChecksumAccumulator.calculate

object EntryPoint extends App{
  for (season <- List("spring", "fall", "winter"))
    println(season + ": " + calculate(season))
}
