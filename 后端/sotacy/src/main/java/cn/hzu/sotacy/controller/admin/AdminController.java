package cn.hzu.sotacy.controller.admin;


import cn.dev33.satoken.stp.StpUtil;
import cn.hzu.sotacy.model.Code;
import cn.hzu.sotacy.model.admin.Admin;
import cn.hzu.sotacy.response.ApiRestResponse;
import cn.hzu.sotacy.result.CodeResult;
import cn.hzu.sotacy.service.admin.AdminService;
import cn.hzu.sotacy.service.sms.SmsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 作者
 * @since 2021-12-23
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource
    AdminService adminService;

    @Resource
    SmsService smsService;

    @ResponseBody
    @PostMapping("/login")
    public ApiRestResponse<Admin> login(HttpServletRequest request, HttpServletResponse response) {
        return adminService.login(request, response);
    }

    @ResponseBody
    @PostMapping("/register")
    public ApiRestResponse<Object> register(HttpServletRequest request, HttpSession session) {
        return adminService.register(request, session);
    }

    @ResponseBody
    @PostMapping("/logout")
    public ApiRestResponse<Object> logout(HttpServletRequest request, HttpServletResponse response) {
        StpUtil.logout();
        return ApiRestResponse.success(CodeResult.SUCCESS_LOGOUT);
    }

    @ResponseBody
    @RequestMapping("/getCode")
    public ApiRestResponse<Code> getCode(HttpServletRequest request, HttpSession session) {
        return smsService.sendCode(request, session);
    }

    @ResponseBody
    @PostMapping("/changePassword")
    public ApiRestResponse<Object> changePassword(HttpServletRequest request, HttpSession session) {
        return adminService.changePassword(request, session);
    }
}
