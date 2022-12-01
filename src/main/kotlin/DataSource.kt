import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class DataSource {
    companion object {
        fun getUrlAsList(url: String): List<String> {
            val client = HttpClient.newBuilder().build()
            val request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("cookie", "_ga=GA1.2.743927786.1667116033; session=53616c7465645f5f763c7ce4cfd3a1fd786675958d773864d00b9e254fce9f6a53e172e4ba61c5ac6c107a3a7b788201271bd177e213340e1fbfac06b29f5f95; _gid=GA1.2.1392859596.1669935820")
                .build()

            val response = client.send(request, HttpResponse.BodyHandlers.ofString())
            return response.body().split("\n")
        }
    }
}
