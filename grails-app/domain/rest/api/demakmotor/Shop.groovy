package rest.api.demakmotor

class Shop {

    String shopName
    String email
    String phoneNumber
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
           shopName length:60, blank: false, nullable: false
           email length:60, email:true, blank: false, nullable: false
           phoneNumber length:15, blank: false, nullable: false
    }

    static mappings = {
        autowire true
    }
}
