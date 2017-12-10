package rest.api.demakmotor


import grails.rest.*
import grails.converters.*

class DistricsController {
	
    static responseFormats = ['json']
	
    DistricsService districsService
    def responseOfRequest
    def requestParams
    
    def save(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = districsService.saveDistrics(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def update(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = districsService.updateDistrics(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def show(params){
        print params
        requestParams = params
        responseOfRequest = districsService.listDistrics(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def delete(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = districsService.deleteDistrics(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }
}
