package com.canary

class ProductBase {


    static constraints = {
    }

    String name
    String guId
    String tenant
    
    String productType
    String productSubType
    BigDecimal price


	static mapping = {
      guId column: 'guId'
      productType column:'productType'
      productSubType column:'productSubType'
    }
}
