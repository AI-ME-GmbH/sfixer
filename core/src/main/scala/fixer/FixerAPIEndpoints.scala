package fixer

import models._
import org.joda.time.DateTime

object FixerAPIEndpoints {

  /**
   * The fixer default endpoint.
   *
   */
  val BASE_ENDPOINT = "https://api.fixer.io/"

  /**
   * The default date endpoint, as on http://fixer.io/
   *
   */
  val DEFAULT_DATE = "latest"

  /**
   * The default Date format, as stated on http://fixer.io/
   *
   */
  val DEFAULT_DATEFORMAT = "YYYY-MM-dd"

  /**
   * Default request endpoint
   *
   * @return
   */
  def default = s"""${BASE_ENDPOINT}latest"""

  /**
   * A Naiive implementation of returning the data
   *
   * @param date An optional date Parameter
   * @param currencyOps Implicitly resolved currencyOps. Given currency is an ADT this will never fail
   * @tparam T the currency type to return the base link to
   * @return
   */
  def getLink[T <: Currency](date: Option[DateTime] = None)(implicit currencyOps: CurrencyOps[T]): String = {
    s"""$BASE_ENDPOINT${date.map(_.toString(DEFAULT_DATEFORMAT)).getOrElse(DEFAULT_DATE)}?base=${currencyOps.identifier}"""
  }
}

