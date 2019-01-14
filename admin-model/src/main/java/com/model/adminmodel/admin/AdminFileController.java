package com.model.adminmodel.admin;

import com.model.entitymodel.bean.Files;
import com.model.entitymodel.bean.Result;
import com.model.entitymodel.utils.FileUtils;
import com.model.entitymodel.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yrz
 */
@RestController
@Slf4j
@RequestMapping("/admin/file")
public class AdminFileController {

    /**
     * 文件详情
     * @param filePath
     * @return
     * @throws FileNotFoundException
     */
    @PostMapping("/info")
    public Result info(@RequestParam("file") String filePath) throws FileNotFoundException {
        String pathPrefix = ResourceUtils.getURL("classpath:").getPath();


        try {
            log.info("filePath:{}",pathPrefix + filePath);
            File file = new File(pathPrefix + filePath);
            log.info("fileMessage:{}" , file.canWrite());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResultUtils.success(pathPrefix + filePath , "读取成功");
    }

    /**
     * 单文件上传
     * @param file
     * @param request
     * @return
     */
    @PostMapping("/singleUpload")
    public Result singleUpload(@RequestParam(value = "singFile" , required = false)MultipartFile file , HttpServletRequest request) {

        Result result = FileUtils.singleUpload(file , request);
        return ResultUtils.success(result.getData() , "文件信息");
    }

    /**
     * 文件列表
     * @param path
     * @return
     * @throws IOException
     */
    @GetMapping("/list")
    public Map<String , Object> list(@RequestParam("file")String path) throws IOException {

        Map<String , Object> list = new LinkedHashMap<>();
        ArrayList<Files> files = new ArrayList<>();

        File file = new File(path);
        File[] tempList = file.listFiles();

        for (int i = 0; i < (tempList != null ? tempList.length : 0); i++) {
            Files f = new Files();
            f.setFileName(tempList[i].getName());
            f.setFileSize(tempList[i].length());
            if(tempList[i].isDirectory()){
                f.setFileType("dir");
            }else{
                Path paths = Paths.get(tempList[i].getAbsolutePath());
                log.info("type: {}",java.nio.file.Files.probeContentType(paths));
                f.setFileType(java.nio.file.Files.probeContentType(paths));
            }
            files.add(f);
        }

        list.put("list" , files);

        return list;
    }
}
