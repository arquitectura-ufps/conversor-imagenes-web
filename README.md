# conversor-imagenes-web
Proyecto web el cual permite convertir tipos de imágenes (bmp, jpg, png, gif).

Se importaron los ciertos paquetes para crear y ejecutar la aplicacion fueron:

Interoperability with java.nio.file package

The java.nio.file package defines interfaces and classes for the Java virtual machine to access files, file attributes, and file systems. This API may be used to overcome many of the limitations of the java.io.File class. The toPath method may be used to obtain a Path that uses the abstract path represented by a File object to locate a file. The resulting Path may be used with the Files class to provide more efficient and extensive access to additional file operations, file attributes, and I/O exceptions to help diagnose errors when an operation on a file fails.

Java.nio.file.Files:
This class consists exclusively of static methods that operate on files, directories, or other types of files.

In most cases, the methods defined here will delegate to the associated file system provider to perform the file operations.

Con este medolo se capturo los datos de la vista de los datos de la imagen tales como el nombre y la extencion para poder convertir el tipo de archivo con el capture nde error.

public File init(File image, String format, String folder) {
    converter.source(image);

    ImageFormat f1 = null;
    try {
        f1 = converter.metaDataMimeType(format);
    } catch (ValidationException e) {
        e.printStackTrace();
    }
    //converter.setFolder("C:\\Users\\manue\\Desktop\\arquitectura-ufps\\temp\\");
    converter.setFolder(folder);
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

Java.io.IOException:
Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed or interrupted I/O operations.

IOException()
Constructs an IOException with null as its error detail message.

IOException(String message)
Constructs an IOException with the specified detail message.

IOException(String message, Throwable cause)
Constructs an IOException with the specified detail message and cause.

IOException(Throwable cause)
Constructs an IOException with the specified cause and a detail message of (cause==null ? null : cause.toString()) (which typically contains the class and detail message of cause).
