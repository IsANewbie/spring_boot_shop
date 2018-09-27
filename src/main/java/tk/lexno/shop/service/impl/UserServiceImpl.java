package tk.lexno.shop.service.impl;

import org.springframework.stereotype.Service;
import tk.lexno.shop.dao.UserAddressMapper;
import tk.lexno.shop.dao.UserMapper;
import tk.lexno.shop.entity.User;
import tk.lexno.shop.entity.UserAddress;
import tk.lexno.shop.entity.UserAddressExample;
import tk.lexno.shop.entity.UserExample;
import tk.lexno.shop.service.UserService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserAddressMapper addressMapper;

    @Override
    public boolean checkLogin(User user) {
        return false;
    }

    @Override
    public User findUserByUsername(String username) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<User> userList = userMapper.selectByExample(example);
        if (userList != null) {
            return userList.get(0);
        }
        return null;
    }

    @Override
    public void saveUser(User user) {
        userMapper.insertSelective(user);
    }

    @Override
    public User findUserById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<UserAddress> findUserAddress(Long userId) {
        UserAddressExample example = new UserAddressExample();
        UserAddressExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(Boolean.FALSE);
        criteria.andUserIdEqualTo(userId);
        return addressMapper.selectByExample(example);
    }

    @Override
    public void updateAddress(UserAddress userAddress) {
        addressMapper.updateByPrimaryKeySelective(userAddress);
    }

    @Override
    public void deleteAddressById(Long addressId) {
        UserAddress address = new UserAddress();
        address.setId(addressId);
        address.setDeleted(Boolean.TRUE);
        addressMapper.updateByPrimaryKeySelective(address);
    }

    @Override
    public UserAddress findAddressById(Long addressId) {
        return addressMapper.selectByPrimaryKey(addressId);
    }

    @Override
    public void saveAddress(UserAddress address) {
        addressMapper.insertSelective(address);
    }
}
