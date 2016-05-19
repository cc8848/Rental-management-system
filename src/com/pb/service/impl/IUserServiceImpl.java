package com.pb.service.impl;

import com.pb.dao.House_userDao;
import com.pb.dao.impl.House_userDaoImpl;
import com.pb.entity.HouseUser;
import com.pb.service.IUserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *��¼��ע�ᣬ��֤������id��ȡ����
 */
public class IUserServiceImpl implements IUserService {
    House_userDao userDao = new House_userDaoImpl();
    List<HouseUser> result = null;

    /**
     * ��¼
     * @param user ��ҳ���ȡ���û���Ϣ
     * @return �������ݵ�map����
     */
    @Override
    public Map<String, Object> login(HouseUser user) {
        Map<String, Object> session = new HashMap<>();
            for (HouseUser user1 : result) {
                if (user1.getPassword().equals(user.getPassword())) {
                    session.put("user", user1);
                }
            }
        return session;
    }

    /**
     * ע��
     * @param user ��ҳ���ȡ���û���Ϣ
     * @return boolean
     */
    @Override
    public boolean doRegister(HouseUser user) {
        if (validate(user.getUsername())) {
            System.out.println("�û����Ѿ�����");
            return false;
        }
        userDao.save(user);
        return true;
    }

    /**
     * ��֤
     * @param name ������û���
     * @return boolean����
     */
    @Override
    @SuppressWarnings("unchecked")
    public boolean validate(String name) {
        String className = "HouseUser";
        String propertyName = "username";
        result = (List<HouseUser>) userDao.findByProperty(className, propertyName, name);
        if (result.size()>0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * ����Id��ȡuser����
     * @param id �û�id
     * @return �û�ʵ�����
     */
    @Override
    public HouseUser getUserById(Integer id) {
       return (HouseUser)userDao.findById(HouseUser.class,id);
    }

    /*getters and setters*/

    public List<HouseUser> getResult() {
        return result;
    }

    public void setResult(List<HouseUser> result) {
        this.result = result;
    }

    public House_userDao getUserDao() {
        return userDao;
    }

    public void setUserDao(House_userDao userDao) {
        this.userDao = userDao;
    }
}
