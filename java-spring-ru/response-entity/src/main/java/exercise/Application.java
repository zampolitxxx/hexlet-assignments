package exercise;

import java.net.URI;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import exercise.model.Post;

@SpringBootApplication
@RestController
public class Application {
    // Хранилище добавленных постов
    private List<Post> posts = Data.getPosts();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    //show all posts
    @GetMapping("/posts")
    public ResponseEntity<List<Post>> index() {
        var result = posts.stream().toList();
        return ResponseEntity.ok()
                .header("X-Total-Count", String.valueOf(posts.size()))
                .body(result);
    }
    //show concreet post
    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> show(@PathVariable String id) {
        var post = posts.stream()
                .filter(p -> p.getId().equals(id)).findFirst();
        if (post.isPresent()) {
            return ResponseEntity.of(post);
        } else return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    //Create new post
    @PostMapping("/posts")
    public ResponseEntity<Post> create(@RequestBody Post post) {
        posts.add(post);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }
    //Update status
    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> update(@PathVariable String id, @RequestBody Post data) {
        var maybePost = posts.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        if(maybePost.isPresent()) {
            var post = maybePost.get();
            post.setId(data.getId());
            post.setTitle(data.getTitle());
            post.setBody(data.getBody());
            return new ResponseEntity<>(data, HttpStatus.OK);
        } else {
            return new ResponseEntity(data, HttpStatus.NO_CONTENT);
        }
    }
    // END

    @DeleteMapping("/posts/{id}")
    public void destroy(@PathVariable String id) {
        posts.removeIf(p -> p.getId().equals(id));
    }
}
