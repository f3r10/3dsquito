package code.facade

import code.model.UserSignUpVo
import code.model.OmegaDAO
import com.mongodb.casbah.Imports._

object ApiUserFacade {

	def signUp(userSignUpVo: UserSignUpVo): Boolean = {
		val userVoByEmail = OmegaDAO.findOne(MongoDBObject("email" -> userSignUpVo.email))

		userVoByEmail match {
			case Some(userVo) => false
			case _ => 
				val _id = OmegaDAO.insert(userSignUpVo)
				true
		}
	}

	def login (email: String, password: String):Boolean = {
		val userVoByEmail = OmegaDAO.findOne(MongoDBObject("email" -> email))
		userVoByEmail match {
			case Some(userVo) =>
				if(userVo.password == password) true else false 
			case _ => false
		}

	}

}