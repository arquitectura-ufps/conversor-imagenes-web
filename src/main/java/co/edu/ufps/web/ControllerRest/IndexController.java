package co.edu.ufps.web.ControllerRest;

import co.edu.ufps.web.service.ServiceConverter;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

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

import javax.servlet.http.HttpServletRequest;

@RestController
public class IndexController {

    private final Logger log = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private ServiceConverter serviceConverter;

    @CrossOrigin("*")
    @GetMapping("/image/{fileName:.+}")
    public ResponseEntity<Resource> image(@PathVariable String fileName, HttpServletRequest request) {

        //System.out.println("file name: " + fileName);
        String ruta = new File (".").getAbsolutePath ();
        ruta = ruta.substring(0, ruta.length()-1);
        // Load file as Resource
        Resource resource = null;
        try {
            Path filePath = Paths.get( ruta + fileName);
            //System.out.println("ruta: " + filePath.toUri());
            resource = new UrlResource(filePath.toUri());
            //resource = new UrlResource(filePath.toUri());
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

    @CrossOrigin("*")
    @PostMapping("/converter")
    public ResponseEntity<String> converter(@RequestParam("image")MultipartFile image, @RequestParam("ext")String ext){

        byte[]bytesImg = null;
        try {
            bytesImg = image.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println (new File (".").getAbsolutePath ());
        String ruta = new File (".").getAbsolutePath ();
        ruta = ruta.substring(0, ruta.length()-1);
        try {
            //File destination = new File("C:\\Users\\manue\\Desktop\\arquitectura-ufps\\temp\\");

            File destination = new File(ruta + "\\");
            if (destination.isDirectory()) {
                destination.mkdir();
            }
            //Path rutaCompleta = Paths.get("C:\\Users\\manue\\Desktop\\arquitectura-ufps\\temp\\" + image.getOriginalFilename());
            Path rutaCompleta = Paths.get(ruta + "\\" + image.getOriginalFilename());
            Files.write(rutaCompleta, bytesImg);
        } catch (IOException e) {
            e.printStackTrace();
        }

        File imageOut = serviceConverter.init(new File(ruta + "\\" + image.getOriginalFilename()), ext, ruta);

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
        //return ResponseEntity.ok().headers(headers).body(resource);
        return ResponseEntity.ok("{\"data\":  { \"url\":\"" + resource.getFilename() + "\"}}");
    }

}
