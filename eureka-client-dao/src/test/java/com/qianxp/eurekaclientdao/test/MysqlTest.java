package com.qianxp.eurekaclientdao.test;

import com.qianxp.eurekaclientdao.entity.Department;
import com.qianxp.eurekaclientdao.entity.Role;
import com.qianxp.eurekaclientdao.entity.User;
import com.qianxp.eurekaclientdao.repository.DepartmentRepository;
import com.qianxp.eurekaclientdao.repository.RolesRepository;
import com.qianxp.eurekaclientdao.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;


@RunWith(SpringJUnit4ClassRunner.class)
public class MysqlTest {
    private static Logger logger = LoggerFactory.getLogger(MysqlTest.class);
    @Autowired
    UserRepository userRepository;
    @Autowired
    RolesRepository rolesRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    @Before
    public void initData() {
        userRepository.deleteAll();
        departmentRepository.deleteAll();
        departmentRepository.deleteAll();
        Department department = new Department();
        department.setName("开发部");
        departmentRepository.save(department);
        Assert.assertNotNull(department.getId());

        Role role = new Role();
        role.setName("admin");
        rolesRepository.save(role);
        Assert.assertNotNull(role.getId());

        User user = new User();
        user.setName("测试用户1");
        user.setCreatedate(new Date());
        java.util.List<Role> roles = rolesRepository.findAll();
        Assert.assertNotNull(roles);
        user.setRoles(roles);
        userRepository.save(user);
        Assert.assertNotNull(user.getId());

    }

    @Test
    public void findByPage() {
        Pageable pageable = PageRequest.of(0, 10, new Sort(Sort.Direction.ASC, "id"));
        Page<User> page = userRepository.findAll(pageable);
        Assert.assertNotNull(page);
        for (User user : page.getContent())
            logger.info("======user=======user name:{},department name:{} ,role name:{} ", user.getName(), user.getDepartment().getName(), user.getRoles().get(0).getName());
    }



}
