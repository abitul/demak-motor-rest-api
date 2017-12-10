package rest.api.demakmotor

class Region {

    // static hasOne = [product:Product, newOrder:NewOrder, shop:Shop, districs:Districs]
    // State state
    
    String regionName
    Date lastUpdate
    
    static constraints = {
           id generator: 'sequence'
           regionName length:100, blank: false, nullable: false
        //    product unique:true, nullable: true
        //    newOrder unique:true, nullable: true
        //    shop unique:true, nullable: true
        //    districs unique:true, nullable: true
    }

    static mappings = {
        autowire true
    }
}
