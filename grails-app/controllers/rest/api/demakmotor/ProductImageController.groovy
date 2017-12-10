package rest.api.demakmotor


import grails.rest.*
import grails.converters.*

class ProductImageImageController {

	static responseFormats = ['json']
	
    ProductImageService productImageService
    def responseOfRequest
    def requestParams
    
    def save(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = productImageService.saveProductImage(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def update(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = productImageService.updateProductImage(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def show(params){
        print params
        requestParams = params
        responseOfRequest = productImageService.listProductImage(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def delete(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = productImageService.deleteProductImage(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }
}
