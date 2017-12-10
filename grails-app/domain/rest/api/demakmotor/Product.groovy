package rest.api.demakmotor

class Product {
    static hasMany = [productImage:ProductImage]
    
    String productName
    String description
    Double price
    String status
    Category category
    ProductType productType
    Location location
    // Nationality nationality
    // State state
    // Region region
    // Districs districs
    // SubDistrics subDistrics
    // PostCode postCode
    Date lastUpdate
    
    static constraints = {
        id generator: 'sequence'
        productName length:100, blank: false, nullable: false
        description blank: false, nullable: false
        price length:30, blank: false, nullable: false
    }

    static mappings = {
        autowire true
    }
}
