package tk.lexno.shop.dao;

import java.util.List;
import tk.lexno.shop.entity.Admin;
import tk.lexno.shop.entity.AdminExample;

public interface AdminMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}