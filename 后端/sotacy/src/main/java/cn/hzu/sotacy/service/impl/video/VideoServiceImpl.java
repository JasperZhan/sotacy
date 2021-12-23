package cn.hzu.sotacy.service.impl.video;

import cn.hzu.sotacy.model.vedio.Video;
import cn.hzu.sotacy.dao.video.VideoDao;
import cn.hzu.sotacy.response.ApiRestResponse;
import cn.hzu.sotacy.result.CodeResult;
import cn.hzu.sotacy.service.vedio.VideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 作者
 * @since 2021-12-23
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoDao, Video> implements VideoService {

    /**
     * 添加视频
     * @param request  请求
     * @param response 回复
     * @return cn.hzu.sotacy.response.ApiRestResponse<cn.hzu.sotacy.model.vedio.Video>
     * @author Jasper Zhan
     * @date 2021/12/23 14:56
     */
    @Override
    public ApiRestResponse<Video> addVideo(HttpServletRequest request, HttpServletResponse response) {

        String courseUnitId = request.getParameter("courseUnitId");
        String url = request.getParameter("url");
        String name = request.getParameter("name");
        String describe = request.getParameter("describe");

        Video video = new Video();

        if (courseUnitId == null)
            return ApiRestResponse.fail(CodeResult.EMPTY_COURSE_UNIT_ID);

        video.setCourseUnitId(Integer.valueOf(courseUnitId));

        if (url == null)
            return ApiRestResponse.fail(CodeResult.EMPTY_VIDEO_URL);

        video.setUrl(url);

        if (name == null)
            return ApiRestResponse.fail(CodeResult.EMPTY_VIDEO_NAME);

        video.setName(name);

        video.setDescribe(describe);

        save(video);

        return ApiRestResponse.success(CodeResult.SUCCESS_ADD_VIDEO, video);
    }
}
