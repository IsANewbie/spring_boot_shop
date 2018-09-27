package tk.lexno.shop.service;

import tk.lexno.shop.entity.User;
import tk.lexno.shop.entity.UserAddress;

import java.util.List;

public interface UserService {

    /**
     * 检查登录
     *
     * @param user 需要登录的用户
     * @return 用户名和密码相符返回true，否则返回false
     */
    boolean checkLogin(User user);

    /**
     * 根据用户名查找用户
     *
     * @param username 用户名
     * @return 要查询的用户
     */
    User findUserByUsername(String username);

    /**
     * 添加用户
     *
     * @param user 用户信息
     */
    void saveUser(User user);

    /**
     * 根据用户id查找用户
     *
     * @param id 用户id
     * @return 要查询的用户
     */
    User findUserById(Long id);

    /**
     * 根据用户id查询所属用户的收件地址
     *
     * @param userId 用户id
     * @return
     */
    List<UserAddress> findUserAddress(Long userId);

    /**
     * 修改用户收件地址
     *
     * @param userAddress 修改用户收件地址
     */
    void updateAddress(UserAddress userAddress);

    /**
     * 根据收件地址id，删除收件地址
     *
     * @param addressId 收件地址id
     */
    void deleteAddressById(Long addressId);

    /**
     * 根据收件地址id，查询收件地址
     *
     * @param addressId 收件地址id
     * @return 要查询的收件地址
     */
    UserAddress findAddressById(Long addressId);

    /**
     * 添加收件地址
     *
     * @param address 收件地址详情
     */
    void saveAddress(UserAddress address);
}
