package MovieDB

import MovieDB.MovieDBClient
import MovieDB.Session
import spock.lang.Specification
import spock.lang.Unroll

class RateAsGuest extends Specification{

    Session session = new Session()
    def restClient = new MovieDBClient()
@Unroll
    def "Rate Movie as Guest"(String movieId,String rating,String apikey, Integer statusCode)
    {
        given:
        def guestSession = session.createGuestSession()
        def param = [:]
        def header =[:]
        def body = [:]
        when:
        body.value = rating
        param.api_key = apikey
        param.guest_session_id = guestSession.getProperties().data.guest_session_id
        def movielist = restClient.postMovieDB("/3/movie/"+movieId+"/rating",body,header,param)
        then:
        movielist.getProperties().status == statusCode
        where:"min, max and middle value"
        movieId | rating | apikey | statusCode

        100 | 8.5 | null | 201
        101 | 0.5 | null | 201
        102 | 10.0 | null | 201
    }
    @Unroll
    def "Rate Movie as Guest bad values"(String movieId,String rating,String apikey, Integer statusCode)
    {
        given:
        def guestSession = session.createGuestSession()
        def param = [:]
        def header =[:]
        def body = [:]
        when:
        body.value = rating
        param.api_key = apikey
        param.guest_session_id = guestSession.getProperties().data.guest_session_id
        def movielist = restClient.postMovieDB("/3/movie/"+movieId+"/rating",body,header,param)
        then:
        movielist.getProperties().statusCode == statusCode
        where:"min, max and middle value"
        movieId | rating | apikey | statusCode

        100 | 5.01 | null | 400
        101 | 0.0 | null | 400
        102 | 99.0 | null | 400
    }
    @Unroll
    def "Rate TV as Guest"(String tv_id,String rating,String apikey, Integer statusCode) {
        given:
        def guestSession = session.createGuestSession()
        def param = [:]
        def header = [:]
        def body = [:]
        when:
        body.value = rating
        param.api_key = apikey
        param.guest_session_id = guestSession.getProperties().data.guest_session_id
        def tvlist = restClient.postMovieDB("/3/tv/" + tv_id + "/rating", body, header, param)
        then:
        tvlist.getProperties().status == statusCode
        where: "min, max and middle value"
        tv_id | rating | apikey | statusCode

        100     | 8.5    | null   | 201
        101     | 0.5    | null   | 201
        102     | 10.0   | null   | 201
    }

}
