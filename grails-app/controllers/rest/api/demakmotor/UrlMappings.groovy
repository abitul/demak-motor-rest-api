package rest.api.demakmotor

class UrlMappings {

    static mappings = {
        delete "/$controller(.$format)?"(action:"delete")
        get "/$controller(.$format)?"(action:"index")
        get "/$controller(.$format)?"(action:"show")
        post "/$controller(.$format)?"(action:"save")
        put "/$controller(.$format)?"(action:"update")
        patch "/$controller/$id(.$format)?"(action:"patch")

        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
