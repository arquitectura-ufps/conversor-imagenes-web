package co.edu.ufps.web.ControllerRest;

import co.edu.ufps.commons.ImageFormat;
import co.edu.ufps.web.service.ServiceConverter;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private ServiceConverter serviceConverter;

    //@RequestMapping(value = "", method = RequestMethod.POST, headers="Content-Type=multipart/form-data")
    //@PostMapping("/converter")
    @GetMapping("/converter")

    public String converter(){
//    public String converter(String inputImagePath, String outputImagePath, String formatName) {
        serviceConverter.run();

//        FileInputStream inputStream = new FileInputStream(inputImagePath);
//        FileOutputStream outputStream = new FileOutputStream(outputImagePath);
        // reads input image from file
//        BufferedImage inputImage = ImageIO.read(inputStream);

        // writes to the output image in specified format
//        boolean result = ImageIO.write(inputImage, formatName, outputStream);

        // needs to close the streams
//        outputStream.close();
//        inputStream.close();

//        return result;
          return "Imagen";

    }



}
