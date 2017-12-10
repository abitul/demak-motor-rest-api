package rest.api.demakmotor

class ProductImage {

    static belongsTo = [product:Product]

    String imageName
    Date lastUpdate
    
    static constraints = {
        id generator: 'sequence'
        imageName length:100, blank: false, nullable: false
    }

    static mappings = {
        autowire true
    }
}
