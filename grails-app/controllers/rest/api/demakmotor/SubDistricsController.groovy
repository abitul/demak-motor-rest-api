package rest.api.demakmotor


import grails.rest.*
import grails.converters.*

class SubDistricsController {
    
	static responseFormats = ['json']
	
    SubDistricsService subDistricsService
    def responseOfRequest
    def requestParams
    
    def save(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = subDistricsService.saveSubDistrics(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def update(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = subDistricsService.updateSubDistrics(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def show(params){
        print params
        requestParams = params
        responseOfRequest = subDistricsService.listSubDistrics(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def delete(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = subDistricsService.deleteSubDistrics(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }
}
