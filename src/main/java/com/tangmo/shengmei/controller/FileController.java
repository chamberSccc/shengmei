package com.tangmo.shengmei.controller;

import com.tangmo.shengmei.controller.base.BaseController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author boge
 * @date 18/1/5
 * @description 文件控制层
 */
@RestController
@RequestMapping("/file")
public class FileController extends BaseController{

    /**
     * @api {GET} /resource/read/{rfId} 附件查看
     * @apiGroup Resource
     * @apiVersion 0.0.1
     * @apiDescription 查看文件,需要传输文件id, 返回ResponseEntity<byte[]>
     * @apiParam {String} rfId 文件id
     * @apiParamExample {uri} 请求样例:
     *                   /resource/download/d5540ff2db804a8daf1050a06679155f/cv
     */
    @GetMapping("/read/{rfId}")
    public ResponseEntity<byte[]> readFile(@PathVariable String rfId){
        String userAgent = this.getRequest().getHeader("USER-AGENT");
        return imgFileService.downloadFile(rfId, userAgent);
    }
}
