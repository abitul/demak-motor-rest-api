package rest.api.demakmotor


import grails.rest.*
import grails.converters.*

class NewOrderController {
	
    static responseFormats = ['json']
	
    NewOrderService newOrderService
    def responseOfRequest
    def requestParams
    
    def save(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = newOrderService.saveNewOrder(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def update(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = newOrderService.updateNewOrder(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def show(params){
        print params
        requestParams = params
        responseOfRequest = newOrderService.listNewOrder(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def delete(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = newOrderService.deleteNewOrder(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }
}
