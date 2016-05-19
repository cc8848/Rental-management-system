package com.pb.service.impl;


import com.pb.dao.HouseDao;
import com.pb.dao.impl.HouseDaoImpl;
import com.pb.entity.*;
import com.pb.service.IHouseService;
import com.pb.util.UpLoadFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class IHouseServiceImpl implements IHouseService {
    private HouseDao houseDao = new HouseDaoImpl();

    /**
     * ���淿��
     * @param house ��ҳ�洫���ķ�����Ϣ
     */
    @Override
    public boolean save(House house, UpLoadFile file) {
        houseDao.save(house);
        return false;
    }

    /**
     * ɾ������
     * @param house ��ҳ�洫���ķ�����Ϣ
     */
    @Override
    public void delete(House house) {
        houseDao.delete(house);
    }

    /**
     * �޸ķ���
     * @param house ��ҳ�洫���ķ�����Ϣ
     */
    @Override
    public boolean update(House house, UpLoadFile file) {
        houseDao.update(house);
        return false;
    }

    /**
     * ����Id��ȡ����
     * @param id int���͵Ĳ���
     */
    @Override
    public House findById(Integer id) {
        House house = (House) houseDao.findById(House.class, id);
        return house;
    }

    /**
     * ����houseId��ȡ����ͼƬ����
     * @param id ����id
     */
    @Override
    public HousePicture getPictureById(Integer id) {
        return houseDao.getPictureById(id);
    }

    /**
     * ��ѯ���з����б�
     * @param params Map���͵Ĳ���
     */
    @Override
    public Object[] findAll(Map<String, Object> params) {
        return houseDao.findAll(params);
    }

    /**
     * ��ѯ���з��������б�
     */
    @Override
    public List<HouseType> findTypeList() {
        List l = houseDao.findAll(HouseType.class);
        return l;
    }

    /**
     * ��ѯ�������б�
     */
    @Override
    public List<District> findDistrictList() {
        List l = houseDao.findAll(District.class);
        return l;
    }

    /**
     * ������id��ѯ���нֵ��б�
     */
    @Override
    public List<Street> findStreetListByDisId(int disId) {
        List<Street> list = new ArrayList<Street>();
        District district = (District) houseDao.findById(District.class, disId);
        for (Object street : district.getStreets()) {
            list.add((Street) street);
        }
        return list;
    }

    /** getters and setters*/
    public HouseDao getHouseDao() {
        return houseDao;
    }

    public void setHouseDao(HouseDao houseDao) {
        this.houseDao = houseDao;
    }
}
