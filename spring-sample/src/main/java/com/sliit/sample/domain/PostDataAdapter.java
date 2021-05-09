package com.sliit.sample.domain;

import java.util.List;

public interface PostDataAdapter {

    Post save(Post post);
    List<Post> getAll();
    String delete(String id);
    public Post update(Post post);
}
