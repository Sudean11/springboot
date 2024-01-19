package com.miu.lab.lab1.services.serviceImpl;

import com.miu.lab.lab1.entity.Comment;
import com.miu.lab.lab1.entity.Post;
import com.miu.lab.lab1.entity.User;
import com.miu.lab.lab1.entity.dtos.CommentDto;
import com.miu.lab.lab1.helper.ListMapper;
import com.miu.lab.lab1.repo.CommentRepo;
import com.miu.lab.lab1.repo.PostRepo;
import com.miu.lab.lab1.repo.UserRepo;
import com.miu.lab.lab1.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PostRepo postRepo;

    @Autowired
    ListMapper listMapper;

    @Override
    public void addNewComment(long postId, CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setName(commentDto.getName());
        comment.setPost(postRepo.findById(postId).orElse(null));
        if(comment.getPost() != null){
            commentRepo.save(comment);
        }
    }

    @Override
    public List<CommentDto> findCommentsFromPostId(long user_id, long post_id) {
        return (List<CommentDto>) listMapper.mapList(commentRepo.findAllByPost(postRepo.findById(post_id).orElse(null)), new CommentDto());
    }

    @Override
    public CommentDto findCommentsFromPostId(
            long user_id,
            long post_id,
            long comment_id) {

        User user = userRepo.findById(user_id).orElse(null);
        if(user!=null){
            Post post = user.getPosts().stream().filter(x->x.getId() == post_id).findFirst().orElse(null);
            if(post!= null){
                Comment comment = post.getCommentList().stream().filter(x->x.getId() == comment_id).findFirst().orElse(null);
                if(comment != null){
                    return modelMapper.map(comment, CommentDto.class);
                }
            }
        }
        return null;
    }
}
