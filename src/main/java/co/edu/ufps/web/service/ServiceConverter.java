import co.edu.ufps.commons.ConverterException;
import co.edu.ufps.commons.ImageFormat;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public interface IConverter {
	
	
    default File start(File image, ImageFormat formatEnd, String destination) throws ConverterException {
        switch (formatEnd) {
            case PNG: return run(image, "png", destination);
            case GIF: return run(image, "gif", destination);
            case JPG: return run(image, "jpg", destination);
            case BMP: return run(image, "bmp", destination);
            default: throw new ConverterException("Error al convertir imagen: formato no valido");
        }
    }

    default File run(File image, String formatName, String destination) throws ConverterException {
        File imageEnd = new File(destination + "." + formatName);
        try {
            BufferedImage bufferedImage = ImageIO.read(image);
            ImageIO.write(bufferedImage, formatName, imageEnd);
            return imageEnd;
        } catch (IOException e) {
            throw new ConverterException("Error al convertir imagen: " + e.getMessage());
        }
    }
}
