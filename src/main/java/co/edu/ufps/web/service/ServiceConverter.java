package co.edu.ufps.web.service;

import co.edu.ufps.commons.Converter;
import co.edu.ufps.commons.ImageFormat;
import co.edu.ufps.core.ImageConverter;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class ServiceConverter {

    private Converter converter;

    public ServiceConverter() {
        converter = new ImageConverter();
    }

    public File run() {
        return null;
    }

}
