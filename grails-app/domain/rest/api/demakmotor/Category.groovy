package rest.api.demakmotor

class Category {

    static hasOne = [product:Product, newOrder: NewOrder]
    static hasMany = [productType:ProductType]

    String categoryName
    Date lastUpdate
    
    static constraints = {
        id generator: 'sequence'
        categoryName length:100, blank: false, nullable: false
        product unique:true, nullable: true
        newOrder unique:true, nullable: true
    }

    static mappings = {
        autowire true
    }
}
