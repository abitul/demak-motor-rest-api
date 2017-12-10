package rest.api.demakmotor

import grails.gorm.transactions.Transactional

@Transactional
class NewOrderService {

    def result
    def lastUpdate = new Date()

    def saveNewOrder(params) {

        try{
                def newOrder = new NewOrder()
                newOrder.productName = params.productName
                newOrder.identityImage = params.identityImage
                newOrder.email = params.email
                newOrder.phoneNumber = params.phoneNumber
                newOrder.address = params.address
                newOrder.lastUpdate = lastUpdate
                newOrder.save(flush: true, failOnError: true)
                result = [message:"success insert"]
        }catch(e){
                print "error saving newOrder"
                print e
                result = [message:"failed insert"]
        }

        return result

    }

    def updateNewOrder(params) {

        try{
                def newOrder = NewOrder.get(params.id)
                newOrder.productName = params.productName
                newOrder.identityImage = params.identityImage
                newOrder.email = params.email
                newOrder.phoneNumber = params.phoneNumber
                newOrder.address = params.address
                newOrder.lastUpdate = lastUpdate
                newOrder.save(flush: true, failOnError: true)
                result = [message:"success update"]
        }catch(e){
                print "error saving newOrder"
                print e
                result = [message:"failed update user"]
        }

        return result

    }

    def listNewOrder(params) {

        try{
                print params
                Integer offset = (params.int('page')-1) * params.int('max')
                result = params.searchValue == "" ? NewOrder.listOrderByLastUpdate(order:"desc") : NewOrder.findAllByProductNameIlike("%"+params.searchValue+"%", [max: params.int('max'), sort: "productName", order: "desc", offset: offset])
        }catch(e){
                result = [message:"failed get all user"]
        }

        return result

    }

    def deleteNewOrder(params) {

        try{
                def newOrder = NewOrder.get(params.id)
                newOrder.delete()
                result = [message:"success delete"]
        }catch(e){
                result = [message:"failed delete"]
        }

        return result
        
    }
}
