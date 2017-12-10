package rest.api.demakmotor

class PostCode {

    // static hasOne = [product:Product, newOrder:NewOrder, shop:Shop]
    // SubDistrics subDistrics 
    
    String postCode
    Date lastUpdate
    
    static constraints = {
        id generator: 'sequence'
        postCode length:10, blank:false, nullable:false
        // product unique:true, nullable: true
        // newOrder unique:true, nullable: true
        // shop unique:true, nullable: true
    }

    static mappings = {
        autowire true
    }
}
