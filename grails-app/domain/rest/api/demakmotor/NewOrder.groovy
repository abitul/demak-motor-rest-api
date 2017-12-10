package rest.api.demakmotor

class NewOrder {

    String productName
    String identityImage
    String email
    String phoneNumber
    String address
    Category category
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
        identityImage length:100, blank: false, nullable: false
        email length:60, email:true, blank:false, nullable:false
        phoneNumber length:15, blank:false, nullable:false
        address blank: false, nullable: false
    }

    static mappings = {
        autowire true
    }
}
