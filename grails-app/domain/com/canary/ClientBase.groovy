package com.canary

class ClientBase {

    static constraints = {
    }

    static hasMany =[notes:Note,classes:ClassBase,memberships:Membership,visits:Visit,purchases:Purchase]
    static belongsTo = ClassBase
    String guId
    String tenant
    String fName
    String lName
    String barcode
    Address address

    String emergencyContact
    String emergencyContactPhone

    static mapping = {
      guId column: 'guId'
      fName column:'fName'
      lName column:'lName'
      emergencyContact column: 'emergencyContact'
      emergencyContactPhone column:'emergencyContactPhone'
    }

}
