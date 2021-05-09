package com.sliit.sample.api;

import com.sliit.sample.domain.Post;
import com.sliit.sample.domain.PostDataAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class PostApi {


    private Map<String, Post> posts;

    private final PostDataAdapter postDataAdapter;

    @Autowired
    public PostApi(PostDataAdapter postDataAdapter){
        this.postDataAdapter =  postDataAdapter;
        this.posts = new HashMap<>();
    }

    //Map<>
    public List<Post> getAllPosts(){

        //List<Post> postList = new ArrayList<>();
        //return new ArrayList<>(posts.values());
        return new ArrayList<>(postDataAdapter.getAll());
    }

    public Post addPost(Post post){
        //post.setId(UUID.randomUUID().toString());
        //posts.put(post.getId(),post);
        post.setPostedDate(LocalDateTime.now());
        postDataAdapter.save(post);
        return post;
    }

    public String removePost(String id){

        String deletedId = postDataAdapter.delete(id);


        return deletedId; //prev returned Post type
        //return posts.remove(id);
    }

    public Post updatePost(Post post){
       /*Post oldPost =  posts.get(post.getId());
       oldPost.setName(post.getName());
       oldPost.setDescription(post.getDescription());
       posts.put(oldPost.getId(),oldPost);*/

       Post updatedPost = postDataAdapter.update(post);
       return updatedPost;
    }

}
