package com.thd.springapi.APIPractice.Service;

import com.thd.springapi.APIPractice.Model.Book;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BookService {

    // This is a basic service, we need to use the @Service annotation in order to specify to Spring Boot
    // that it is a Service. Here we need to code all the business logic and return data when its required.
    // In order to call the NYT public API, we need to store a unique API KEY, and to retrieve the data
    // we need to use some special objects.

    private String apiKey="YndTMMQtxjDsWZytNuGEGvVyGy0M9ICl";
    private RestTemplate restTemplate= new RestTemplate();
    private JSONObject jsonObject;
    private JSONArray jsonArray;

    // This method will return the list of Books from the NYT public API
    public List<Book> getTopBooks() throws Exception{
        // In first place, we need a list to store the retrieved books, later we will return this list
        // with all the mapped elements, and we need to specify the route where the books will be retrieved.
        List<Book> topBooks=new ArrayList<>();
        String url="https://api.nytimes.com/svc/books/v3/lists/current/hardcover-fiction.json?api-key="+ apiKey;

        // Here we initialize the classes we will use to retrive the data from the url, and we build
        // a http request specifying the returned format from the request, in this case is JSON.
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity= new HttpEntity(headers);

        // Here we call end execute the request
        ResponseEntity<Map> bookList=restTemplate.exchange(url, HttpMethod.GET,entity, Map.class);

        // If everything was fine with the request, we check the status and map the objects
        if(bookList.getStatusCode()==HttpStatus.OK){
            // First we need to obtain the JSON from the request
            jsonObject=new JSONObject(bookList.getBody());
            // Then we retrieve a specific child from the JSON in this case
            //{
            //    results : {
            //        books : {
            //            "Here will be all the books".
            //        }
            //    }
            //}
            jsonArray=jsonObject.getJSONObject("results").getJSONArray("books");

            // When we have our object array, we can iterate it and map all the attributes
            for(int i=0; i<jsonArray.length();i++){
                JSONObject obj = jsonArray.getJSONObject(i);
                Book book = new Book();
                // TODO: Map the book atributes from the JSONObject
                // Remember that you need to map the Book attributes from the JSONObject having this structure:
                // {
                //     author : "",
                //     title : "",
                //     publisher : "",
                //     description : ""
                // }

                // Once the attributes were mapped on the object we just add it to the list, and
                // the logic will repeat on every json object from the request.
                topBooks.add(book);
            }

        }
        return topBooks;
    }


}
