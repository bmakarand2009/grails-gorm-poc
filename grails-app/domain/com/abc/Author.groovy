package com.abc

class Author {

    static constraints = {
    }

     static hasMany = [books:Book]
    String name

}
