package com.example.data

import javax.persistence.{GeneratedValue, Id, Entity}
import scala.beans.BeanProperty

/**
 * Created with IntelliJ IDEA.
 * User: bewilcox
 * Date: 17/04/13
 * Time: 15:55
 * To change this template use File | Settings | File Templates.
 */
@Entity
class Customer {

  @Id
  @GeneratedValue
  var id: Long = _

  @BeanProperty
  var name: String = _
}
