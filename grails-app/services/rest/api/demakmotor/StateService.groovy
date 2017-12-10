package rest.api.demakmotor

import grails.gorm.transactions.Transactional

@Transactional
class StateService {

    def result
    def lastUpdate = new Date()

    def saveState(params) {

        try{
                def state = new State()
                print lastUpdate
                state.stateName = params.stateName
                state.lastUpdate = lastUpdate
                state.save(flush: true, failOnError: true)
                result = [message:"success insert"]
        }catch(e){
                print "error saving state"
                print e
                result = [message:"failed insert"]
        }

        return result

    }

    def updateState(params) {

        try{
                def state = State.get(params.id)
                print state
                state.stateName = params.stateName
                state.lastUpdate = lastUpdate
                state.save(flush: true, failOnError: true)
                result = [message:"success update"]
        }catch(e){
                print "error saving state"
                print e
                result = [message:"failed update state"]
        }

        return result

    }

    def listState(params) {

        try{
                print params
                Integer offset = (params.int('page')-1) * params.int('max')
                result = params.searchValue == "" ? Product.listOrderByLastUpdate(order:"desc") : Product.findAllByStateNameIlike("%"+params.searchValue+"%", [max: params.int('max'), sort: "stateName", order: "desc", offset: offset])
        }catch(e){
                result = [message:"failed get all state"]
        }

        return result

    }

    def deleteState(params) {

        try{
                def state = State.get(params.id)
                state.delete()
                result = [message:"success delete"]
        }catch(e){
                result = [message:"failed delete"]
        }

        return result
        
    }
}
