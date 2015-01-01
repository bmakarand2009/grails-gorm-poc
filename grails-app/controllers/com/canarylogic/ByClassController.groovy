package com.canarylogic
import grails.converters.JSON


class ByClassController extends BaseController{

	/* def index() {
		//println "index call"
		render("hello")
	}*/
    def byClassService
    def show = {
           try{
            log.debug "RestController-> show called with params $params"
            def res = byClassService.viewOrListRecords(params)
            render res as JSON
        }catch(Exception ex){
            displayError(ex.getMessage())
        }
        //catch(RestException ex){
          //  println "EXCEPTION CAUGHT CAUGHT CAUGHT"
            //displayError(ex.getMessage(),ex.status)
        //}
    }

    private def jsonPeople() {
        def myHomeAddress = [
                street: "Old Milton Pkwy",
                city:"Atlanta",
                country:"USA",
                pref: true]

        def myWorkAddress = [
                building:"1",
                street: "Science Park",
                city:"Alpharetta",
                country:"USA"]

        def dave = [
                name: "Rick Johnson",
                address: [myHomeAddress, myWorkAddress]]

        def people = [people:[dave]]
        return people

//        render people as JSON
    }

    def update = {
    	println "updated called"
    }

    def save = {
    	println "post called"
    }
     def delete = {
    	println "post called"
    }
}
