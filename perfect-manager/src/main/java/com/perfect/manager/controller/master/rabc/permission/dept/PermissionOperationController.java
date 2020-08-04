package com.perfect.manager.controller.master.rabc.permission.dept;

import com.perfect.bean.pojo.result.JsonResult;
import com.perfect.bean.result.utils.v1.ResultUtil;
import com.perfect.bean.vo.master.rabc.permission.operation.OperationMenuDataVo;
import com.perfect.bean.vo.master.rabc.permission.operation.OperationMenuVo;
import com.perfect.common.annotations.SysLogAnnotion;
import com.perfect.core.service.master.rabc.permission.operation.IMPermissionOperationService;
import com.perfect.framework.base.controller.v1.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhangxh
 */
@RestController
@RequestMapping(value = "/api/v1/permission/operation")
@Slf4j
@Api("权限操作")
public class PermissionOperationController extends BaseController {

    @Autowired
    private IMPermissionOperationService service;

    @SysLogAnnotion("根据查询条件，获取部门权限操作数据")
    @ApiOperation("根据查询条件，获取部门权限操作数据")
    @PostMapping("/dept/list")
    @ResponseBody
    public ResponseEntity<JsonResult<OperationMenuVo>> list(@RequestBody(required = false) OperationMenuDataVo searchCondition) {
        searchCondition.setTenant_id(super.getUserSessionTenantId());
        OperationMenuVo entity = service.getTreeData(searchCondition);
        return ResponseEntity.ok().body(ResultUtil.OK(entity));
    }
}
