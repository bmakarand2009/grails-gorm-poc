package com.canary

class Membership {

    static constraints = {
    }

    String name
    String credits
    Integer expDate

    static belongsTo=[client:ClientBase]
    static mapping = {
      expDate column: 'expDate'
    }


}
