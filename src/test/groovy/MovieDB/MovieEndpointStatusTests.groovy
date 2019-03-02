package MovieDB

import MovieDB.MovieDBClient
import spock.lang.Specification
import spock.lang.Unroll

class MovieEndpointStatusTests extends Specification {
    def restClient = new MovieDBClient()

@Unroll

    //This test allows the user to test a valid response for multiple different movie endpints
    def "endpointValid"(String movieId, String endpoint, String apikey, Integer statusCode)
    {
        given:
        def param = [:]
        def header =[:]
        when:
        param.api_key = apikey
        def movielist = restClient.getMovieDB("/3/movie/"+movieId+"/"+endpoint,header,param)
        then:
        movielist.getProperties().status == statusCode
        where:
        // This is easily changed to be read from a csv if needed for larger data sets
        movieId | endpoint | apikey | statusCode
        100 | "alternative_titles" | null | 200
        100 | "changes" | null | 200
    }

    @Unroll
    // This test allows the user to test a non valid movie id against multiple movie endpoints
    def "endpointNonValidEntry"(String movieId, String endpoint, String apikey, Integer statusCode)
    {
        given:
        def param = [:]
        def header =[:]
        when:
        param.api_key = apikey
        def movielist = restClient.getMovieDB("/3/movie/"+movieId+"/"+endpoint,header,param)
        then:
        movielist.getProperties().statusCode == statusCode
        where:
        //This acually returns what I would consider to be a defect .. "changes" endpoint returns an empty array for a movie id that doesn't exist.
        movieId | endpoint | apikey | statusCode
        1 | "alternative_titles" | null  | 404
        1 | "changes" | null  | 404
    }
    @Unroll
    // This test allows the user to test an unauthorized/invalid api key against multiple movie endpoints
    def "endpointUnauthorized"(String movieId, String endpoint, String apikey, Integer statusCode)
    {
        given:
        def param = [:]
        def header =[:]
        when:
        param.api_key = apikey
        def movielist = restClient.getMovieDB("/3/movie/"+movieId+"/"+endpoint,header,param)
        then:
        movielist.getProperties().statusCode == statusCode
        where:
        movieId | endpoint | apikey | statusCode
        100 | "alternative_titles" | "abc" | 401
        100 | "changes" | "abc" | 401
    }

}
