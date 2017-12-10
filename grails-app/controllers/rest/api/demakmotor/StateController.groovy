package rest.api.demakmotor


import grails.rest.*
import grails.converters.*

class StateController {
    
	static responseFormats = ['json']
	
    StateService stateService
    def responseOfRequest
    def requestParams
    
    def save(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = stateService.saveState(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def update(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = stateService.updateState(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def show(params){
        print params
        requestParams = params
        responseOfRequest = stateService.listState(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def delete(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = stateService.deleteState(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }
}
