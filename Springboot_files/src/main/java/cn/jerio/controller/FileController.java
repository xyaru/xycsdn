package cn.jerio.controller;

import cn.jerio.domain.File;
import cn.jerio.service.FileService;
import cn.jerio.util.MD5Util;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

/**
 * Created by Franky on 2018/08/02.
 */
@CrossOrigin(origins = "*", maxAge = 3600) // 允许所有域名访问
@Controller
@RequestMapping("/file")
public class FileController {

    @Autowired
    FileService fileService;

//    @Value("${server.address}")
    private String serverAddress = "www.jerio.cn";

    @Value("${server.port}")
    private String serverPort;

    private MongoTemplate mongoTemplate;

    /**
     * 获取文件片信息
     *
     * @param id
     * @return
     * @throws UnsupportedEncodingException
     */
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Object> serveFile(@PathVariable String id) throws UnsupportedEncodingException {

        Optional<File> file = fileService.findById(id);

        if (file.isPresent()) {
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=" + new String(file.get().getName().getBytes("utf-8"),"ISO-8859-1"))
                    .header(HttpHeaders.CONTENT_TYPE, "application/octet-stream")
                    .header(HttpHeaders.CONTENT_LENGTH, file.get().getSize() + "").header("Connection", "close")
                    .body(file.get().getContent().getData());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File was not fount");
        }

    }

    /**
     * 在线显示文件
     *
     * @param id
     * @return
     */
    @GetMapping("/view/{id}")
    @ResponseBody
    public ResponseEntity<Object> serveFileOnline(@PathVariable String id) {

        Optional<File> file = fileService.findById(id);

        if (file.isPresent()) {
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "fileName=\"" + file.get().getName() + "\"")
                    .header(HttpHeaders.CONTENT_TYPE, file.get().getContentType())
                    .header(HttpHeaders.CONTENT_LENGTH, file.get().getSize() + "").header("Connection", "close")
                    .body(file.get().getContent().getData());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File was not fount");
        }

    }


    @GetMapping(value = "/file/image/{id}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    @ResponseBody
    public byte[] image(@PathVariable String id){
        byte[] data = null;
        File file = mongoTemplate.findById(id,File.class);
        if(file != null){
            data = file.getContent().getData();
        }
        return data;
    }
    /**
     * 上传
     *
     * @param file
     * @param redirectAttributes
     * @return
     */
    @PostMapping
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

        try {
            File f = new File(file.getOriginalFilename(), file.getContentType(), file.getSize(),
                    new Binary(file.getBytes()));
            f.setMd5(MD5Util.getMD5(file.getInputStream()));
            fileService.saveFile(f);
        } catch (IOException | NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "Your " + file.getOriginalFilename() + " is wrong!");
            return "redirect:/";
        }

        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }

    /**
     * 上传接口
     *
     * @param file
     * @return
     */
    @PostMapping("/upload")
    @ResponseBody
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        File returnFile = null;
        try {
            File f = new File(file.getOriginalFilename(), file.getContentType(), file.getSize(),
                    new Binary(file.getBytes()));
            f.setMd5(MD5Util.getMD5(file.getInputStream()));
            returnFile = fileService.saveFile(f);
            String path = "//" + serverAddress + ":" + serverPort + "/file/view/" + returnFile.getId();
            return ResponseEntity.status(HttpStatus.OK).body(path);

        } catch (IOException | NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }

    }

    /**
     * 删除文件
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteFile(@PathVariable String id) {

        try {
            fileService.removeFile(id);
            return ResponseEntity.status(HttpStatus.OK).body("DELETE Success!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
