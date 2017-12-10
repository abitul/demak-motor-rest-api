package rest.api.demakmotor

import grails.gorm.transactions.Transactional

@Transactional
class ShopService {

    def result
    def lastUpdate = new Date()

    def saveShop(params) {

        try{
                def shop = new Shop()
                shop.shopName = params.shopName
                shop.email = params.email
                shop.phoneNumber = params.phoneNumber
                shop.lastUpdate = lastUpdate
                shop.save(flush: true, failOnError: true)
                result = [message:"success insert"]
        }catch(e){
                print "error saving shop"
                print e
                result = [message:"failed insert"]
        }

        return result

    }

    def updateShop(params) {

        try{
                def shop = Shop.get(params.id)
                shop.shopName = params.shopName
                shop.email = params.email
                shop.phoneNumber = params.phoneNumber
                shop.lastUpdate = lastUpdate
                shop.save(flush: true, failOnError: true)
                result = [message:"success update"]
        }catch(e){
                print "error saving shop"
                print e
                result = [message:"failed update user"]
        }

        return result

    }

    def listShop(params) {

        try{
                print params
                Integer offset = (params.int('page')-1) * params.int('max')
                result = params.searchValue == "" ? Product.listOrderByLastUpdate(order:"desc") : Product.findAllByShopNameIlike("%"+params.searchValue+"%", [max: params.int('max'), sort: "shopName", order: "desc", offset: offset])
        }catch(e){
                result = [message:"failed get all user"]
        }

        return result

    }

    def deleteShop(params) {

        try{
                def shop = Shop.get(params.id)
                shop.delete()
                result = [message:"success delete"]
        }catch(e){
                result = [message:"failed delete"]
        }

        return result
        
    }
}
