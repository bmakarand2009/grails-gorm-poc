package com.canary

class Visit {

	static belongsTo = [client: ClientBase]
    static constraints = {
    }

    Integer visitTime
    ClassBase teacher
    Membership membership

    static mapping = {
      visitTime column: 'visitTime'

    }
}
