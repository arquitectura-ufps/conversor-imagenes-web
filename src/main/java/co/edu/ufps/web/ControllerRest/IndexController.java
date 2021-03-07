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
    public String converter(File image, ImageFormat formatEnd) {
    	serviceConverter.start(image, formatEnd);
        serviceConverter.run(image, formatEnd);
        return "Good day";
    }
    
    

}
