package com.particeep.test

/**
 * This is basic language questions so don't use external library or build in function
 */
object BasicScala {

  /**
   * Encode parameter in url format
   *
   * Example:
   *
   * input  : Map("sort_by" -> "name", "order_by" -> "asc", "user_id" -> "12")
   * output : "?sort_by=name&order_by=asc&user_id=12"
   *
   * input  : Map()
   * output : ""
   */
  def encodeParamsInUrl(params: Map[String, String]): String = {

    var out: String = "?"

    for ((k, v) <- params) {
      out = out + k + "=" + v + "&"
    }
    return out.substring(0, out.length() - 1)
  }

  /**
   * Test if a String is an email
   */
  def isEmail(maybeEmail: String): Boolean =
    if ("""^[a-zA-Z0-9\.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$""".r.findFirstIn(maybeEmail) == None) false else true

  /**
   * Compute i ^ n
   *
   * Example:
   *
   * input : (i = 2, n = 3) we compute 2^3 = 2x2x2
   * output : 8
   *
   * input : (i = 99, n = 38997)
   * output : 1723793299
   */
  // Use of recursivity in function power to decrease the complexity of the program
  def power(i: Int, n: Int): Int = {

    if (n == 0) return 1;
    else if (n % 2 == 0) {
      var m: Int = BasicScala.power(i, n / 2)
      return m * m;
    } else return (BasicScala.power(i, (n - 1)) * i);

  }

  def main(args: Array[String]): Unit = {
    println(BasicScala.encodeParamsInUrl(Map("sort_by" -> "name", "order_by" -> "asc", "user_id" -> "12")))
    println("This Email is " + isEmail("han@a@enis.tn5"))
    println("2^3=" + power(2, 3))
  }

}
