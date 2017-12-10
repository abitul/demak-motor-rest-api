package rest.api.demakmotor

class State {

    // static hasOne = [product:Product, newOrder:NewOrder, shop:Shop, region:Region]
    // Nationality nationality

    String stateName
    Date lastUpdate
    
    static constraints = {
           id generator: 'sequence'
           stateName length:100, blank: false, nullable: false
        //    product unique:true, nullable: true
        //    newOrder unique:true, nullable: true
        //    shop unique:true, nullable: true
        //    region unique:true, nullable: true
    }

    static mappings = {
        autowire true
    }
}
