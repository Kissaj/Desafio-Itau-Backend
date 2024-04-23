package itau.desafio.com.books;

import itau.desafio.com.books.dto.BookDTO;
import itau.desafio.com.books.dto.BooksDTO;
import itau.desafio.com.books.util.Constants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("book")
public class BooksAPI {

    @GetMapping("{bookId}")
    public BookDTO get(@PathVariable("bookId") String bookId){

        RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<BookDTO> resp =
                    restTemplate
                            .getForEntity(
                                    String.format(Constants.ENDPOINT.concat("%s"), bookId),
                                    BookDTO.class);
        return resp.getBody();
    }

    @GetMapping
    public BooksDTO getAll() {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<BooksDTO> resp =
                restTemplate
                        .getForEntity(Constants.ENDPOINT, BooksDTO.class);
        return resp.getBody();
    }

    @DeleteMapping("{bookId}")
    public void delete(@PathVariable("bookId") String bookId){
        RestTemplate restTemplate = new RestTemplate();
            restTemplate.delete(String.format(Constants.ENDPOINT.concat("%s"), bookId));
    }

    @PostMapping
    public BookDTO post(@RequestBody BookDTO bookIn){
        BookDTO book = new BookDTO();
            book.setIsbn(bookIn.getIsbn());
            book.setBookName(bookIn.getBookName());
            book.setAuthorName(bookIn.getAuthorName());
            book.setRating(bookIn.getRating());

        RestTemplate restTemplate = new RestTemplate();
                restTemplate.postForEntity(Constants.ENDPOINT, book, BooksDTO.class);

        return book;
    }

    @PutMapping("{bookId}")
    public void update(@PathVariable("bookId") String bookId, @RequestBody BookDTO bookIn){
        BookDTO book = get(bookId);
            book.setBookName(bookIn.getBookName());
            book.setAuthorName(bookIn.getAuthorName());
            book.setRating(bookIn.getRating());

        delete(bookId);
        post(book);
    }
}