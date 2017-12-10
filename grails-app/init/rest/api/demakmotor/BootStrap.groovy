package rest.api.demakmotor

class BootStrap {

    def init = { servletContext ->
    Role roleUser = new Role(authority: 'ROLE_USER').save(flush: true)

    User user = new User(
         username: 'vangke',
         password: 'passwordAlay',
         enabled: true,
         accountExpired: false,
         accountLocked: false,
         passwordExpired: false
    ).save(flush: true)

    UserRole.create(user, roleUser, true)

    new Client(
        clientId: 'gatot',
        //clientSecret : 'cuk',
        authorizedGrantTypes: ['authorization_code', 'refresh_token', 'implicit', 'password', 'client_credentials'],
        authorities: ['ROLE_CLIENT'],
        scopes: ['read', 'write'],
        redirectUris: ['http://localhost:8080/demak-motor-rest-api']
    ).save(flush: true)
    }
}
