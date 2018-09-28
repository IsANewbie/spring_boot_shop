package tk.lexno.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import tk.lexno.shop.entity.User;
import tk.lexno.shop.entity.UserExample;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}