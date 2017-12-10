package rest.api.demakmotor


import grails.rest.*
import grails.converters.*

class ProductController {
	static responseFormats = ['json']
	
    ProductService productService
    def responseOfRequest
    def requestParams
    
    def save(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = productService.saveProduct(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def update(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = productService.updateProduct(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def show(params){
        print params
        requestParams = params
        responseOfRequest = productService.listProduct(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def delete(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = productService.deleteProduct(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }
}
