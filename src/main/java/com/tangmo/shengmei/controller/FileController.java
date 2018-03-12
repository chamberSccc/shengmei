package com.tangmo.shengmei.controller;

import com.tangmo.shengmei.controller.base.BaseController;
import com.tangmo.shengmei.utility.code.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
     * @api {POST} /upload/{userId} 上传用户图片
     * @apiGroup User
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
}
