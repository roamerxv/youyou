package pers.roamer.youyou.controller;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;

/**
 * 基础控制类
 *
 * @author roamer - 徐泽宇
 * @create 2017-06-2017/6/2  下午4:24
 */
@Log4j2
@Controller("com.ninelephas.raccoon.controller.BaseController")
public class BaseController {
    @Autowired
    protected HttpSession httpSession;

    public String getUserName() throws ControllerException {
        String user_name = (String) httpSession.getAttribute("user_name");
        log.debug("当前 session 中的user_name 是 {}", user_name);
        if (StringUtils.isEmpty(user_name)) {
            throw new ControllerException("exception.system.need_login");
        }
        return user_name;
    }
}
