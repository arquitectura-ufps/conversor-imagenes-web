# conversor-imagenes-web
Proyecto web el cual permite convertir tipos de imágenes (bmp, jpg, png, gif).

Se importaron los ciertos paquetes para crear y ejecutar la aplicacion fueron:

# Dependencias

Autowiring dependencias
Hacer uso del autowiring nos permite resolver dependencias de manera automática entre los bean de colaboración inspeccionando los bean que se han definido.

Hay cuatro modos diferentes de autowiring de un bean:

- no:  valor por defecto, no se realizará autowiring y habrá que decir de manera explicita el nombre de la dependencia.
- byName: se realizará autowiring en función del nombre de la propiedad, es decir, Spring buscará un bean con el mismo nombre de la propiedad que quiere setear.
- byType: es como el anterior solo que se basa en el tipo de la propiedad. Es decir, la única diferencia con el anterior es que Spring buscará un bean con el mismo tipo de la propiedad.
- constructor: el autowiring se realizará por constructor y Spring buscará beans con el mismo tipo de los argumentos del constructor.

Interoperability with java.nio.file package

The java.nio.file package defines interfaces and classes for the Java virtual machine to access files, file attributes, and file systems. This API may be used to overcome many of the limitations of the java.io.File class. The toPath method may be used to obtain a Path that uses the abstract path represented by a File object to locate a file. The resulting Path may be used with the Files class to provide more efficient and extensive access to additional file operations, file attributes, and I/O exceptions to help diagnose errors when an operation on a file fails.

Java.nio.file.Files:
This class consists exclusively of static methods that operate on files, directories, or other types of files.

In most cases, the methods defined here will delegate to the associated file system provider to perform the file operations.

Con este medolo se capturo los datos de la vista de los datos de la imagen tales como el nombre y la extencion para poder convertir el tipo de archivo con el capture nde error.


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

# Instalar Rquerimientos

Installing Apache Maven
The installation of Apache Maven is a simple process of extracting the archive and adding the `bin` folder with the `mvn` command to the `PATH`.
Detailed steps are:

- Ensure environment variable is set and points to your JDK installationJAVA_HOME
- Extract distribution archive in any directory

1. unzip apache-maven-3.6.3-bin.zip
o
1. tar xzvf apache-maven-3.6.3-bin.tar.gz
