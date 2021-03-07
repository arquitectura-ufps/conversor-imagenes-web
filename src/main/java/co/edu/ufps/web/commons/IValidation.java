package co.edu.ufps.web.commons;

import co.edu.ufps.commons.Exception.ValidationException;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.stream.ImageInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public interface IValidation {

    default String getMimeType(File image) throws ValidationException {
        try {
            ImageInputStream iis = ImageIO.createImageInputStream(image);
            Iterator<ImageReader> readers = ImageIO.getImageReaders(iis);
            if (readers.hasNext()) {
                ImageReader reader = readers.next();
                reader.setInput(iis, true);
                IIOMetadata metadata = reader.getImageMetadata(0);
                String[] names = metadata.getMetadataFormatNames();
                String[] attribute = names[0].split("_");
                return attribute[2];
            }
        } catch (IOException e) {
            throw new ValidationException("Error: No se pudo leer la imagen");
        }
        throw new ValidationException("Error: No se detecto Metadata mime Type");
    }

    default ImageFormat metaDataMimeType(String mimeType) throws ValidationException {
        switch (mimeType) {
            case "bmp": return ImageFormat.BMP;
            case "png": return ImageFormat.PNG;
            case "gif": return ImageFormat.GIF;
            case "jpeg": return ImageFormat.JPG;
            default: throw new ValidationException("Error: tipo de imagen no permitida");
        }
    }

}
