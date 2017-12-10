package rest.api.demakmotor


import grails.rest.*
import grails.converters.*

class PostCodeController {
	
    static responseFormats = ['json']
	
    PostCodeService postCodeService
    def responseOfRequest
    def requestParams
    
    def save(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = postCodeService.savePostCode(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def update(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = postCodeService.updatePostCode(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def show(params){
        print params
        requestParams = params
        responseOfRequest = postCodeService.listPostCode(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def delete(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = postCodeService.deletePostCode(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }
}
