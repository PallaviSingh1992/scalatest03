package com.knoldus.test

import scala.collection.mutable.Stack

object ExpressionEvaluate {

  def evalauteString(expr:String):Int={

    val arr=expr.toCharArray()
    val stackInt=Stack[Int]()
    val stackChar=Stack[Character]()

    for(i<-0 until arr.length )
      {
            if(arr(i)>= '0' && arr(i)<='9'){
             val buffer = new StringBuffer()
             while (i < arr.length && arr(i).toInt.isInstanceOf[Int]) {
               buffer.append(arr(i + 1))
             }
             stackInt.push(buffer.toString.toInt)
           }
          else if(arr(i)=='(') {
             stackChar.push(arr(i))
           }
          else if(arr(i)==')') {
          while (stackChar.top!='('){
            stackInt.push(applyOperation(stackChar.pop(),stackInt.pop(),stackInt.pop()))}
            stackChar.pop()
          }
           else if(arr(i)=='+' || arr(i)=='-' ||arr(i)=='/' || arr(i)=='*') {
          while(stackChar.isEmpty==false && precOrder(arr(i),stackChar.top)) {
            stackInt.push(applyOperation(stackChar.pop(), stackInt.pop(), stackInt.pop()))
          }
            stackChar.push(arr(i))
        }
      }
    while(stackChar.isEmpty==false) {
      stackInt.push(applyOperation(stackChar.pop(), stackInt.pop(), stackInt.pop()))
    }
      stackInt.pop()
  }
  def precOrder(op1: Char,op2:Char): Boolean =
  {
    if(op2=='(' || op2==')')
      false
    if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
      false
    else
      true
  }

  def applyOperation(op:Char,num1:Int,num2:Int):Int={
    op match{
      case '+'=>num1+num2
      case '-'=>num1-num2
      case '*'=>num1*num2
      case '/'=>num2 match{
        case num2 if(num2==0)=> throw new ArithmeticException()
        case _=>num1/num2
      }
      case _=> 0
    }
  }

}
