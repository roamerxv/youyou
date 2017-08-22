package pers.roamer.youyou.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pers.roamer.boracay.aspect.businesslogger.BusinessMethod;
import pers.roamer.boracay.aspect.httprequest.SessionCheckKeyword;
import pers.roamer.boracay.helper.HttpResponseHelper;
import pers.roamer.boracay.helper.JsonUtilsHelper;
import pers.roamer.youyou.entity.ApproveTypeEntity;
import pers.roamer.youyou.entity.LivingTypeEntity;
import pers.roamer.youyou.entity.ParkingInfoEntity;
import pers.roamer.youyou.entity.ParkingTypeEntity;
import pers.roamer.youyou.service.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author roamer - 徐泽宇
 * @create 2017-08-2017/8/1  下午6:31
 */
@Controller("pers.roamer.youyou.controller.UserController")
@Log4j2
@RequestMapping( value = "/parking_infos")
public class UserController extends BaseController {

    @Autowired
    ParkingInfoService parkingInfoService;

    @Autowired
    LivingTypeService livingTypeService;

    @Autowired
    ParkingTypeService parkingTypeService;

    @Autowired
    ApproveTypeService approveTypeService;


    /**
     * 显示所有的车位登记信息
     *
     * @return
     *
     * @throws ControllerException
     */
    @BusinessMethod(value = "查询车位列表")
    @SessionCheckKeyword(checkIt = false)
    @GetMapping(value = "/")
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
     * 获取审核状态的的 json 对象
     *
     * @return
     *
     * @throws ControllerException
     */
    @GetMapping(value = "/approve_type")
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
    @PostMapping(value = "")
    @BusinessMethod(value = "增加一条车位登记信息")
    @ResponseBody
    public String add(@RequestBody ParkingInfoEntity parkingInfoEntity) throws ControllerException {

        try {
            String userName = "!!!!";
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
    @DeleteMapping(value = "/{id}")
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
    @GetMapping(value = "/{id}")
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
    @PutMapping("/{id}")
    @ResponseBody
    public String updateParkingInfo(@RequestBody ParkingInfoEntity parkingInfoEntity) throws ControllerException{
        try {
            log.debug("更新一条记录:"+JsonUtilsHelper.objectToJsonString(parkingInfoEntity));
            String userName = "!!!!";
            parkingInfoEntity.setUpdatedBy(userName);
            parkingInfoService.update(parkingInfoEntity);
        } catch (JsonProcessingException | ServiceException e) {
            log.error(e.getMessage());
        }
        return HttpResponseHelper.successInfoInbox("更新成功");
    }
}
