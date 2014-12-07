package com.canary

class Purchase {

    static constraints = {
    }

	static belongsTo = [client: ClientBase]

    Integer purchaseTime
    ProductBase itemPurchased
    BigDecimal amount


  	static mapping = {
      purchaseTime column: 'purchaseTime'
      itemPurchased column: 'itemPurchased'

    }
}
