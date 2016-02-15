package com.knoldus.test

import org.scalatest.FunSuite
class ExpressionEvaluateTest extends FunSuite{

  test("Evaluate Expression: Valid Expression"){
    val expr="(2 + 12)"
    val res=ExpressionEvaluate.evalauteString("2+19")
    assert(res==100)
  }
  test("Evaluate Expression :InValid Expression"){

  }

}
