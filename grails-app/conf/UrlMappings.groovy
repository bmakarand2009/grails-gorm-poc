class UrlMappings {

	static mappings = {
        //"/$controller/$action?/$id?(.$format)?"{
        "/rest/$controller/$id?"(parseRequest:true){
            action = [GET:"show", PUT:"update", DELETE:"delete", POST:"save"]
            constraints{
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
