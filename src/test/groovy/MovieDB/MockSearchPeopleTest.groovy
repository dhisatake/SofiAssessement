package MovieDB

import spock.lang.Specification

class MockSearchPeopleTest extends Specification{

    def "Search for Person"(String name, String filename){
        given:
        //TODO: Call the movie database endpoint with a URI for the movie id and name to search for
        //TODO: Parse the Data file for expected responses
        when:
        //TODO: Convert endpoint response into JSON Object of entries
        //TODO: Convert both JSON objects to string
        then:
        //TODO: Compare String contents to verify they match
        where:
        name|filename
        "John"|"src/test/resources/JohnNamesSearch"
        "Travolta"|"src/test/resources/TravoltaNameSearch"
        "John Travolta"|"src/test/resources/JohnTravoltaNameSearch"
    }
}
