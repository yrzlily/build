package com.model.entitymodel.utils;

import com.model.entitymodel.bean.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Objects;
import java.util.UUID;

/**
 * @author yrz
 */
@Slf4j
public class FileUtils {

    private static final String FILEPATH = "/static/upload/";

    /**
     * 单文件上传
     * @param file
     * @param request
     * @return
     */
    public static Result singleUpload(MultipartFile file , HttpServletRequest request){

        String filePath;

        try {
            String pathPrefix = ResourceUtils.getURL("classpath:").getPath();
            File pathDir = new File(pathPrefix);

            log.info("path: {}",pathPrefix);
            File dir = new File(pathDir.getAbsolutePath() , FILEPATH);
            if(!dir.exists()){
                dir.mkdir();
            }

            String suffix = file.getOriginalFilename().substring(Objects.requireNonNull(file.getOriginalFilename()).lastIndexOf("."));
            String fileName = UUID.randomUUID() + suffix;

            File serverFile = new File(dir + "/" + fileName);
            filePath = fileName;
            log.info("fileMessage:{}",serverFile);
            file.transferTo(serverFile);

        }catch (Exception e){
            e.printStackTrace();
            return ResultUtils.error(e.getMessage());
        }

        return ResultUtils.success(FILEPATH + filePath , "上传成功");
    }

}
