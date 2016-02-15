package com.knoldus.test


case class Employee(id: Int, name: String,salary:Double)

object SalaryOrdering extends Ordering[Employee] {

  /**
    * The function is responsible for ordering the Employees on basis of their Salaries
    * @param:e1 is the first Employee entity for Comparison
    * @param:e2 is the second Employee entity for Comparison
    * @return: The result of comparisons
    */
  def compare(e1:Employee, e2:Employee) = e1.salary compare e2.salary
}






