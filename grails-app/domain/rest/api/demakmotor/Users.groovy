package rest.api.demakmotor

class Users {

    String username
    String password
    String passwordHash
    String fullName
    String address
    String email
    String phoneNumber
    Date lastUpdate
   
    
    static constraints = {
        id generator: 'sequence'
        email length:60, email:true, blank:false, nullable:false
        password blank:false, nullable:false
        passwordHash blank:false, nullable:false
        address blank:false, nullable:false
        username length:60, blank:false, nullable:false
        fullName length:60, blank:false, nullable:false
        phoneNumber length:15, blank:false, nullable:false
    }
    
    static mappings = {
        autowire true
    }
}
