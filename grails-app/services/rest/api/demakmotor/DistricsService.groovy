package rest.api.demakmotor

import grails.gorm.transactions.Transactional

@Transactional
class DistricsService {

    def result
    def lastUpdate = new Date()

    def saveDistrics(params) {

        try{
                def districs = new Districs()
                print lastUpdate
                districs.districsName = params.districsName
                districs.lastUpdate = lastUpdate
                districs.save(flush: true, failOnError: true)
                result = [message:"success insert"]
        }catch(e){
                print "error saving districs"
                print e
                result = [message:"failed insert"]
        }

        return result

    }

    def updateDistrics(params) {

        try{
                def districs = Districs.get(params.id)
                print districs
                districs.districsName = params.districsName
                districs.lastUpdate = lastUpdate
                districs.save(flush: true, failOnError: true)
                result = [message:"success update"]
        }catch(e){
                print "error saving districs"
                print e
                result = [message:"failed update districs"]
        }

        return result

    }

    def listDistrics(params) {

        try{
                print params
                Integer offset = (params.int('page')-1) * params.int('max')
                result = params.searchValue == "" ? Category.listOrderByLastUpdate(order:"desc") : Category.findAllByDistricsNameIlike("%"+params.searchValue+"%", [max: params.int('max'), sort: "districsName", order: "desc", offset: offset])
        }catch(e){
                result = [message:"failed get all districs"]
        }

        return result

    }

    def deleteDistrics(params) {

        try{
                def districs = Districs.get(params.id)
                districs.delete()
                result = [message:"success delete"]
        }catch(e){
                result = [message:"failed delete"]
        }

        return result
        
    }
}
