package com.canary

class Note {

	static belongsTo = [client: ClientBase]
    static constraints = {
    }

    static mapping = {
	   note type: 'text'
	}
	String note
}
