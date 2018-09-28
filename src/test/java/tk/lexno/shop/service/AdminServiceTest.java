package tk.lexno.shop.service;

import org.hibernate.validator.constraints.pl.REGON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.junit4.SpringRunner;
import tk.lexno.shop.entity.Admin;

import javax.annotation.Resource;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceTest {

    @Resource
    private AdminService adminService;

    @Test
    public void checkLogin() {
        Admin admin = new Admin();
        admin.setUsername("admin");
        admin.setPassword("123456");
        assertTrue(adminService.checkLogin(admin));
    }

    @Test
    public void findByUsername() {
        Admin admin = adminService.findByUsername("admin");
        assertThat(admin.getUsername(), is("admin"));
        assertThat(admin.getPassword(), is("123456"));
        assertThat(admin.getId(), is(2L));
    }

    @Test
    public void findById() {
        Admin admin = adminService.findById(2L);
        assertThat(admin.getUsername(), is("admin"));
        assertThat(admin.getPassword(), is("123456"));
        assertThat(admin.getId(), is(2L));
    }

    // 重复添加同名管理员， 断言异常
    @Test
    public void save() {
        Admin admin = new Admin();
        admin.setUsername("admin");
        admin.setPassword("123456");
        try {
            adminService.save(admin);
            fail("Excepted a DuplicateKeyException to be thrown");
        } catch (Exception e) {
            assertTrue(e instanceof DuplicateKeyException);
            assertTrue(e.getMessage().contains("Duplicate entry 'admin' for key 'username'"));
        }

    }
}