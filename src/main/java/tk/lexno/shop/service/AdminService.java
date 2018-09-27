package tk.lexno.shop.service;

import tk.lexno.shop.entity.Admin;

public interface AdminService {

    /**
     * 管理员登录
     *
     * @param admin 登录信息
     * @return 登录成功或失败
     */
    boolean checkLogin(Admin admin);

    /**
     * 根据用户名查找管理员
     *
     * @param username 用户名
     * @return 管理员信息
     */
    Admin findByUsername(String username);

    /**
     * 根据id查询管理员
     *
     * @param id 管理员id
     * @return 管理员信息
     */
    Admin findById(Long id);

    /**
     * 添加管理员
     *
     * @param admin 管理员信息
     */
    void save(Admin admin);
}
