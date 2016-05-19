package com.pb.action;

import com.opensymphony.xwork2.ActionContext;
import com.pb.base.action.BaseAction;
import com.pb.entity.House;
import com.pb.service.IHouseService;
import com.pb.service.impl.IHouseServiceImpl;
import org.apache.struts2.StrutsStatics;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class HouseSearchAction extends BaseAction {
    private String title;
    private String price;
    private String housePosition;
    private String houseType;
    private String houseArea;

    private House house;
    private IHouseService service = new IHouseServiceImpl();

    @SuppressWarnings("unchecked")
    public String searchHouses(){
        Map params = new HashMap();
        params.put("����",title);
        params.put("�۸�", price);
        params.put("����λ��",housePosition);
        params.put("����", houseType);
        params.put("���", houseArea);
        Object[] houses = service.findAll(params);
        //�ѻ�ȡ�ķ����б���Ϣ��ŵ�request�򣬴��ݵ���һ��action ��Ҳ����ͨ�����Ը�ֵ�ķ������ݣ�
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
        request.setAttribute("houses",houses);
        return SUCCESS;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public String getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(String houseArea) {
        this.houseArea = houseArea;
    }

    public String getHousePosition() {
        return housePosition;
    }

    public void setHousePosition(String housePosition) {
        this.housePosition = housePosition;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public IHouseService getService() {
        return service;
    }

    public void setService(IHouseService service) {
        this.service = service;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
