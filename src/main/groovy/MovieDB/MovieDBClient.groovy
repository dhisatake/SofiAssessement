package MovieDB

import groovyx.net.http.ContentType
import groovyx.net.http.HttpResponseException
import groovyx.net.http.RESTClient

class MovieDBClient {
    String url
    String apiKey
    RESTClient rest

    // Constructor initializes the RESTCLient object with the server URL
    // Stores the api key to a variable since every call requires use of your api key
    MovieDBClient() {
        url = System.getProperty("server.base.url")
        apiKey = System.getProperty("api.dev.key")
        rest = new RESTClient(url)
    }

    // getMovieDB takes a String URI path and a map of Query Parameters
    // Returns an HTTP Reponse object which can be accessed as a map
    // Potential additions include adding a parameter for the header for different content types or additional types of header paramenters i.e. security tokens

    def getMovieDB(String URI, Map headers, Map QueryParam)
    {
        if (QueryParam.api_key == null)
        {
            QueryParam.api_key = apiKey
        }
        headers.Accept = ContentType.JSON
        try
        {
            def response = rest.get( path: URI, headers:headers, query:QueryParam)
            return response
        }
        catch (HttpResponseException e)
        {
            System.out.println(e.message)
            return e
        }
    }

    def postMovieDB(String URI, Map body, Map headers, Map QueryParam)
    {
        if (QueryParam.api_key == null)
        {
            QueryParam.api_key = apiKey
        }
        headers.Accept = ContentType.JSON
        try
        {
            def response = rest.post( path: URI, body:body, requestContentType:ContentType.JSON, query:QueryParam)
            return response
        }
        catch (HttpResponseException e)
        {
            System.out.println(e.message)
            return e
        }
    }
    def deleteMovieDB(String URI, Map headers, Map QueryParam)
    {
        QueryParam.api_key = apiKey
        headers.Accept = ContentType.JSON
        try
        {
            def response = rest.delete( path: URI, headers:headers, query:QueryParam)
            return response
        }
        catch (HttpResponseException e)
        {
            System.out.println(e.message)
            return e
        }
    }
    def putMovieDB(String URI, Map body, Map headers, Map QueryParam)
    {
        QueryParam.api_key = apiKey
        headers.Accept = ContentType.JSON
        try
        {
            def response = rest.put( path: URI, headers:headers,body:body, requestContentType:ContentType.JSON, query:QueryParam)
            return response
        }
        catch (HttpResponseException e)
        {
            System.out.println(e.message)
            return e
        }
    }
}