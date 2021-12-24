package cn.hzu.sotacy.service.admin;

import cn.hzu.sotacy.model.admin.Admin;
import cn.hzu.sotacy.response.ApiRestResponse;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 作者
 * @since 2021-12-23
 */
public interface AdminService extends IService<Admin> {
    /**
     * 管理员登录
     * @author Jasper Zhan
     * @date 2021/12/21 10:10
     * @param request 请求
     * @param response 回复
     * @return cn.hzu.dms.response.ApiRestResponse<cn.hzu.dms.model.User>
     */
    ApiRestResponse<Admin> login(HttpServletRequest request, HttpServletResponse response);

    /**
     * 管理员注册
     * @author Jasper Zhan
     * @date 2021/12/21 19:58
     * @param request 请求
     * @param session 会话
     * @return cn.hzu.dms.response.ApiRestResponse<cn.hzu.dms.model.User>
     */
    ApiRestResponse<Object> register(HttpServletRequest request, HttpSession session);

    /**
     * 管理员修改密码
     * @author Jasper Zhan
     * @date 2021/12/21 22:09
     * @param request 请求
     * @param session 会话
     * @return cn.hzu.dms.response.ApiRestResponse<java.lang.Object>
     */
    ApiRestResponse<Object> changePassword(HttpServletRequest request, HttpSession session);
}
