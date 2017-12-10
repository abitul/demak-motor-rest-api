package rest.api.demakmotor

class SubDistrics {
    
    // static hasOne = [product:Product, newOrder:NewOrder, shop:Shop, postCode:PostCode]
    // Districs districs 

    String subdistricsName
    Date lastUpdate
    
    static constraints = {
           id generator: 'sequence'
           subdistricsName length:100, blank: false, nullable: false
        //    product unique:true, nullable: true
        //    newOrder unique:true, nullable: true
        //    shop unique:true, nullable: true
        //    postCode unique:true, nullable: true
    }

    static mappings = {
        autowire true
    }
}
