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

    private String apiKey="YndTMMQtxjDsWZytNuGEGvVyGy0M9ICl";
    private RestTemplate restTemplate= new RestTemplate();
    private JSONObject jsonObject;
    private JSONArray jsonArray;

    public List<Book> getTopBooks() throws Exception{
        List<Book> topBooks=new ArrayList<>();
        String url="https://api.nytimes.com/svc/books/v3/lists/current/hardcover-fiction.json?api-key="+ apiKey;

        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity= new HttpEntity(headers);

        ResponseEntity<Map> bookList=restTemplate.exchange(url, HttpMethod.GET,entity, Map.class);

        if(bookList.getStatusCode()==HttpStatus.OK){
            jsonObject=new JSONObject(bookList.getBody());
            jsonArray=jsonObject.getJSONObject("results").getJSONArray("books");

            for(int i=0; i<jsonArray.length();i++){
                Book book=new Book();
                book.setAuthor(jsonArray.getJSONObject(i).get("author").toString());
                book.setTitle(jsonArray.getJSONObject(i).get("title").toString());
                book.setPublisher(jsonArray.getJSONObject(i).get("publisher").toString());
                book.setDescription(jsonArray.getJSONObject(i).get("description").toString());
                topBooks.add(book);
            }

        }
        return topBooks;
    }


}
