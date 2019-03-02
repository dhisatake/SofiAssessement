package MovieDB

import MovieDB.CSVtoJSON
import MovieDB.MovieDBClient
import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import spock.lang.Specification
import spock.lang.Unroll

class MovieKeywords extends Specification {
    def restClient = new MovieDBClient()

    @Unroll
    //This test allows the user to test that all of the keywords returned from the endpoint match what is expected in a corresponding CSV file
    def "read the csv file"(String movieId, String filepath)
    {
        given:"We read all of the keywords from the Keywords endpoint"
        def jarray = new CSVtoJSON()
        def param = [:]
        def headers =[:]
        def movielist = restClient.getMovieDB("/3/movie/"+movieId+"/keywords",headers,param)
        String json = JsonOutput.toJson(movielist.data)
        String keyword = json.substring(json.indexOf("["))

        when:"we have both the endpoint keywords and CSV file keywords"
        def map1 = new groovy.json.JsonSlurper().parseText(keyword)
        def map2 = new JsonSlurper().parseText( jarray.convert(filepath))

        then: "They match"
        map1.toString()==map2.toString()
        where:
        movieId|filepath
        100|"src/test/resources/100Keywords.csv"
    }
}
