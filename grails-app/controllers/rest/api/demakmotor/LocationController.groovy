package rest.api.demakmotor


import grails.rest.*
import grails.converters.*

class LocationController {
	static responseFormats = ['json']
	
    LocationService locationService
    def responseOfRequest
    def requestParams
    
    def save(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = locationService.saveLocation(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def update(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = locationService.updateLocation(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def show(params){
        print params
        requestParams = params
        responseOfRequest = locationService.listLocation(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def delete(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = locationService.deleteLocation(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }
}
