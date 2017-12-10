package rest.api.demakmotor

import grails.gorm.transactions.Transactional

@Transactional
class ProductImageService {

    def result
    def lastUpdate = new Date()

    def saveProductImage(params) {

        try{
                def productImage = new ProductImage()
                print lastUpdate
                productImage.productImageName = params.productImageName
                productImage.lastUpdate = lastUpdate
                productImage.save(flush: true, failOnError: true)
                result = [message:"success insert"]
        }catch(e){
                print "error saving productImage"
                print e
                result = [message:"failed insert"]
        }

        return result

    }

    def updateProductImage(params) {

        try{
                def productImage = ProductImage.get(params.id)
                print productImage
                productImage.productImageName = params.productImageName
                productImage.lastUpdate = lastUpdate
                productImage.save(flush: true, failOnError: true)
                result = [message:"success update"]
        }catch(e){
                print "error saving productImage"
                print e
                result = [message:"failed update productImage"]
        }

        return result

    }

    def listProductImage(params) {

        try{
                print params
                Integer offset = (params.int('page')-1) * params.int('max')
                result = params.searchValue == "" ? ProductImage.listOrderByLastUpdate(order:"desc") : ProductImage.findAllByImageNameIlike("%"+params.searchValue+"%", [max: params.int('max'), sort: "imageName", order: "desc", offset: offset])
        }catch(e){
                result = [message:"failed get all productImage"]
        }

        return result

    }

    def deleteProductImage(params) {

        try{
                def productImage = ProductImage.get(params.id)
                productImage.delete()
                result = [message:"success delete"]
        }catch(e){
                result = [message:"failed delete"]
        }

        return result
        
    }
}
