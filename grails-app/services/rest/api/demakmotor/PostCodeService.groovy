package rest.api.demakmotor

import grails.gorm.transactions.Transactional

@Transactional
class PostCodeService {

    def result
    def lastUpdate = new Date()

    def savePostCode(params) {

        try{
                def postCode = new PostCode()
                print lastUpdate
                postCode.postCodeName = params.postCodeName
                postCode.lastUpdate = lastUpdate
                postCode.save(flush: true, failOnError: true)
                result = [message:"success insert"]
        }catch(e){
                print "error saving postCode"
                print e
                result = [message:"failed insert"]
        }

        return result

    }

    def updatePostCode(params) {

        try{
                def postCode = PostCode.get(params.id)
                print postCode
                postCode.postCodeName = params.postCodeName
                postCode.lastUpdate = lastUpdate
                postCode.save(flush: true, failOnError: true)
                result = [message:"success update"]
        }catch(e){
                print "error saving postCode"
                print e
                result = [message:"failed update postCode"]
        }

        return result

    }

    def listPostCode(params) {

        try{
                print params
                Integer offset = (params.int('page')-1) * params.int('max')
                result = params.searchValue == "" ? PostCode.listOrderByLastUpdate(order:"desc") : PostCode.findAllByPostCodeIlike("%"+params.searchValue+"%", [max: params.int('max'), sort: "postCode", order: "desc", offset: offset])
        }catch(e){
                result = [message:"failed get all postCode"]
        }

        return result

    }

    def deletePostCode(params) {

        try{
                def postCode = PostCode.get(params.id)
                postCode.delete()
                result = [message:"success delete"]
        }catch(e){
                result = [message:"failed delete"]
        }

        return result
        
    }
}
