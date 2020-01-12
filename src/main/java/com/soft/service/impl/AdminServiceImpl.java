package com.soft.service.impl;

import com.soft.mapper.AdminMapper;
import com.soft.model.Admin;
import com.soft.model.AdminExample;
import com.soft.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName AdminServiceImpl
 * @Description AdminService的实现类
 * @Author ljy
 * @Date 2020/1/11 18:59
 * @Version 1.0
 **/
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    /**
     * @Description 根据用户名查询管理员
     * @Param [adminName]
     * @Return com.soft.model.Admin
     * @Author ljy
     * @Date 2020/1/11 18:54
     */
    @Override
    public Admin loadByUserName(String adminName) {
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andAdminNameEqualTo(adminName);
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        if (admins != null && admins.size() > 0){
            return admins.get(0);
        }
        return null;
    }

    /**
     * @Description 根据admin_id查询管理员
     * @Param [adminId]
     * @Return com.soft.model.Admin
     * @Author ljy
     * @Date 2020/1/11 18:55
     */
    @Override
    public Admin loadByAdminId(Integer adminId) {
        return adminMapper.selectByPrimaryKey(adminId);
    }

    /**
     * @Description 更新管理员
     * @Param [admin]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 18:55
     */
    @Override
    public int updateAdmin(Admin admin) {
        return adminMapper.updateByPrimaryKeySelective(admin);
    }
}
