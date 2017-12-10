package rest.api.demakmotor

import grails.gorm.transactions.Transactional

@Transactional
class SubDistricsService {

    def result
    def lastUpdate = new Date()

    def saveSubDistrics(params) {

        try{
                def subDistrics = new SubDistrics()
                print lastUpdate
                subDistrics.subDistricsName = params.subDistricsName
                subDistrics.lastUpdate = lastUpdate
                subDistrics.save(flush: true, failOnError: true)
                result = [message:"success insert"]
        }catch(e){
                print "error saving subDistrics"
                print e
                result = [message:"failed insert"]
        }

        return result

    }

    def updateSubDistrics(params) {

        try{
                def subDistrics = SubDistrics.get(params.id)
                print subDistrics
                subDistrics.subDistricsName = params.subDistricsName
                subDistrics.lastUpdate = lastUpdate
                subDistrics.save(flush: true, failOnError: true)
                result = [message:"success update"]
        }catch(e){
                print "error saving subDistrics"
                print e
                result = [message:"failed update subDistrics"]
        }

        return result

    }

    def listSubDistrics(params) {

        try{
                print params
                Integer offset = (params.int('page')-1) * params.int('max')
                result = params.searchValue == "" ? Product.listOrderByLastUpdate(order:"desc") : Product.findAllBySubDistricsNameIlike("%"+params.searchValue+"%", [max: params.int('max'), sort: "subDistricsName", order: "desc", offset: offset])
        }catch(e){
                result = [message:"failed get all subDistrics"]
        }

        return result

    }

    def deleteSubDistrics(params) {

        try{
                def subDistrics = SubDistrics.get(params.id)
                subDistrics.delete()
                result = [message:"success delete"]
        }catch(e){
                result = [message:"failed delete"]
        }

        return result
        
    }
}
