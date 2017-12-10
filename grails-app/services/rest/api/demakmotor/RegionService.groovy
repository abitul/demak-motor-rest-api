package rest.api.demakmotor

import grails.gorm.transactions.Transactional

@Transactional
class RegionService {

    def result
    def lastUpdate = new Date()

    def saveRegion(params) {

        try{
                def region = new Region()
                print lastUpdate
                region.regionName = params.regionName
                region.lastUpdate = lastUpdate
                region.save(flush: true, failOnError: true)
                result = [message:"success insert"]
        }catch(e){
                print "error saving region"
                print e
                result = [message:"failed insert"]
        }

        return result

    }

    def updateRegion(params) {

        try{
                def region = Region.get(params.id)
                print region
                region.regionName = params.regionName
                region.lastUpdate = lastUpdate
                region.save(flush: true, failOnError: true)
                result = [message:"success update"]
        }catch(e){
                print "error saving region"
                print e
                result = [message:"failed update region"]
        }

        return result

    }

    def listRegion(params) {

        try{
                print params
                Integer offset = (params.int('page')-1) * params.int('max')
                result = params.searchValue == "" ? Product.listOrderByLastUpdate(order:"desc") : Product.findAllByRegionNameIlike("%"+params.searchValue+"%", [max: params.int('max'), sort: "regionName", order: "desc", offset: offset])
        }catch(e){
                result = [message:"failed get all region"]
        }

        return result

    }

    def deleteRegion(params) {

        try{
                def region = Region.get(params.id)
                region.delete()
                result = [message:"success delete"]
        }catch(e){
                result = [message:"failed delete"]
        }

        return result
        
    }
}
