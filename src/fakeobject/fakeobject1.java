package fakeobject;

import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserDefinedFileAttributeView;

public class fakeobject1 {

  public static void main(final String[] args) throws Exception {
    final Path file = Paths.get("C:\\Users\\Sumit\\Desktop\\Enhance-E-Learning - Copy.rar");

    final UserDefinedFileAttributeView view = Files.getFileAttributeView(file, UserDefinedFileAttributeView.class);

    // The file attribute
    final String name = "Reciver";
    final String value = "Sumit";

//    // Write the properties
    final byte[] bytes = value.getBytes("UTF-8");
    final ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
    writeBuffer.put(bytes);
    writeBuffer.flip();
    view.write(name, writeBuffer);

    // Read the property
    final ByteBuffer readBuffer = ByteBuffer.allocate(view.size(name));
    view.read(name, readBuffer);
    readBuffer.flip();
    final String valueFromAttributes = new String(readBuffer.array(), "UTF-8");
    System.out.println("File Attribute: " + valueFromAttributes);
  }
}