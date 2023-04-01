package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    public List<DiscussPost> selectDiscussionPost(@Param("userId")int userId,@Param("offset")int offset,@Param("limit")int limit);
    public int selectDiscussionPostRows(@Param("userId") int userId);
}
//@Para是mybatis提供的注解 为sql语句起别名，用来规定参数列表到sql语句中的映射关系。
//如果不加param，在sql语句中会默认按从左到右的顺序进行映射（在两者名字不同的情况下）
//在sql动态语句块中，一定需要加@param。在mybatis中会自动根据参数名称来匹配参数。在动态语句块中没加param的参数没办法进行匹配。
