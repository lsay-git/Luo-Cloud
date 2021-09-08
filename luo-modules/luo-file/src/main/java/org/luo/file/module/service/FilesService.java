package org.luo.file.module.service;

import org.luo.file.module.entity.Files;
import com.baomidou.mybatisplus.extension.service.IService;
import org.luo.mp.base.BaseService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @Date 16:03 2021/6/3
 * @Description {
 *   FilesService
 * }
 * @Author lsay
 **/
public interface FilesService extends BaseService<Files> {

    HashMap<String, String> uploadImg(MultipartFile file);
}
