package rest.api.demakmotor

import grails.gorm.transactions.Transactional

@Transactional
class ProductService {

    def result
    def lastUpdate = new Date()

    def saveProduct(params) {

        try{
                def product = new Product()
                print lastUpdate
                product.productName = params.productName
                product.description = params.description
                product.price = params.price
                /*using for add list image product*/

                for(imageProducts in params.imageList){
                      product.addToProduct(new Product(imageName:imageProductList.imageName, lastUpdate: lastUpdate))
                }

                product.lastUpdate = lastUpdate
                product.save(flush: true, failOnError: true)
                result = [message:"success insert"]
        }catch(e){
                print "error saving product"
                print e
                result = [message:"failed insert"]
        }

        return result

    }

    def updateProduct(params) {

        try{
                def product = Product.get(params.id)
                print product
                product.productName = params.productName
                product.description = params.description
                product.price = params.price
                product.lastUpdate = lastUpdate
                product.save(flush: true, failOnError: true)
                result = [message:"success update"]
        }catch(e){
                print "error saving product"
                print e
                result = [message:"failed update user"]
        }

        return result

    }

    def listProduct(params) {

        try{
                print params
                Integer offset = (params.int('page')-1) * params.int('max')
                result = params.searchValue == "" ? Product.listOrderByLastUpdate(order:"desc") : Product.findAllByProductNameIlike("%"+params.searchValue+"%", [max: params.int('max'), sort: "productName", order: "desc", offset: offset])
        }catch(e){
                result = [message:"failed get all user"]
        }

        return result

    }

    def deleteProduct(params) {

        try{
                def product = Product.get(params.id)
                product.delete()
                result = [message:"success delete"]
        }catch(e){
                result = [message:"failed delete"]
        }

        return result
        
    }
}
