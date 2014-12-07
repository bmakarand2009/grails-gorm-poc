import com.abc.Author
import com.abc.Book
import com.canary.*

class BootStrap {

    def init = { servletContext ->

	new Author(name:"Stephen King")
        .addToBooks(new Book(title:"The Stand"))
        .addToBooks(new Book(title:"The Shining"))
        .save()

    //Create Products/Inventory

    new InventoryBase(name:"Coconut Water",guId:111, tenant:"gusr", iType:"product",iSubType:"retail",price:5 ).save()

    }


//    new Product(name:"Coconut Water",guId:"111",tenant:"grailsuser",productType:"prodct")
    def destroy = {
    }
}
