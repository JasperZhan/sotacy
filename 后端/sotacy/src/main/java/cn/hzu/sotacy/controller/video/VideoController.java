package cn.hzu.sotacy.controller.video;


import cn.hzu.sotacy.model.vedio.Video;
import cn.hzu.sotacy.response.ApiRestResponse;
import cn.hzu.sotacy.service.vedio.VideoService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 作者
 * @since 2021-12-23
 */
@RestController
@RequestMapping("/video")
public class VideoController {

    @Resource
    VideoService videoService;

    @ResponseBody
    @RequestMapping("/add")
    ApiRestResponse<Video> addVideo(HttpServletRequest request, HttpServletResponse response) {
        return videoService.addVideo(request, response);
    }
}
