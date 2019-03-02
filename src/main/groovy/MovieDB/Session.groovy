package MovieDB

import groovyx.net.http.ContentType
import groovyx.net.http.RESTClient

class Session {

    String url
    String apiKey
    RESTClient rest

    Session()
    {
        url = System.getProperty("server.base.url")
        apiKey = System.getProperty("api.dev.key")
        rest = new RESTClient(url)
    }

    def "createGuestSession"()
    {
        def QueryParams = [:]
        String URI = "/3/authentication/guest_session/new"
        QueryParams.api_key = apiKey
        Map headers = [:]
        headers.Accept = ContentType.JSON
        def response = rest.get(path:URI,headers:headers,query:QueryParams)
        return response
    }

    def "createRequestToken"()
    {
        def QueryParams = [:]
        String URI = "/3/authentication/token/new"
        QueryParams.api_key = apiKey
        Map headers = [:]
        headers.Accept = ContentType.JSON
        def token = rest.get(path:URI,headers:headers,query:QueryParams)
        return token

    }

    def "createSession"(String token)
    {
        def QueryParams = [:]
        String URI = "/3/authentication/session/new"
        QueryParams.api_key = apiKey
        Map headers = [:]
        Map body = [:]
        body.request_token = token
        headers.Accept =ContentType.JSON
        def session = rest.post(path:URI,headers:headers,body:body,query:QueryParams)
        return session
    }

    def "deleteSession"(String session)
    {
        def QueryParams = [:]
        String URI = "/3/authentication/session"
        QueryParams.api_key = apiKey
        Map headers = [:]
        Map body = [:]
        body.session_id = session
        headers.Accept = ContentType.JSON
        def response = rest.delete(path:URI,headers:headers,body:body,requestContentType:ContentType.JSON,query:QueryParams)
        return response
    }

    def"createSessionwithLogin"(String user, String pass, String token)
    {
        def QueryParams = [:]
        String URI = "/3/authentication/token/validate_with_login"
        QueryParams.api_key = apiKey
        Map headers = [:]
        Map body = [:]
        body.request_token = token
        body.username = user
        body.password = pass
        headers.Accept =  ContentType.JSON
        def response = rest.post(path:URI,headers:headers,body:body,query:QueryParams)
        return response
    }

}
