package rest.api.demakmotor


import grails.rest.*
import grails.converters.*

class UsersController {
	static responseFormats = ['json']
	
    UsersService usersService
    def responseOfRequest
    def requestParams
    
    def save(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = usersService.saveUser(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def update(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = usersService.updateUser(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def show(params){
        print params
        requestParams = params
        responseOfRequest = usersService.listUser(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }

    def delete(params){
        print request.JSON
        requestParams = request.JSON
        responseOfRequest = usersService.deleteUser(requestParams)
        print responseOfRequest
        respond responseOfRequest
    }
}
