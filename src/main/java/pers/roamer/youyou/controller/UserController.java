package pers.roamer.youyou.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.roamer.boracay.aspect.businesslogger.BusinessMethod;
import pers.roamer.boracay.aspect.httprequest.SessionCheckKeyword;
import pers.roamer.boracay.helper.HttpResponseHelper;
import pers.roamer.boracay.helper.JsonUtilsHelper;
import pers.roamer.youyou.entity.LivingTypeEntity;
import pers.roamer.youyou.entity.ParkingInfoEntity;
import pers.roamer.youyou.entity.ParkingTypeEntity;
import pers.roamer.youyou.service.LivingTypeService;
import pers.roamer.youyou.service.ParkingInfoService;
import pers.roamer.youyou.service.ParkingTypeService;
import pers.roamer.youyou.service.ServiceException;

import java.util.ArrayList;
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


    /**
     * 显示所有的车位登记信息
     *
     * @return
     *
     * @throws ControllerException
     */
    @BusinessMethod(value = "查询车位信息")
    @SessionCheckKeyword(checkIt = false)
    @GetMapping(value = "/parking_infos")
    @ResponseBody
    public String showParkingInfo() throws ControllerException {
        List<ParkingInfoEntity> parkingInfoEntityList = new ArrayList<ParkingInfoEntity>();
        try {
            HashMap hashMap = new HashMap();
            String m_rtn = "";
            try {
                hashMap.put("data", parkingInfoEntityList = parkingInfoService.findAll());
                m_rtn = JsonUtilsHelper.objectToJsonString(hashMap);
            } catch (JsonProcessingException e) {
                log.error(e.getStackTrace());
            }
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
    @GetMapping(value = "/living_type")
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
     * 获取现有停车证类型的 json 对象
     *
     * @return
     *
     * @throws ControllerException
     */
    @GetMapping(value = "/parking_type")
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
    @PostMapping(value = "/parking_info")
    @BusinessMethod(value = "增加一条车位登记信息")
    @ResponseBody
    public String add(@RequestBody ParkingInfoEntity parkingInfoEntity) throws ControllerException {
        log.debug("开始保存一条停车场信息,登记日期是:{}", parkingInfoEntity.getRegisterDate());
        try {
            String userName = "!!!!";
            parkingInfoEntity.setCreatedBy(userName);
            parkingInfoEntity.setUpdatedBy(userName);
            parkingInfoService.add(parkingInfoEntity);
            return HttpResponseHelper.successInfoInbox("操作成功");
        } catch (ServiceException e) {
            throw new ControllerException(e.getMessage());
        }
    }
}
