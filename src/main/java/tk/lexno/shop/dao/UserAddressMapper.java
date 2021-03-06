package tk.lexno.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import tk.lexno.shop.entity.UserAddress;
import tk.lexno.shop.entity.UserAddressExample;

@Mapper
public interface UserAddressMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserAddress record);

    int insertSelective(UserAddress record);

    List<UserAddress> selectByExample(UserAddressExample example);

    UserAddress selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserAddress record);

    int updateByPrimaryKey(UserAddress record);
}