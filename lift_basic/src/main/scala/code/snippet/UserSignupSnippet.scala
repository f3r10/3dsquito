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

class UserSignupSnippet {
  def render = {
  	var fullname = ""
  	var email = ""
  	var password = ""
  	var passwordConfirm = ""

  	def process(): Unit = {
  		val tkUserSignUpVo = UserSignUpVo( Some(new ObjectId) ,email, password,
				passwordConfirm, fullname)
  		val anwser = ApiUserFacade.signUp(tkUserSignUpVo)

  		if(anwser){
  			println("El usuario ha sido insertado")
  			S.redirectTo("/formulario")
  		}else{
  			println("Ya existe el usuario")
  		}

  	}

  "name=signup_email" #> SHtml.email(email, (s: String) => email = s) &
	"name=signup_password" #> SHtml.password(password, s => password = s) &
	"name=signup_password_confirm" #> SHtml.password(passwordConfirm, s => passwordConfirm = s) &
	"name=signup_fullname" #> SHtml.text(fullname.toString, fullname = _) &
	"type=submit" #> SHtml.onSubmitUnit(process)
  }
}

