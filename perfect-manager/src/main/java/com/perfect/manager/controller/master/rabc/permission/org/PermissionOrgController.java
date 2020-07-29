package com.perfect.manager.controller.master.rabc.permission.org;

import com.perfect.bean.pojo.result.JsonResult;
import com.perfect.bean.result.utils.v1.ResultUtil;
import com.perfect.bean.vo.master.org.MOrgTreeVo;
import com.perfect.common.annotations.SysLogAnnotion;
import com.perfect.core.service.master.rabc.permission.org.IMPermissionOrgService;
import com.perfect.framework.base.controller.v1.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author zhangxh
 */
@RestController
@RequestMapping(value = "/api/v1/permission/org")
@Slf4j
@Api("权限类页面左侧的树")
public class PermissionOrgController extends BaseController {

    @Autowired
    private IMPermissionOrgService service;

    @Autowired
    private RestTemplate restTemplate;

    @SysLogAnnotion("根据查询条件，获取组织机构信息")
    @ApiOperation("获取组织机构树数据")
    @PostMapping("/tree/dept/list")
    @ResponseBody
    public ResponseEntity<JsonResult<List<MOrgTreeVo>>> treeList(@RequestBody(required = false) MOrgTreeVo searchCondition) {
        List<MOrgTreeVo> vo = service.getTreeList(searchCondition);
        return ResponseEntity.ok().body(ResultUtil.OK(vo));
    }
}
