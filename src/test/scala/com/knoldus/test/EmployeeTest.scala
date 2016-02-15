package com.knoldus.test

import org.scalatest.FunSuite
import scala.util.Sorting

class EmployeeTest extends FunSuite{


  test("Employee: List of Employees is given in Random Order ")
  {
    val li=Array(Employee(1,"Pallavi",12000),Employee(3,"Seema",10000),Employee(7,"Akshay",5000),Employee(2,"Deepti",11000))
    Sorting.quickSort(li)(SalaryOrdering)
    val res=Array(Employee(7,"Akshay",5000),Employee(3,"Seema",10000),Employee(2,"Deepti",11000),Employee(1,"Pallavi",12000))
    for(i<-0 until res.length)
      {
        assert(res(i)==li(i))
      }
  }

  test("Employee: List of Employee is given with Equal Salaries ")
  {
    val li=Array(Employee(1,"Pallavi",12000),Employee(2,"Himani",12000))
    Sorting.quickSort(li)(SalaryOrdering)
    val res=Array(Employee(1,"Pallavi",12000),Employee(2,"Himani",12000))
    for(i<-0 until res.length)
    {
      assert(res(i)==li(i))
    }
  }




}
