package com.pb.action;

import com.pb.base.action.BaseAction;
import com.pb.entity.HouseUser;
import com.pb.service.IUserService;
import com.pb.service.impl.IUserServiceImpl;

/**
 *��½������
 * ������֤�û��Ƿ���ڣ������Ƿ���ȷ
 */
public class LoginAction extends BaseAction {
    IUserService service = new IUserServiceImpl();
    HouseUser houseUser;
    public String login() {
        //���ڲ��ԵĴ���
       /* HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
        houseUser = (HouseUser) request.getAttribute("houseUser");*/
        if (service.validate(houseUser.getUsername())) {
            HouseUser user = (HouseUser) service.login(houseUser).get("user");
            if (service.login(houseUser).size() != 0 && houseUser.getPassword().equals(user.getPassword())) {
                service.login(houseUser);
                session.put("user", user);
                return SUCCESS;
            }
            //���actionMessage����ת����ҳ�����ʹ��<s:actionMessage/>����
            addActionMessage("���벻��ȷ");
            return LOGIN;
        } else {
            addActionMessage("�û���������");
            return LOGIN;
        }
    }

    public HouseUser getHouseUser() {
        return houseUser;
    }

    public void setHouseUser(HouseUser houseUser) {
        this.houseUser = houseUser;
    }

    public IUserService getService() {
        return service;
    }

    public void setService(IUserService service) {
        this.service = service;
    }
}
