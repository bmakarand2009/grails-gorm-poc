package com.canary

class PurchasedItems {

    static constraints = {
    }

	static belongsTo = [client: ClientBase]

    Integer purchaseTime
    InventoryBase itemPurchased
    BigDecimal amount


  	static mapping = {
      purchaseTime column: 'purchaseTime'
      itemPurchased column: 'itemPurchased'

    }
}
