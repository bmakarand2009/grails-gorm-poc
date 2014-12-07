package com.abc

class Book {

    static constraints = {
    }

     static belongsTo = Author
    static hasMany = [authors:Author]
    String title
}
