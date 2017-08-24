<%--
  Created by IntelliJ IDEA.
  User: roamer
  Date: 2017/8/8
  Time: 下午12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>

<script src="<%=request.getContextPath()%>/assets/js/parking_info/add.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/parking_info/add.css"/>

<script src="<%=request.getContextPath()%>/assets/js/lib/moment-2.18.1/moment.min.js"></script>

<form class="am-form" id="frm"  target="nm_iframe" onsubmit="fun_submit()"  ng-app="youyou">
    <fieldset>
        <div class="panel panel-default">
            <div class="panel-heading">停车位信息登记
                    <input class="btn btn-success btn-save" type="submit" value="保存"/>
            </div>
        </div>

        <div class="panel panel-default">
            <div class="panel-heading">车位基本信息</div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="input-group">
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon input-span">单元号</span>
                                <%@ include file="../modules/_building_no.jsp" %>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="input-group">
                            <div class="input-group input-group-sm ">
                                <span class="input-group-addon input-span">门牌号(格式:0101)</span>
                                <input type="text" class="form-control" placeholder="门牌号" id="room_no" ng-model="room_no"
                                       name="room_no" aria-describedby="room_no" required="required"
                                       maxlength="4">
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2">
                        <div class="input-group">
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon input-span" id="sizing-addon3">居住类型</span>
                                <%@ include file="../modules/_living_type.jsp" %>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-2">
                        <div class="input-group">
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon input-span" id="sizing-addon6">停车位类型</span>
                                <%@ include file="../modules/_parking_type.jsp" %>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-1">
                        <div class="input-group">
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon input-span" id="sizing-addon3">停车位号</span>
                                <input type="text" class="form-control" placeholder=""
                                       aria-describedby="sizing-addon3"  id="parking_no" style="width: 40px"
                                       maxlength="2">
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2">
                        <div class="input-group">
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon input-span" id="sizing-addon6">车牌号</span>
                                <input type="text" class="form-control" id="car_no"  placeholder="输入车牌号"
                                       aria-describedby="sizing-addon6"  required="required" style="width: 150px"
                                       maxlength="8">
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="input-group">
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon input-span" id="sizing-addon6">车位登记时间</span>
                                <input type="date" class="form-control edit-input" id="register_date" placeholder=""
                                       aria-describedby="sizing-addon6" 
                                       maxlength="18">
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2">
                        <div class="input-group">
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon input-span" id="sizing-addon3">审核状态</span>
                                <%@ include file="../modules/_approve_type.jsp" %>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-3">
                        <div class="input-group">
                            <div class="input-group input-group-sm ">
                                <span class="input-group-addon input-span">联系电话</span>
                                <input type="text" class="form-control" placeholder="联系电话" id="contact_mobile" ng-model="contact_mobile"
                                       name="contact_mobile" aria-describedby="contact_mobile"
                                       maxlength="18">
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2">
                        <div class="input-group">
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon input-span" id="sizing-addon3">排队位置:第</span>
                                <input type="number" min="0" step="1" class="form-control" placeholder="" id="line_order" ng-model="line_order"
                                       name="line_order" aria-describedby="line_order"
                                       maxlength="4">
                                <span class="input-group-addon input-span" id="sizing-addon3">号</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="panel panel-default">
            <div class="panel-heading">产证信息</div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-lg-4">
                        <div class="input-group">
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon input-span" id="sizing-addon3">产证号:沪房地（闵）字（</span>
                                <input type="text" class="form-control edit-input" placeholder=""
                                       aria-describedby="sizing-addon3"  style="width:60px" id="property_cert_1"
                                       maxlength="4">
                                <span class="input-group-addon input-span" id="sizing-addon3">）第（</span>
                                <input type="text" class="form-control edit-input" placeholder=""
                                       aria-describedby="sizing-addon3"  style="width: 90px" id="property_cert_2"
                                       maxlength="6">
                                <span class="input-group-addon input-span" id="sizing-addon3">）号</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="input-group">
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon input-span" id="sizing-addon6">登记日期</span>
                                <input type="date" class="form-control edit-input" placeholder=""
                                       aria-describedby="sizing-addon6"  ID="property_cert_register_at"
                                       maxlength="18">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4">
                        <div class="input-group">
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon input-span" id="sizing-addon3">产证所有人(和车辆行驶证对应)</span>
                                <input type="text" class="form-control" placeholder="输入姓名"
                                       aria-describedby="sizing-addon3" id="property_owner"
                                       maxlength="10">
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="input-group">
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon input-span" id="sizing-addon6">产证所有人证件号</span>
                                <input type="text" class="form-control" placeholder="输入证件号"
                                       aria-describedby="sizing-addon6" id="property_owner_cid"
                                       maxlength="18">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div class="panel panel-default">
            <div class="panel-heading">行驶证信息</div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="input-group">
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon input-span" id="sizing-addon3">行驶证号</span>
                                <input type="text" class="form-control" placeholder="输入行驶证号"
                                       aria-describedby="sizing-addon3"  style="width: 220px" id="driving_license_no"
                                       maxlength="18">
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2">
                        <div class="input-group">
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon input-span" id="sizing-addon6">行驶证登记日期</span>
                                <input type="date" class="form-control" placeholder=""
                                       aria-describedby="sizing-addon6" id="driving_license_register_at"
                                       maxlength="18">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-2">
                        <div class="input-group">
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon input-span" id="sizing-addon3">车辆所有人</span>
                                <input type="text" class="form-control" placeholder="输入名字"
                                       aria-describedby="sizing-addon3"  id="driving_license_owner"
                                       maxlength="10">
                            </div>
                        </div>
                    </div>
                    <div class="">
                        <div class="input-group">
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon input-span" id="sizing-addon20">备注</span>
                                <textarea class="form-control" rows="3" id="comment"></textarea>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </fieldset>

</form>

<iframe id="id_iframe" name="nm_iframe" style="display:none;"></iframe>

</body>
