package rest.api.demakmotor


import grails.rest.*
import grails.converters.*

class RegionController {
    
	static responseFormats = ['json']
	
    RegionService regionService
    def responseOfRequest
    def requestParams
    
    def save(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = regionService.saveRegion(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def update(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = regionService.updateRegion(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def show(params){
        print params
        requestParams = params
        responseOfRequest = regionService.listRegion(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def delete(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = regionService.deleteRegion(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }
}