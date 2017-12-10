package rest.api.demakmotor


import grails.rest.*
import grails.converters.*

class ProductTypeController {
	static responseFormats = ['json']
	
    ProductTypeService productTypeService
    def responseOfRequest
    def requestParams
    
    def save(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = productTypeService.saveProductType(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def update(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = productTypeService.updateProductType(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def show(params){
        print params
        requestParams = params
        responseOfRequest = productTypeService.listProductType(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def delete(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = productTypeService.deleteProductType(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }
}
