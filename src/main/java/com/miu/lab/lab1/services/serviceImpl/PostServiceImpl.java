package com.miu.lab.lab1.services.serviceImpl;

import com.miu.lab.lab1.entity.Post;
import com.miu.lab.lab1.entity.dtos.PostDto;
import com.miu.lab.lab1.helper.ListMapper;
import com.miu.lab.lab1.repo.PostRepo;
import com.miu.lab.lab1.services.PostService;
import io.micrometer.common.util.StringUtils;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepo postRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper listMapper;

    @Override
    public List<PostDto> getPosts() {
        return (List<PostDto>)listMapper.mapList(postRepo.getPosts(), new PostDto());
    }

    @Override
    public Post getPostById(int id) {
        return postRepo.getPostById(id);
    }

    @Override
    public Boolean createNewPost(PostDto postDto) {
        if(StringUtils.isNotBlank(postDto.getTitle())
                && StringUtils.isNotBlank(postDto.getContent())
                && StringUtils.isNotBlank(postDto.getAuthor()))
        {
            postRepo.createNewPost(modelMapper.map(postDto, Post.class));
            return true;
        }
        return false;
    }

    @Override
    public void deletePostById(int id) {
        postRepo.deletePostById(id);
    }

    @Override
    public void updatePostById(int id, PostDto postDto) {
        postRepo.updatePostById(id, modelMapper.map(postDto, Post.class));
    }

    @Override
    public List<PostDto> findAllPostsByAuthor(String author) {
        return (List<PostDto>)listMapper.mapList(postRepo.findAllPostsByAuthor(author), new PostDto());
    }

    @Override
    public List<PostDto> getPostsByAuthorText(String text) {
        return (List<PostDto>)listMapper.mapList(postRepo.getPostsByAuthorText(text), new PostDto());
    }
}
