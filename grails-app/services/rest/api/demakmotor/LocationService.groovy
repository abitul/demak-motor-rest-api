package rest.api.demakmotor

import grails.gorm.transactions.Transactional

@Transactional
class LocationService {

    def result
    def lastUpdate = new Date()

    def saveLocation(params) {

        try{
                def location = new Location()
                print lastUpdate
                location.region = params.region
                location.subdistrics = params.subdistrics
                location.districs = params.districs
                location.provinces = params.provinces
                location.postCode = params.postCode
                location.lastUpdate = lastUpdate
                location.save(flush: true, failOnError: true)
                result = [message:"success insert"]
        }catch(e){
                print "error saving location"
                print e
                result = [message:"failed insert"]
        }

        return result

    }

    def updateLocation(params) {

        try{
                def location = Location.get(params.id)
                print location
                location.region = params.region
                location.subdistrics = params.subdistrics
                location.districs = params.districs
                location.provinces = params.provinces
                location.postCode = params.postCode
                location.lastUpdate = lastUpdate
                location.lastUpdate = lastUpdate
                location.save(flush: true, failOnError: true)
                result = [message:"success update"]
        }catch(e){
                print "error saving location"
                print e
                result = [message:"failed update location"]
        }

        return result

    }

    def listLocation(params) {

        try{
                print params
                Integer offset = (params.int('page')-1) * params.int('max')
                result = params.searchValue == "" ? Location.listOrderByLastUpdate(order:"desc",max: params.int('max'), sort: "provinces", offset: offset) : Location.findByRegionIlike("%"+params.searchValue+"%", [max: params.int('max'), sort: "provinces", order: "desc", offset: offset])
        }catch(e){
                print e
                result = [message:"failed get all location"]
        }

        return result

    }

    def deleteLocation(params) {

        try{
                def location = Location.get(params.id)
                location.delete()
                result = [message:"success delete"]
        }catch(e){
                result = [message:"failed delete"]
        }

        return result
        
    }
}
