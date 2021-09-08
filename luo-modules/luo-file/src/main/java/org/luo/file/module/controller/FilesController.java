package org.luo.file.module.controller;

import org.luo.core.domain.R;
import org.luo.file.module.service.FilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

/**
 * @Date 16:05 2021/6/3
 * @Description {
 *   FilesController
 * }
 * @Author lsay
 **/
@RestController
@RequestMapping
public class FilesController {

    @Autowired
    private FilesService filesService;

    @PostMapping("/uploadImg")
    public R<HashMap<String, String>> uploadImg(MultipartFile file){
        return R.ok(filesService.uploadImg(file));
    }

}
