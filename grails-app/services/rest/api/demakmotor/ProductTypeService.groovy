package rest.api.demakmotor

import grails.gorm.transactions.Transactional

@Transactional
class ProductTypeService {

    def result
    def lastUpdate = new Date()

    def saveProductType(params) {

        try{
                def productType = new ProductType()
                productType.productTypeName = params.productTypeName
                productType.lastUpdate = lastUpdate
                def category = Category.findByCategoryNameIlike("%"+params.categoryName+"%")
                category.addToProductType(productType).save()
                result = [message:"success insert"]
        }catch(e){
                print "error saving productType"
                print e
                result = [message:"failed insert"]
        }

        return result

    }

    def updateProductType(params) {

        try{
                def productType = ProductType.get(params.id)
                print productType
                productType.productTypeName = params.productTypeName
                productType.lastUpdate = lastUpdate
                productType.save(flush: true, failOnError: true)
                result = [message:"success update"]
        }catch(e){
                print "error saving productType"
                print e
                result = [message:"failed update productType"]
        }

        return result

    }

    def listProductType(params) {

        try{
                print params
                Integer offset = (params.int('page')-1) * params.int('max')
                result = params.searchValue == "" ? ProductType.listOrderByLastUpdate(order:"desc") : ProductType.findAllByProductTypeNameIlike("%"+params.searchValue+"%", [max: params.int('max'), sort: "productType", order: "desc", offset: offset])
        }catch(e){
                result = [message:"failed get all productType"]
        }

        return result

    }

    def deleteProductType(params) {

        try{
                def productType = ProductType.get(params.id)
                productType.delete()
                result = [message:"success delete"]
        }catch(e){
                result = [message:"failed delete"]
        }

        return result
        
    }
}
