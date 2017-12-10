package rest.api.demakmotor


import grails.rest.*
import grails.converters.*

class ShopController {

	static responseFormats = ['json']
	
    ShopService shopService
    def responseOfRequest
    def requestParams
    
    def save(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = shopService.saveShop(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def update(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = shopService.updateShop(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def show(params){
        print params
        requestParams = params
        responseOfRequest = shopService.listShop(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def delete(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = shopService.deleteShop(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }
}
