package com.tangmo.shengmei.controller;

import com.tangmo.shengmei.controller.base.BaseController;
import com.tangmo.shengmei.utility.code.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author boge
 * @date 18/1/5
 * @description 文件控制层
 */
@RestController
@RequestMapping("/file")
public class FileController extends BaseController{

    /**
     * @api {GET} /file/read/{rfId} 附件查看
     * @apiGroup Resource
     * @apiVersion 0.0.1
     * @apiDescription 查看文件,需要传输文件id, 返回ResponseEntity<byte[]>
     * @apiParam {String} rfId 文件id
     * @apiParamExample {uri} 请求样例:
     *                   /file/read/d5540ff2db804a8daf1050a06679155f
     */
    @GetMapping("/read/{rfId}")
    public ResponseEntity<byte[]> readFile(@PathVariable String rfId){
        String userAgent = this.getRequest().getHeader("USER-AGENT");
        return imgFileService.downloadFile(rfId, userAgent);
    }

    /**
     * 播放视频
     * @param response
     * @param rfId
     */
    @GetMapping("/video/{rfId}")
    public void playVideo(HttpServletRequest request,HttpServletResponse response,@PathVariable String rfId){
        imgFileService.playVideo(request,response, rfId);
    }


    public void player2(HttpServletRequest request, HttpServletResponse response){String path  = request.getServletPath();
//        path = path.replaceAll("/crm/player", "");
//        String recordPath = "";
//        if(path.contains("ivr")){
//            recordPath = System.getProperty("app");
//        }else{
//            recordPath=ConfigFactory.getString(CommonConstants.RECORD_PATH); //硬盘存放路径
//        }
//        path = recordPath+path;


    }




    /**
     * @api {POST} /file/upload/{userId} 上传用户图片
     * @apiGroup File
     * @apiVersion 0.0.1
     * @apiDescription 上传用户图片
     * @apiParamExample {json} 请求样例:
     *                   {
     *                      file:"图片文件",
     *                   }
     * @apiSuccess (success) {POST} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     * @apiSuccess (success) {POST} data 返回数据
     * @apiSuccessExample {json} 返回样例:
     *                    {"code":"success"}
     */
    @PostMapping("/upload/{userId}")
    public Result loadFeedbackImg(@PathVariable Integer userId, MultipartFile file){
        return imgFileService.uploadImg(userId,file);
    }

    @PostMapping("/video/upload/{userId}")
    public String loadVideo(@PathVariable Integer userId, MultipartFile file){
        Result result = imgFileService.uploadImg(userId,file);
        String code = result.getCode();
        if(code.equals("success")){
            return result.getData().toString();
        }else{
            return null;
        }
    }
}
