class UrlMappings {

    static mappings = {
        "/$controller/add/$username" {
            controller = 'user'
            action = 'add'
        }
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }
        "/"(view: "/index")
        "500"(view: '/error')
    }
}
