package co.edu.ufps.web.service;

import co.edu.ufps.commons.Exception.ConverterException;
import co.edu.ufps.commons.Exception.ValidationException;
import co.edu.ufps.commons.ImageFormat;
import co.edu.ufps.core.ImageConverter;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class ServiceConverter {

    private ImageConverter converter = new ImageConverter();

    public File init(File image, String format) {
        converter.source(image);

        ImageFormat f1 = null;
        try {
            f1 = converter.metaDataMimeType(format);
        } catch (ValidationException e) {
            e.printStackTrace();
        }
        converter.setFolder("C:\\Users\\manue\\Desktop\\arquitectura-ufps\\temp\\");
        converter.defineFormat(f1);
        File imageOut = null;
        try {
            imageOut = converter.startProcess();
        } catch (ConverterException e) {
            e.printStackTrace();
        } catch (ValidationException e) {
            e.printStackTrace();
        }

        return imageOut;
    }

}
