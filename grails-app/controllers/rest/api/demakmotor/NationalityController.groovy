package rest.api.demakmotor


import grails.rest.*
import grails.converters.*

class NationalityController {
		
    static responseFormats = ['json']
	
    NationalityService nationalityService
    def responseOfRequest
    def requestParams
    
    def save(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = nationalityService.saveNationality(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def update(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = nationalityService.updateNationality(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def show(params){
        print params
        requestParams = params
        responseOfRequest = nationalityService.listNationality(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def delete(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = nationalityService.deleteNationality(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }
}
