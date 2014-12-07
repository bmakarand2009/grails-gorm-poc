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

    def product = new InventoryBase(name:"Coconut Water",guId:111, tenant:"gusr", iType:"product",iSubType:"retail",price:5 ).save()


    //Add Client
    def addr = new Address(street:"skidanwyd dr", state:"ga", city:"alpha", zip:34533).save(flush:true)

    def aClient = new ClientBase(guId:111, tenant:"gusr",fName:"John",lName:"rokc", barcode:"kdskdssd",
    		emergencyContact:"jonanthan", emergencyContactPhone:"2324556",isTeacher:false)
    aClient.address = addr
    def aNote1 = new Note(note:"This is a sample note which cannot exists without a client")
    def aNote2 = new Note(note:"This is one more  note which cannot exists without a client")
    aClient.addToNotes(aNote1)
       aClient.addToNotes(aNote2)

    aClient.save(flush:true)

    def aTeacher = new ClientBase(guId:123, tenant:"gusr",fName:"Yogi",lName:"Mhiodir", barcode:"kdskdssd",
    		emergencyContact:"hodkrmo", emergencyContactPhone:"2324556",isTeacher:true)
    aTeacher.save(flush:true)

    //Lets create a Class and Add CLients
    new ClassBase(guId:111, tenant:"gusr",name:"classtrial1", startTime:12345, endTime:34531123, classSize:74,
    	teacher: aTeacher)
    .addToStudents(new ClientBase(guId:1234, tenant:"gusr",fName:"sTUDNETS",lName:"kdier", barcode:"kdskdssd",
    		emergencyContact:"jonanthan", emergencyContactPhone:"2324556",isTeacher:false))
    .save(flush:true)


    }


//    new Product(name:"Coconut Water",guId:"111",tenant:"grailsuser",productType:"prodct")
    def destroy = {
    }
}
