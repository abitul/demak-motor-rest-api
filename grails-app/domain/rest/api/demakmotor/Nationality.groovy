package rest.api.demakmotor

class Nationality {

    // static hasOne = [product:Product, newOrder:NewOrder, shop:Shop, state:State]

    String nationalityName
    Date lastUpdate

    static constraints = {
        id generator: 'sequence'
        nationalityName length:100, blank: false, nullable: false
        // product unique:true, nullable: true
        // newOrder unique:true, nullable: true
        // shop unique:true, nullable: true
        // state unique:true, nullable: true
    }

    static mappings = {
        autowire true
    }
}
