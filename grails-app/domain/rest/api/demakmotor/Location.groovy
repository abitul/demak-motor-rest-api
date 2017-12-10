package rest.api.demakmotor

class Location {
    
    static hasOne = [product:Product, newOrder:NewOrder, shop:Shop]

    String region
    String subdistrics
    String districs
    String provinces
    String postCode
    Date lastUpdate

    static constraints = {
        id generator: 'sequence'
        region length:100, blank: false, nullable: false
        subdistrics length:100, blank: false, nullable: false
        districs length:100, blank: false, nullable: false
        provinces length:100, blank: false, nullable: false
        postCode length:10, blank:false, nullable:false
        product unique:true, nullable: true
        newOrder unique:true, nullable: true
        shop unique:true, nullable: true
    }

    static mappings = {
        autowire true
    }
}
