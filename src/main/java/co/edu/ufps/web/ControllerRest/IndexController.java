package co.edu.ufps.web.ControllerRest;

import co.edu.ufps.web.service.ServiceConverter;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class IndexController {

    private final Logger log = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private ServiceConverter serviceConverter;

    @PostMapping("/converter")
    public ResponseEntity<Resource> converter(@RequestParam("image")MultipartFile image, @RequestParam("ext")String ext){
        byte[]bytesImg = null;
        try {
            bytesImg = image.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File destination = new File("C:\\Users\\manue\\Desktop\\arquitectura-ufps\\temp\\");
            if (destination.isDirectory()) {
                destination.mkdir();
            }
            Path rutaCompleta = Paths.get("C:\\Users\\manue\\Desktop\\arquitectura-ufps\\temp\\" + image.getOriginalFilename());
            Files.write(rutaCompleta, bytesImg);
        } catch (IOException e) {
            e.printStackTrace();
        }

        File imageOut = serviceConverter.init(new File("C:\\Users\\manue\\Desktop\\arquitectura-ufps\\temp\\" + image.getOriginalFilename()), ext);

        Path filePath = Paths.get(imageOut.getAbsolutePath());

        Resource resource = null;
        try {
            resource = new UrlResource(filePath.toUri());
            if(!resource.exists()) {
                log.error("error: no se encontro el archivo");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        HttpHeaders headers = new HttpHeaders();
        try {
            headers.add("Content-disposition", String.format("attachment;filename=%s", resource.getFilename()));
            headers.setContentLength(resource.contentLength());
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        } catch (IOException ex) {
            log.error("Content-Type", ex);
        }
        return ResponseEntity.ok().headers(headers).body(resource);
    }



}
