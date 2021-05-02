package com.sliit.sample.api;

import com.sliit.sample.domain.Post;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PostApi {


    private Map<String, Post> posts;

    public PostApi(){
        this.posts = new HashMap<>();
    }

    //Map<>
    public List<Post> getAllPosts(){

        //List<Post> postList = new ArrayList<>();
        return new ArrayList<>(posts.values());
    }

    public Post addPost(Post post){
        post.setId(UUID.randomUUID().toString());
        posts.put(post.getId(),post);
        return post;
    }

    public Post removePost(String id){
        return posts.remove(id);
    }

    public Post updatePost(Post post){
       Post oldPost =  posts.get(post.getId());
       oldPost.setName(post.getName());
       oldPost.setDescription(post.getDescription());
       posts.put(oldPost.getId(),oldPost);
       return oldPost;
    }

}
