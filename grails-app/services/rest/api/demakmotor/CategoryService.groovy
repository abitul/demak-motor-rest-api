package rest.api.demakmotor

import grails.gorm.transactions.Transactional

@Transactional
class CategoryService {

    def result
    def lastUpdate = new Date()

    def saveCategory(params) {

        try{
                def category = new Category()
                print lastUpdate
                category.categoryName = params.categoryName
                category.lastUpdate = lastUpdate
                category.save(flush: true, failOnError: true)
                result = [message:"success insert"]
        }catch(e){
                print "error saving category"
                print e
                result = [message:"failed insert"]
        }

        return result

    }

    def updateCategory(params) {

        try{
                def category = Category.get(params.id)
                print category
                category.categoryName = params.categoryName
                category.lastUpdate = lastUpdate
                category.save(flush: true, failOnError: true)
                result = [message:"success update"]
        }catch(e){
                print "error saving category"
                print e
                result = [message:"failed update category"]
        }

        return result

    }

    def listCategory(params) {

        try{
                print params
                Integer offset = (params.int('page')-1) * params.int('max')
                result = params.searchValue == "" ? Category.listOrderByLastUpdate(order:"desc") : Category.findAllByCategoryNameIlike("%"+params.searchValue+"%", [max: params.int('max'), sort: "categoryName", order: "desc", offset: offset])
        }catch(e){
                result = [message:"failed get all category"]
        }

        return result

    }

    def deleteCategory(params) {

        try{
                def category = Category.get(params.id)
                category.delete()
                result = [message:"success delete"]
        }catch(e){
                result = [message:"failed delete"]
        }

        return result
        
    }
}
