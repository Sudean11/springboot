package com.miu.lab.lab1.repo.repoImpl;

import com.miu.lab.lab1.entity.Post;
import com.miu.lab.lab1.repo.PostRepo;
import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepoImpl implements PostRepo {
    private static List<Post> posts;

    private static long lastId = 10;
    static {
        posts = new ArrayList<>();
        posts.add(new Post(1, "Exploring the Wonders of Nature", "A Photographic Journey", "John Doe"));
        posts.add(new Post(2, "Unlocking the Secrets of Productivity", "Tips and Tricks", "Jane Smith"));
        posts.add(new Post(3, "Delicious Recipes for a Weekend Feast", "content", "Alex Johnson"));
        posts.add(new Post(4, "The Art of Mindfulness", "Finding Peace in Everyday Chaos", "Emily Davis"));
        posts.add(new Post(5, "Tech Trends 2024", "What's Next in Innovation?", "Michael Brown"));
        posts.add(new Post(6, "Adventures in Fiction", "Book Recommendations for Every Reader", "Sophie Miller"));
        posts.add(new Post(7, "Fitness Motivation 101", "Achieve Your Health Goals", "Daniel White"));
        posts.add(new Post(8, "Capturing Moments", "Photography Tips for Beginners", "Olivia Taylor"));
        posts.add(new Post(9, "DIY Home Decor", "Transform Your Space with Creativity", "William Turner"));
        posts.add(new Post(10, "Musical Discoveries", "Hidden Gems in Various Genres", "Ella Martinez"));
    }

    public List<Post> getPosts(){
        return posts;
    }

    @Override
    public Post getPostById(int id) {
        return posts.stream().filter(x->x.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void createNewPost(@NotNull Post post) {
        lastId++;
        post.setId(lastId);
        posts.add(post);
    }

    @Override
    public void deletePostById(int id) {
        Post postToDelete = posts.stream().filter(x->x.getId() == id).findFirst().orElse(null);
        if(postToDelete!=null) {
            posts.remove(postToDelete);
        }
    }

    @Override
    public void updatePostById(int id, Post post) {
        Post postToUpdate = posts.stream().filter(x->x.getId() == id).findFirst().orElse(null);
        if(postToUpdate != null){
            postToUpdate.setAuthor(post.getAuthor());
            postToUpdate.setContent(post.getContent());
            postToUpdate.setTitle(post.getTitle());
        }
    }

    @Override
    public List<Post> findAllPostsByAuthor(String author) {
        return posts.stream()
                .filter(x->x.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    @Override
    public List<Post> getPostsByAuthorText(String text) {
        return posts.stream().filter(x->x.getAuthor().contains(text)).collect(Collectors.toList());
    }

}
