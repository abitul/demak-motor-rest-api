package rest.api.demakmotor

import grails.gorm.transactions.Transactional

@Transactional
class UsersService {

    def result
    def lastUpdate = new Date()

    def saveUser(params) {

        try{
                def users = new Users()
                print lastUpdate
                users.username = params.username
                users.password = params.password
                users.passwordHash = params.passwordHash
                users.fullName = params.full_name
                users.address = params.address
                users.email = params.email
                users.phoneNumber = params.phone_number
                users.lastUpdate = lastUpdate
                users.save(flush: true, failOnError: true)
                result = [message:"success insert"]
        }catch(e){
                print "error saving users"
                print e
                result = [message:"failed insert"]
        }

        return result

    }

    def updateUser(params) {

        try{
                def users = User.get(params.id)
                print users
                users.username = params.username
                users.password = params.password
                users.passwordHash = params.passwordHash
                users.full_name = params.full_name
                users.address = params.address
                users.email = params.email
                users.phone_number = params.phone_number
                users.lastUpdate = lastUpdate
                users.save(flush: true, failOnError: true)
                result = [message:"success update"]
        }catch(e){
                print "error saving users"
                print e
                result = [message:"failed update users"]
        }

        return result

    }

    def listUser(params) {

        try{
                print params
                Integer offset = (params.int('page')-1) * params.int('max')
                result = params.searchValue == "" ? Users.listOrderByLastUpdate(order:"desc") : Users.findByFullNameIlike("%"+params.searchValue+"%", [max: params.int('max'), sort: "fullName", order: "desc", offset: offset])
        }catch(e){
                print e
                result = [message:"failed get all users"]
        }

        return result

    }

    def deleteUser(params) {

        try{
                def users = User.get(params.id)
                users.delete()
                result = [message:"success delete"]
        }catch(e){
                result = [message:"failed delete"]
        }

        return result
        
    }
}
