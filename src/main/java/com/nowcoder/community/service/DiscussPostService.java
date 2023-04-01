package com.nowcoder.community.service;
import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DiscussPostService {
    @Autowired
    private DiscussPostMapper postmapper;
    public List<DiscussPost>  selectDiscussionPost(int userId, int offset ,int limit){
        return  postmapper.selectDiscussionPost(userId,offset,limit);
    }
    public int selectDiscussionPostRows(int userId){
        return postmapper.selectDiscussionPostRows(userId);
    }
}
