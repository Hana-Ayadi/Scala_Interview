package com.particeep.test

object WhatsWrong1 {

  trait Interface {
    val city: String
    val support: String = s"Ici c'est $city !"
  }

  case object Supporter extends Interface {

    override val city = "Paris"
   
  }
   def main(args: Array[String]): Unit = {
  println(Supporter.city )//What does this print ?
  
  /*=> "Paris" 
   */
  
  println(Supporter.support) //What does this print and why ? How to fix it ?
  /*=> "Ici c'est null !"
   * When Supporter change the value of city , it change it locally that's mean that the val city is considered as a local variable
   * in the Supporter object so when we call supporter.city we will find directly the variable city defined in supporter
   * However, when we call supporter.support the response wil be returned from interface 
   * 
   * Solution : override the variable support in the object Supporter : we add  override val support: String = s"Ici c'est $city !"
   */
   }
}
