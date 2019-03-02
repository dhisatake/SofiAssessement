package MovieDB

import spock.lang.Specification

class MockAuthenticationTests extends Specification{

    def "ValidSessionTest"() {
        given: "A valid username and password, a valid V4 session token"

        when:
        //TODO: Create a guest session
        //TODO: Create a request token
        //TODO: Create a MovieDB.Session
        //TODO: Create a MovieDB.Session with a Login
        //TODO: Create a MovieDB.Session from V4 access
        def A
        then:
        //TODO: Using each valid MovieDB.Session ID verify you are allowed to access endpoints requiring a valid session ID
        true == true // Yes this is the dumbest thing ever but Spock requires a statement

    }

    def "ExpiredSession"(){
        given:"An =expired guest session id, expired regular session id and a valid session id"
        //TODO: Create an expired guest session
        //TODO: Create a expired MovieDB.Session
        when:

        //TODO: Delete a MovieDB.Session ID that has not expired
        def something
        then:
        //TODO: Using each expired/deleted MovieDB.Session ID verify you are NOT allowed to access endpoints requiring a valid session ID
        true == true // Yes this is the dumbest thing ever but Spock requires a statement
            }

    def "ExpiredToken"(){
        given:"An expired token"
        //TODO: Create an expired token

        when:
        def something
        //TODO: Create MovieDB.Session with expired token

        then:
        //TODO: MovieDB.Session methods do not give a valid MovieDB.Session ID when using an expired token
        true == true // Yes this is the dumbest thing ever but Spock requires a statement

    }

    def "InvalidAPIKey"(){
        given:"An Invalid API Key"

        when:
        //TODO: Create a guest session
        //TODO: Create a request token
        //TODO: Create a MovieDB.Session
        //TODO: Create a MovieDB.Session with a Login
        //TODO: Create a MovieDB.Session from V4 access
        def something
        then:
        //TODO: Each method returns unauthorized and does not return a valid MovieDB.Session/Token
        true == true // Yes this is the dumbest thing ever but Spock requires a statement

    }
}
