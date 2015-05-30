package code 
package snippet 

import net.liftweb.common._
import net.liftweb.http._
import net.liftweb.http.js._
import net.liftweb.http.js.JsCmds._
import net.liftweb.http.js.JE._
import net.liftweb.util._
import net.liftweb.util.Helpers._
import net.liftweb.http.TransientRequestVar

import code.model.UserSignUpVo
import com.mongodb.casbah.Imports.ObjectId

import code.facade.ApiUserFacade

class UserLoginSnippet {
  def render = {
  	var email = ""
  	var password = ""

  	def process(): Unit = {
  		ApiUserFacade.login(email, password) match {
        case true => S.redirectTo("/formulario")
        case false => S.redirectTo("/registro")
      }

  	}

  "name=signup_email" #> SHtml.email(email, (s: String) => email = s) &
	"name=signup_password" #> SHtml.password(password, s => password = s) &
	"type=submit" #> SHtml.onSubmitUnit(process)
  }
}

