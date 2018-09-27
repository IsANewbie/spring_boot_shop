package tk.lexno.shop.service.impl;

import org.springframework.stereotype.Service;
import tk.lexno.shop.dao.AdminMapper;
import tk.lexno.shop.entity.Admin;
import tk.lexno.shop.entity.AdminExample;
import tk.lexno.shop.service.AdminService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lexno
 * @email lexno23@gmail.com
 * @date 2018-09-27
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public boolean checkLogin(Admin admin) {
        Admin inAdmin = findByUsername(admin.getUsername());
        if (inAdmin != null && admin != null && inAdmin.getUsername().equals(admin.getUsername()) &&
                inAdmin.getPassword().equals(admin.getPassword())) {
            return true;
        }
        return false;
    }

    @Override
    public Admin findByUsername(String username) {
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<Admin> adminList = adminMapper.selectByExample(example);
        if (adminList != null) {
            return adminList.get(0);
        }
        return null;
    }

    @Override
    public Admin findById(Long id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public void save(Admin admin) {
        adminMapper.insertSelective(admin);
    }
}
