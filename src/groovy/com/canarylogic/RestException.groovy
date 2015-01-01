package com.canarylogic

/**
 * Created with IntelliJ IDEA.
 * User: poojabkar
 * Date: 11/27/13
 * Time: 2:24 AM
 * To change this template use File | Settings | File Templates.
 */
class RestException extends Exception{

    def status
    RestException(String message, def statusCode=503){
        super(message);
        status = statusCode

    }
}
