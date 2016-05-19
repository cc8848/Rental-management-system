package com.pb.dao;

import com.pb.base.dao.IBaseDao;
import com.pb.entity.House;
import com.pb.entity.HousePicture;

import java.util.Map;

/**
 *���ݲ�ѯ�����ӿ�
 */
public interface HouseDao extends IBaseDao<House> {

    /**
     * ����houseId��ȡ����ͼƬ����
     * @param id ����id
     */
    HousePicture getPictureById(Integer id);
    /**
     * ��ѯ���з����б�
     * @param params Map���͵Ĳ���
     */
    Object[] findAll(Map<String,Object> params);

}
