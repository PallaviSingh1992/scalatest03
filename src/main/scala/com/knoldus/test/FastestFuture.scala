package com.knoldus.test

import scala.concurrent.{Promise, Future}
import scala.concurrent.ExecutionContext.Implicits.global

object FastestFuture {

  def fact(num:Int):Future[Int]= Future{
    def fact(num: Int): Int = {
      num match {
        case 0 => 1
        case _ => num * fact(num - 1)
      }
    }
    fact(num)
  }

  def findFastestFuture(li:List[Future[Int]]):Future[Int]={

   val promise=Promise[Int]

    li.foreach(_.onComplete{case demo=>promise.tryComplete(demo)})
    promise.future
  }

}







