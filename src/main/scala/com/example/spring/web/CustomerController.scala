package com.example.spring.web

/**
 * Created with IntelliJ IDEA.
 * User: bewilcox
 * Date: 17/04/13
 * Time: 16:02
 * To change this template use File | Settings | File Templates.
 */

import org.springframework.stereotype.Controller
import org.springframework.beans.factory.annotation.Autowired
import org.hibernate.SessionFactory
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.{RequestMethod, PathVariable, ModelAttribute, RequestMapping}
import org.springframework.web.bind.annotation.RequestMethod._
import org.springframework.web.servlet.ModelAndView
import com.example.data.Customer

@Controller
class CustomerController {
  implicit def sessionFactory2Session(sf: SessionFactory) =
    sf.getCurrentSession();

  @Autowired
  var sessionFactory: SessionFactory = null

  @ModelAttribute("command")
  def createCustomerForFormBinding = new Customer

  @RequestMapping(value = Array("/customers/new"), method = Array(GET))
  def showNewCustomerForm = "newCustomer"

  @Transactional
  @RequestMapping(value = Array("/customers/new"), method = Array(POST))
  def createNewCustomer(@ModelAttribute("command") customer: Customer) =
    "redirect:/customers/" + sessionFactory.save(customer) + ".html"

  @Transactional(readOnly = true)
  @RequestMapping(
    value = Array("/customers/{customerId}"), method = Array(GET))
  def viewCustomer(@PathVariable customerId: Long) =
    new ModelAndView("customer", "customer",
      sessionFactory.get(classOf[Customer], customerId))
}
