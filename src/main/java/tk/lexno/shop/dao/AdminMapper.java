package tk.lexno.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import tk.lexno.shop.entity.Admin;
import tk.lexno.shop.entity.AdminExample;

@Mapper
public interface AdminMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}