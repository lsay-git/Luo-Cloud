package org.luo.file.module.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.luo.core.exception.ServiceException;
import org.luo.core.tool.utils.ArithmeticUtils;
import org.luo.file.common.enums.FileSuffixEnum;
import org.luo.file.common.enums.FileTypeEnum;
import org.luo.file.module.entity.Files;
import org.luo.file.module.mapper.FilesMapper;
import org.luo.file.module.service.FilesService;
import org.luo.mp.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;

/**
 * @Date 16:03 2021/6/3
 * @Description {
 *   FilesServiceImpl
 * }
 * @Author lsay
 **/
@Service
public class FilesServiceImpl extends BaseServiceImpl<FilesMapper, Files> implements FilesService{

    /**
     * 图片文件地址
     */
    @Value("${files.picture}")
    private String picturePath;
    /**
     * 视频文件地址
     */
    @Value("${files.video}")
    private String videoPath;
    /**
     * 其他文件地址
     */
    @Value("${files.other}")
    private String otherPath;
    /**
     * 文件回显地址前缀
     */
    @Value("${fileUrl.static}")
    private String staticUrlPath;
    /**
     * 文件下载地址前缀
     */
    @Value("${fileUrl.down}")
    private String downUrlPath;

    private static final int SIZE = 1024;

    @Override
    public HashMap<String, String> uploadImg(MultipartFile file) {

        if(file.isEmpty()){
            throw new ServiceException("上传文件为空");
        }

        // 获取原文件名称
        String fileName = file.getOriginalFilename();
        // 获取文件后缀
        String fileSuffix = checkFileSuffix(fileName);
        // 获取文件大小 kb
        Double fileSize = ArithmeticUtils.divide((double) file.getSize(), (double) SIZE,4);
        // 获取文件类型
        int fileType = FileTypeEnum.PICTURE.getType();

        Files files = new Files();
        files.setName(fileName);
        files.setSuffix(fileSuffix);
        files.setSize(fileSize);
        files.setType(fileType);
        super.save(files);

        // 文件储存路径
        String path = picturePath+"/"+files.getId()+files.getSuffix();
        // 获取文件回显地址
        String staticUrl = staticUrlPath+"/"+FileTypeEnum.PICTURE.getCode()+"/"+files.getId()+files.getSuffix();
        //todo 获取文件下载地址
        String downUrl = "";
        super.update(new LambdaUpdateWrapper<Files>()
                .set(Files::getPath,path)
                .set(Files::getStaticUrl,staticUrl)
                .set(Files::getDownUrl,downUrl)
                .eq(Files::getId,files.getId()));

        try {
            copy(file.getInputStream(),path);
        } catch (IOException e) {
            throw new ServiceException("文件上传异常");
        }
        HashMap<String,String> resultMap = new HashMap<>(1);
        resultMap.put("url",staticUrl);
        return resultMap;
    }

    /**
     * 保存文件到服务器
     * @param is 文件字节流
     * @param path 文件保存路径
     */
    public void copy(InputStream is,String path){
        FileInputStream fis;
        try {
            if(is instanceof FileInputStream){

                // 1.从FileInputStream对象获取文件通道FileChannel
                fis = (FileInputStream) is;
                FileChannel rChannel = fis.getChannel();

                File file = new File(path);
                if(!file.getParentFile().exists()){
                    file.getParentFile().mkdirs();
                }
                FileChannel wChannel = new FileOutputStream(file,true).getChannel();

                // 2.从通道读取文件内容
                ByteBuffer byteBuffer = ByteBuffer.allocate(SIZE);
                int length = rChannel.read(byteBuffer);
                while(length != -1){
                    byteBuffer.flip();//读取模式转换写入模式
                    wChannel.write(byteBuffer);
                    byteBuffer.clear(); //清空缓存，等待下次写入
                    // 再次读取文本内容
                    length = rChannel.read(byteBuffer);
                }

                // 关闭通道和文件流
                is.close();
                fis.close();
                rChannel.close();
                wChannel.close();

            }else {
                throw new ServiceException("文件流转换异常");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new ServiceException("文件服务异常");
        }
    }

    public String checkFileSuffix(String fileName){
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
        String suffix = "";
        if(FileSuffixEnum.IMG_JPG.getLower().equals(fileSuffix)){
            suffix = FileSuffixEnum.IMG_JPG.getLower();
        }else if(FileSuffixEnum.IMG_JPG.getUpper().equals(fileSuffix)){
            suffix = FileSuffixEnum.IMG_JPG.getUpper();
        }else if(FileSuffixEnum.IMG_PNG.getLower().equals(fileSuffix)){
            suffix = FileSuffixEnum.IMG_PNG.getLower();
        }else if(FileSuffixEnum.IMG_PNG.getUpper().equals(fileSuffix)){
            suffix = FileSuffixEnum.IMG_PNG.getUpper();
        }else if(FileSuffixEnum.IMG_GIF.getLower().equals(fileSuffix)){
            suffix = FileSuffixEnum.IMG_GIF.getLower();
        }else if(FileSuffixEnum.IMG_GIF.getUpper().equals(fileSuffix)){
            suffix = FileSuffixEnum.IMG_GIF.getUpper();
        }
        return suffix;
    }

}
