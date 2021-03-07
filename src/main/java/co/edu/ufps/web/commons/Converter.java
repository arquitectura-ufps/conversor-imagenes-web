package co.edu.ufps.web.commons;

import co.edu.ufps.commons.Exception.ConverterException;
import co.edu.ufps.commons.Exception.ValidationException;

import java.io.File;

public interface Converter {
    public void defineFormatImages(ImageFormat formatInit, ImageFormat formatEnd);
    public void source(File image);
    public void setFolder(String folder);
    public void setName(String nameFile);
    public String validateMimeType() throws ValidationException;
    public ImageFormat validateMetaDataMineType(String mimeType);
    public File startProcess() throws ConverterException;
}
