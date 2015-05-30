package code
package model

import com.mongodb.casbah.Imports.ObjectId

import com.mongodb.casbah.Imports._
import com.novus.salat.global._
import com.novus.salat.dao.SalatDAO

case class UserSignUpVo (
	_id: Option[ObjectId] = None,
	email: String, 
	password: String, 
	passwordConfirm: String,
	fullname: String
)

object OmegaDAO extends SalatDAO[UserSignUpVo, ObjectId](
  collection = MongoConnection()("3ds")("userVo")
)