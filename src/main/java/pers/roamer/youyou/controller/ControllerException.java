/**
 * @Title: ControllerException.java
 * @Package com.ninelephas.terrier.controller
 * @Description: 系统的Controller下的Exception基类
 *               Copyright: Copyright (c) 2016
 *               Company:九象网络科技（上海）有限公司
 * 
 * @author 徐泽宇
 * @date 2016年10月13日 下午4:03:04
 * @version V1.0.0
 */

package pers.roamer.youyou.controller;

import org.springframework.validation.BindingResult;
import pers.roamer.youyou.ProjectException;

/**
 * @ClassName: ControllerException
 * @Description: 系统的Controller下的Exception基类
 * @author 徐泽宇
 * @date 2016年10月13日 下午4:03:04
 *
 */

public class ControllerException extends ProjectException {

    /**
     * 
     * 创建一个新的实例 ControllerException.
     * 
     * @Auther 徐泽宇
     * @Date 2016年11月2日 下午3:36:53
     * @param message
     */
     public ControllerException(String message){
         super(message);
     }
    /**
     * 
     * 创建一个新的实例 ControllerException.
     * 
     * @Auther 徐泽宇
     * @Date 2016年11月4日 下午12:50:57
     * @param bindingResult
     */
    public ControllerException(BindingResult bindingResult) {
        super(bindingResult);
    }
}
