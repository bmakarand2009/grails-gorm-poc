package com.canarylogic

import grails.transaction.Transactional
import com.canary.ClassBase
//@Transactional
class ByClassService {

    def serviceMethod() {

    }

    def viewOrListRecords(def params){
    	//println "calling RestJSONService.viewOrListRecords $params"
    	//if(params.id){
    	def domainClz = ClassBase 
		viewRecord(params,domainClz)    	
    }

    def viewRecord(def params, def domainClz){

    	println "PARAMS are "+ params
		println "ViewRecord called for $params.id"

		def aClass = domainClz.findByIdAndTenant(params.id,params.tenant,[fetch: [room: 'eager']])
		aClass.room.name = aClass.room.name
		println "ROOM NAME is *******" + aClass.room.name
		return aClass


//		domainClz.get(params.id)

	}

}
