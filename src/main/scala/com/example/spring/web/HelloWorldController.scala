package com.example.spring.web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

/**
 * Created with IntelliJ IDEA.
 * User: bewilcox
 * Date: 17/04/13
 * Time: 15:27
 * To change this template use File | Settings | File Templates.
 */
@Controller
class HelloWorldController {

  @RequestMapping(Array("/hello.html"))
  def showHello = "helloPage"

}
