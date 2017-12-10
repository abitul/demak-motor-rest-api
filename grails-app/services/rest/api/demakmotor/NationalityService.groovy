package rest.api.demakmotor

import grails.gorm.transactions.Transactional

@Transactional
class NationalityService {

    def result
    def lastUpdate = new Date()

    def saveNationality(params) {

        try{
                def nationality = new Nationality()
                print lastUpdate
                nationality.nationalityName = params.nationalityName
                nationality.lastUpdate = lastUpdate
                nationality.save(flush: true, failOnError: true)
                result = [message:"success insert"]
        }catch(e){
                print "error saving nationality"
                print e
                result = [message:"failed insert"]
        }

        return result

    }

    def updateNationality(params) {

        try{
                def nationality = Nationality.get(params.id)
                print nationality
                nationality.nationalityName = params.nationalityName
                nationality.lastUpdate = lastUpdate
                nationality.save(flush: true, failOnError: true)
                result = [message:"success update"]
        }catch(e){
                print "error saving nationality"
                print e
                result = [message:"failed update nationality"]
        }

        return result

    }

    def listNationality(params) {

        try{
                print params
                Integer offset = (params.int('page')-1) * params.int('max')
                result = params.searchValue == "" ? Nationality.listOrderByLastUpdate(order:"desc") : Nationality.findAllByNationalityNameIlike("%"+params.searchValue+"%", [max: params.int('max'), sort: "nationalityName", order: "desc", offset: offset])
        }catch(e){
                result = [message:"failed get all nationality"]
        }

        return result

    }

    def deleteNationality(params) {

        try{
                def nationality = Nationality.get(params.id)
                nationality.delete()
                result = [message:"success delete"]
        }catch(e){
                result = [message:"failed delete"]
        }

        return result
        
    }
}
