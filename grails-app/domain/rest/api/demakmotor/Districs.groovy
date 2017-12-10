package rest.api.demakmotor

class Districs {

    // static hasOne = [product:Product, newOrder:NewOrder, shop:Shop, subDistrics:SubDistrics]
    // Region region 

    String districsName
    Date lastUpdate
    
    static constraints = {
        id generator: 'sequence'
        districsName length:100, blank: false, nullable: false
        // product unique:true, nullable: true
        // newOrder unique:true, nullable: true
        // shop unique:true, nullable: true
        // subDistrics unique:true, nullable: true
    }

    static mappings = {
        autowire true
    }
}
