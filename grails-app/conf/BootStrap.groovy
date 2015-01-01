import com.abc.Author
import com.abc.Book
import com.canary.*
import org.apache.commons.lang.RandomStringUtils

class BootStrap {

    def init = { servletContext ->

/*
	new Author(name:"Stephen King")
        .addToBooks(new Book(title:"The Stand"))
        .addToBooks(new Book(title:"The Shining"))
        .save()
*/
    //Create Products/Inventory

    String charset = (('A'..'Z') + ('0'..'0')).join()
    Integer length = 9
    String randomString = RandomStringUtils.random(length, charset.toCharArray())

    /*
    def product = new InventoryBase(name:"Coconut Water",guId:randomString, tenant:"gusr", iType:"product",iSubType:"retail",price:5 ).save(failOnError:true)


    def addr = new AddressBase(street:"sindawy dr", state:"ga", city:"alpha", zip:34533,tenant:"awsuser").save(flush:true,failOnError:true)

    def aClient = new ClientBase(guId:randomString, tenant:"gusr",fName:"John",lName:"rokc", barcode:"kdskdssd",
    		emergencyContact:"jonanthan", emergencyContactPhone:"2324556",isTeacher:false)
    aClient.address = addr
    def aNote1 = new NoteBase(note:"This is a sample note which cannot exists without a client",tenant:"awsuser")
    def aNote2 = new NoteBase(note:"This is one more  note which cannot exists without a client",tenant:"awsuser")
    aClient.addToNotes(aNote1)
       aClient.addToNotes(aNote2)

    aClient.save(flush:true,failOnError:true)

    def aTeacher = new ClientBase(guId:123, tenant:"awsuser",fName:"Yogi",lName:"Mhiodir", barcode:"kdskdssd",
    		emergencyContact:"hodkrmo", emergencyContactPhone:"2324556",isTeacher:true)
    aTeacher.save(flush:true,failOnError:true)

    new ClassBase(guId:111, tenant:"awsuser",name:"classtrial1", startTime:12345, endTime:34531123, classSize:74,
    	teacher: aTeacher)
    .addToStudents(new ClientBase(guId:randomString, tenant:"awsuser",fName:"sTUDNETS",lName:"kdier", barcode:"kdskdssd",
    		emergencyContact:"jonanthan", emergencyContactPhone:"2324556",isTeacher:false))
    .save(flush:true,failOnError:true)
*/

    }


//    new Product(name:"Coconut Water",guId:"111",tenant:"grailsuser",productType:"prodct")
    def destroy = {
    }
}
