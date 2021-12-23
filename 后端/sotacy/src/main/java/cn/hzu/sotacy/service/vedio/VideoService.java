package cn.hzu.sotacy.service.vedio;

import cn.hzu.sotacy.model.vedio.Video;
import cn.hzu.sotacy.response.ApiRestResponse;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 作者
 * @since 2021-12-23
 */
public interface VideoService extends IService<Video> {

    /**
     * 添加视频
     * @author Jasper Zhan
     * @date 2021/12/23 14:56
     * @param request 请求
     * @param response 回复
     * @return cn.hzu.sotacy.response.ApiRestResponse<cn.hzu.sotacy.model.vedio.Video>
     */
    ApiRestResponse<Video> addVideo(HttpServletRequest request, HttpServletResponse response);
}
