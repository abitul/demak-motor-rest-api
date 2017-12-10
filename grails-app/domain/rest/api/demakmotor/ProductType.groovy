package rest.api.demakmotor

class ProductType {

    static hasOne = [product:Product]
    static belongsTo = [category:Category]

    String productTypeName
    Date lastUpdate
    
    static constraints = {
        id generator: 'sequence'
        productTypeName length:100, blank: false, nullable: false
        product unique:true, nullable: true
    }

    static mappings = {
        autowire true
    }
}
