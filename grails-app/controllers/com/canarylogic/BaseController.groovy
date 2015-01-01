package com.canarylogic

import grails.converters.JSON;


class BaseController {

  def beforeInterceptor=[action:this.&sanitize]        

    def index() { }

  protected def displayError(String messageStr, def status=503) {
   log.debug "in display error message"
   response.status = status
   // render([error: messageStr] as JSON)
    render(contentType:"text/json") {
        error(message:messageStr)
       }
  }

   private sanitize() {
    try{
    	println "SANITIZIE Called"
     	def tenantName = request.getHeader("tenant")
     	println "tENANT Name called is" + tenantName
     	if(!tenantName)
     		throw new Exception("tenant not found is mandarotry")
     	params.tenant = tenantName

//        params.username = restService.getUsernameForToken(params.token)
  //      if(!params.username)
    //        throw new Exception("Invalid token, no username found")

      //  log.debug "username found is $params.username"
        //params.user = User.findByUsername(params.username)

        //if(!params.user)
          //    throw new Exception("No username found for $params.username")

        //if(! restService.isPermitted(params)){
          // throw new RestException("You do not have sufficient priviledges to access this domain, contact your admin",403)
        //}
        println "User is authorized to ahead to acchess this domain"
    }catch(RestException ex1){
      displayError(ex1.message, 403)
    }catch(Exception ex){
      displayError(ex.message)
    }
      //return domainClz
  }
}
