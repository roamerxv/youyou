package pers.roamer.youyou.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pers.roamer.boracay.aspect.businesslogger.BusinessMethod;
import pers.roamer.boracay.aspect.httprequest.SessionCheckKeyword;
import pers.roamer.boracay.configer.ConfigHelper;
import pers.roamer.boracay.helper.HttpResponseHelper;
import pers.roamer.boracay.helper.JsonUtilsHelper;
import pers.roamer.youyou.entity.*;
import pers.roamer.youyou.service.*;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

/**
 * @author roamer - 徐泽宇
 * @create 2017-08-2017/8/1  下午6:31
 */
@Controller("pers.roamer.youyou.controller.UserController")
@Log4j2
public class UserController extends BaseController {

    @Autowired
    ParkingInfoService parkingInfoService;

    @Autowired
    LivingTypeService livingTypeService;

    @Autowired
    ParkingTypeService parkingTypeService;

    @Autowired
    ApproveTypeService approveTypeService;

    @Autowired
    UserService userService;


    /**
     * 显示所有的已经停在车位上的车辆登记信息
     *
     * @return
     *
     * @throws ControllerException
     */
    @BusinessMethod(value = "列出已停车辆")
    @SessionCheckKeyword(checkIt = false)
    @GetMapping(value = "/parking_infos/parked")
    @ResponseBody
    public String showParkingInfo() throws ControllerException {
        log.debug("开始列出所有已经有停车位的车辆信息");
        try {
            HashMap hashMap = new HashMap();
            String m_rtn = "";
            try {
                hashMap.put("data", parkingInfoService.findAllParked());
                m_rtn = JsonUtilsHelper.objectToJsonString(hashMap);
            } catch (JsonProcessingException e) {
                log.error(e.getStackTrace());
            }
            log.debug("开始列出所有已经有停车位的车辆信息----完成");
            return m_rtn;
        } catch (ServiceException e) {
            log.error(e.getMessage());
            throw new ControllerException(e.getMessage());
        }
    }

    /**
     * 显示所有的未停的正在排队的车辆登记信息
     *
     * @return
     *
     * @throws ControllerException
     */
    @BusinessMethod(value = "列出排队车辆")
    @SessionCheckKeyword(checkIt = false)
    @GetMapping(value = "/parking_infos/lining")
    @ResponseBody
    public String showLiningParkingInfo() throws ControllerException {
        log.debug("开始列出正在排队的车辆信息");
        try {
            HashMap hashMap = new HashMap();
            String m_rtn = "";
            try {
                hashMap.put("data", parkingInfoService.findAllLining());
                m_rtn = JsonUtilsHelper.objectToJsonString(hashMap);
            } catch (JsonProcessingException e) {
                log.error(e.getStackTrace());
            }
            log.debug("开始列出正在排队的车辆信息----完成");
            return m_rtn;
        } catch (ServiceException e) {
            log.error(e.getMessage());
            throw new ControllerException(e.getMessage());
        }
    }

    /**
     * 适用于 select2 控件显示居住类型的 json
     *
     * @return
     *
     * @throws ControllerException
     */
    @GetMapping(value = "/parking_infos/living_type")
    @ResponseBody
    public String livingType4Select2() throws ControllerException {
        log.debug("获取所有居住类型的 json 对象");
        List<LivingTypeEntity> livingTypeEntities = livingTypeService.findAll();
        try {
            List<Select2ItemEntity> select2ItemEntities = new ArrayList<Select2ItemEntity>();

            livingTypeEntities.forEach((item) -> {
                Select2ItemEntity select2ItemEntity = new Select2ItemEntity();
                select2ItemEntity.setId(item.getId());
                select2ItemEntity.setText(item.getName());
                select2ItemEntities.add(select2ItemEntity);
            });

            String m_rtn = JsonUtilsHelper.objectToJsonString(select2ItemEntities);
            log.debug(String.format("返回所有的居住类型的字符串是%s", m_rtn));
            return m_rtn;
        } catch (JsonProcessingException e) {
            throw new ControllerException(e.getMessage());
        }
    }

    /**
     * 获取审核状态的的 json 对象
     *
     * @return
     *
     * @throws ControllerException
     */
    @GetMapping(value = "/parking_infos/approve_type")
    @ResponseBody
    public String approveType4Select2() throws ControllerException {
        log.debug("获取所有审核状态的 json 对象");
        List<ApproveTypeEntity> approveTypeEntityList = approveTypeService.findAll();
        try {
            List<Select2ItemEntity> select2ItemEntities = new ArrayList<Select2ItemEntity>();
            approveTypeEntityList.forEach((item) -> {
                Select2ItemEntity select2ItemEntity = new Select2ItemEntity();
                select2ItemEntity.setId(item.getId());
                select2ItemEntity.setText(item.getName());
                select2ItemEntities.add(select2ItemEntity);
            });

            String m_rtn = JsonUtilsHelper.objectToJsonString(select2ItemEntities);
            log.debug(String.format("返回所有的审核结果的字符串是%s", m_rtn));
            return m_rtn;
        } catch (JsonProcessingException e) {
            throw new ControllerException(e.getMessage());
        }
    }

    /**
     * 获取现有停车证类型的 json 对象
     *
     * @return
     *
     * @throws ControllerException
     */
    @GetMapping(value = "/parking_infos/parking_type")
    @ResponseBody
    public String parkingType4Select2() throws ControllerException {
        log.debug("获取所有停车场类型的 json 对象");
        List<ParkingTypeEntity> parkingTypeEntityList = parkingTypeService.findAll();
        try {
            List<Select2ItemEntity> select2ItemEntities = new ArrayList<Select2ItemEntity>();
            parkingTypeEntityList.forEach((item) -> {
                Select2ItemEntity select2ItemEntity = new Select2ItemEntity();
                select2ItemEntity.setId(item.getId());
                select2ItemEntity.setText(item.getName());
                select2ItemEntities.add(select2ItemEntity);
            });

            String m_rtn = JsonUtilsHelper.objectToJsonString(select2ItemEntities);
            log.debug(String.format("返回所有的居住类型的字符串是%s", m_rtn));
            return m_rtn;
        } catch (JsonProcessingException e) {
            throw new ControllerException(e.getMessage());
        }
    }


    @Data
    class Select2ItemEntity {
        private String id;
        private String text;
    }

    /**
     * 增加一条车位登记信息
     *
     * @param parkingInfoEntity
     *
     * @return
     *
     * @throws ControllerException
     */
    @PostMapping(value = "/parking_infos")
    @BusinessMethod(value = "增加一条车位登记信息")
    @SessionCheckKeyword(checkIt = true)
    @ResponseBody
    public String add(@RequestBody ParkingInfoEntity parkingInfoEntity) throws ControllerException {

        try {
            String userName = (String) httpSession.getAttribute(ConfigHelper.getConfig().getString("System.SessionUserKeyword"));
            parkingInfoEntity.setCreatedBy(userName);
            parkingInfoEntity.setUpdatedBy(userName);
            try {
                log.debug("将要保存的信息是:{}", JsonUtilsHelper.objectToJsonString(parkingInfoEntity));
            } catch (JsonProcessingException e) {
                log.error(e.getMessage());
            }
            parkingInfoService.add(parkingInfoEntity);
            return HttpResponseHelper.successInfoInbox("操作成功");
        } catch (ServiceException e) {
            throw new ControllerException(e.getMessage());
        }
    }

    /**
     * 删除一条记录
     * @param id
     * @return
     * @throws ControllerException
     */

    @BusinessMethod(value = "删除一个车位信息")
    @DeleteMapping(value = "/parking_infos/{id}")
    @SessionCheckKeyword(checkIt = true)
    @ResponseBody
    public String delete(@PathVariable String id) throws ControllerException {
        try {
            parkingInfoService.delete(id);
        } catch (ServiceException e) {
            throw new ControllerException(e.getMessage());
        }
        return HttpResponseHelper.successInfoInbox("删除成功");
    }

    @BusinessMethod(value = "获取一个车位详情")
    @GetMapping(value = "/parking_infos/{id}")
    @SessionCheckKeyword(checkIt = true)
    @ResponseBody
    public String getParkingInfoWithID(@PathVariable String id) throws  ControllerException{
        try {
            log.debug("获取 id 是:({})的车位信息！",id);
            ParkingInfoEntity parkingInfoEntity =  parkingInfoService.findByID(id);
            return JsonUtilsHelper.objectToJsonString(parkingInfoEntity);
        } catch (JsonProcessingException | ServiceException e) {
            throw new ControllerException(e.getMessage());
        }
    }

    @BusinessMethod(value = "更新一个车位信息")
    @PutMapping("/parking_infos/{id}")
    @SessionCheckKeyword(checkIt = true)
    @ResponseBody
    public String updateParkingInfo(@RequestBody ParkingInfoEntity parkingInfoEntity) throws ControllerException{
        try {
            log.debug("更新一条记录:"+JsonUtilsHelper.objectToJsonString(parkingInfoEntity));
            String userName = (String) httpSession.getAttribute(ConfigHelper.getConfig().getString("System.SessionUserKeyword"));
            parkingInfoEntity.setUpdatedBy(userName);
            parkingInfoService.update(parkingInfoEntity);
        } catch (JsonProcessingException | ServiceException e) {
            log.error(e.getMessage());
        }
        return HttpResponseHelper.successInfoInbox("更新成功");
    }


    @BusinessMethod(value = "登录")
    @RequestMapping( value = "/login")
    @PostMapping("/login")
    @ResponseBody
    public String login (@RequestBody UserEntity userEntity)throws ControllerException{
        log.debug("用户登录!");
        try {
            if (userService.login(userEntity)){
                httpSession.setAttribute(ConfigHelper.getConfig().getString("System.SessionUserKeyword"),userEntity.getName());
            }
        } catch (ServiceException e) {
            log.error(e.getMessage());
            throw new ControllerException(e.getMessage());
        }
        return HttpResponseHelper.successInfoInbox("成功登录");
    }

    /**
     * 登出功能
     *
     * @return
     *
     * @throws ServiceException
     */
    @BusinessMethod(value = "登出", isLogged = true)
    @SessionCheckKeyword(checkIt = false)
    @RequestMapping(value = "/logout")
    public ModelAndView logout() throws ControllerException {
        log.debug("开始登出");
        Enumeration<String> eume = httpSession.getAttributeNames();
        while (eume.hasMoreElements()) {
            String name = eume.nextElement();
            httpSession.removeAttribute(name);
        }
        log.debug("登出完成");
        return new ModelAndView("/");
    }


    @BusinessMethod(value = "更新密码")
    @SessionCheckKeyword(checkIt = true)
    @PostMapping(value = "/modifyPassword")
    @ResponseBody
    public String modifyPassword(@RequestParam String newpassword) throws ControllerException{
        log.debug("需要修改成的密码是:{}",newpassword);
        String userName = (String) httpSession.getAttribute(ConfigHelper.getConfig().getString("System.SessionUserKeyword"));
        try {
            userService.modifyPassword(userName,newpassword);
        } catch (ServiceException e) {
            log.error(e.getMessage());
            throw new ControllerException(e.getMessage());
        }
        return HttpResponseHelper.successInfoInbox("密码修改成功！");
    }
}
