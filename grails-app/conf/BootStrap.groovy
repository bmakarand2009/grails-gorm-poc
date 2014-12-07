import com.abc.Author
import com.abc.Book

class BootStrap {

    def init = { servletContext ->

	new Author(name:"Stephen King")
        .addToBooks(new Book(title:"The Stand"))
        .addToBooks(new Book(title:"The Shining"))
        .save()

    }
    def destroy = {
    }
}
