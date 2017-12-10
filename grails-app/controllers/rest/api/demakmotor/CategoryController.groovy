package rest.api.demakmotor


import grails.rest.*
import grails.converters.*

class CategoryController {
	
    static responseFormats = ['json']
	
    CategoryService categoryService
    def responseOfRequest
    def requestParams
    
    def save(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = categoryService.saveCategory(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def update(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = categoryService.updateCategory(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def show(params){
        print params
        requestParams = params
        responseOfRequest = categoryService.listCategory(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def delete(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = categoryService.deleteCategory(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }
}
