package cn.hzu.sotacy.service.impl.admin;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import cn.hzu.sotacy.model.Code;
import cn.hzu.sotacy.model.admin.Admin;
import cn.hzu.sotacy.dao.admin.AdminDao;
import cn.hzu.sotacy.response.ApiRestResponse;
import cn.hzu.sotacy.result.CodeResult;
import cn.hzu.sotacy.service.admin.AdminService;
import cn.hzu.sotacy.service.sms.SmsService;
import cn.hzu.sotacy.util.FormatCheckUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 作者
 * @since 2021-12-23
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminDao, Admin> implements AdminService {

    @Resource
    SmsService smsService;

    ApiRestResponse<Object> apiRestResponse;



    /**
     * 用户登录
     * @author Jasper Zhan
     * @date 2021/12/21 10:10
     * @param request 请求
     * @param response 回复
     * @return cn.hzu.dms.response.ApiRestResponse<cn.hzu.dms.result.CodeResult>
     */
    @Override
    public ApiRestResponse<Admin> login(HttpServletRequest request, HttpServletResponse response) {

        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        apiRestResponse = FormatCheckUtil.phoneCheck(phone);
        if (!apiRestResponse.isSuccess())
            return ApiRestResponse.fail(apiRestResponse.getCodeResult());

        apiRestResponse = FormatCheckUtil.passwordCheck(password);
        if (!apiRestResponse.isSuccess())
            return ApiRestResponse.fail(apiRestResponse.getCodeResult());

        QueryWrapper<Admin> wrapper = new QueryWrapper<>() ;
        wrapper.eq("phone", phone);
        Admin admin = getOne(wrapper);

        if (admin == null)
            return ApiRestResponse.fail(CodeResult.USER_NO_EXIST);

        if (!SaSecureUtil.md5(password).equals(admin.getPassword()))
            return ApiRestResponse.fail(CodeResult.PASSWORD_ERROR);

        StpUtil.login(admin.getId());
        return ApiRestResponse.success(CodeResult.SUCCESS_LOGIN);
    }

    /**
     * 用户注册
     * @author Jasper Zhan
     * @date 2021/12/21 19:58
     * @param request 请求
     * @param session 会话
     * @return cn.hzu.dms.response.ApiRestResponse<cn.hzu.dms.model.User>
     */
    @Override
    public ApiRestResponse<Object> register(HttpServletRequest request, HttpSession session) {

        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        apiRestResponse = FormatCheckUtil.phoneCheck(phone);
        if (!apiRestResponse.isSuccess())
            return apiRestResponse;

        ApiRestResponse<Code> codeApiRestResponse = smsService.checkCode(request, session);
        if (!codeApiRestResponse.isSuccess())
            return ApiRestResponse.fail(codeApiRestResponse.getCodeResult());

        QueryWrapper<Admin> wrapper = new QueryWrapper<>() ;
        wrapper.eq("phone", phone);
        Admin admin = getOne(wrapper);

        if (admin != null)
            return ApiRestResponse.fail(CodeResult.PHONE_REGISTERED);

        apiRestResponse = FormatCheckUtil.passwordCheck(password);
        if (!apiRestResponse.isSuccess())
            return apiRestResponse;


        admin = new Admin();
        admin.setPhone(phone);
        admin.setPassword(SaSecureUtil.md5(password));
        save(admin);

        return ApiRestResponse.success(CodeResult.SUCCESS_REGISTER, admin);
    }

    /**
     * 用户修改密码
     * @param request 请求
     * @param session 会话
     * @return cn.hzu.dms.response.ApiRestResponse<java.lang.Object>
     * @author Jasper Zhan
     * @date 2021/12/21 22:09
     */
    @Override
    public ApiRestResponse<Object> changePassword(HttpServletRequest request, HttpSession session) {

        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        apiRestResponse = FormatCheckUtil.phoneCheck(phone);
        if (!apiRestResponse.isSuccess())
            return apiRestResponse;

        apiRestResponse = FormatCheckUtil.passwordCheck(password);
        if (!apiRestResponse.isSuccess())
            return apiRestResponse;

        ApiRestResponse<Code> codeApiRestResponse = smsService.checkCode(request, session);
        if (!codeApiRestResponse.isSuccess())
            return ApiRestResponse.fail(codeApiRestResponse.getCodeResult());

        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>() ;
        queryWrapper.eq("phone", phone);
        Admin admin = getOne(queryWrapper);

        admin.setPassword(SaSecureUtil.md5(password));

        UpdateWrapper<Admin> wrapper = new UpdateWrapper<>();
        wrapper.eq("phone", phone);
        update(admin, wrapper);

        return ApiRestResponse.success(CodeResult.SUCCESS_CHANGE_PASSWORD);
    }
}
