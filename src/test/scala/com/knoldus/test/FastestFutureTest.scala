package com.knoldus.test

import org.scalatest.FunSuite
import scala.concurrent.duration._
import scala.concurrent.Await



class FastestFutureTest extends FunSuite{

  test("Fastest Future: List of legal values given")
  {
    val li=List(6,11,13,10).map(x=>FastestFuture.fact(x))
    val res= Await.result(FastestFuture.findFastestFuture(li),10.second)
    println(res)
  }

}
