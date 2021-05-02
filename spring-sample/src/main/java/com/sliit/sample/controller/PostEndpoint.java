package com.sliit.sample.controller;

import com.sliit.sample.api.PostApi;
import com.sliit.sample.domain.Post;
import com.sliit.sample.dto.PostsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/posts/")
public class PostEndpoint {  //or Post controller if you like

    private PostApi postApi;

    @Autowired
    public PostEndpoint(PostApi postApi){
        this.postApi = postApi;
    }

    @GetMapping
    public List<Post> getPosts(){
        return postApi.getAllPosts();
    }

    /*@PostMapping
    public void addNewPost(@RequestBody Post post){
        UUID uuid;
        postApi.addPost(post);
    }*/

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post addNewPost(@RequestBody PostsDto postsDto){
        Post post =  new Post();
        post.setName(postsDto.getName());
        post.setDescription(postsDto.getDescription());
        return postApi.addPost(post);
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Post deletePost(@PathVariable String id){
        return postApi.removePost(id);
    }
}
