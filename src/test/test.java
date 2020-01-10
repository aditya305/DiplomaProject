package test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserDefinedFileAttributeView;

public class test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		get();
	}

	public static void insert(String value, String filePath) throws IOException {

		final Path fakeobjectfile = Paths.get(filePath);

		final UserDefinedFileAttributeView view = Files.getFileAttributeView(
				fakeobjectfile, UserDefinedFileAttributeView.class);

		// The file attribute
		final String name = "Reciver";
		// final String value = "shailesh";

		// // Write the properties
		final byte[] bytes = value.getBytes("UTF-8");
		final ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
		writeBuffer.put(bytes);
		writeBuffer.flip();
		view.write(name, writeBuffer);

	}

	public static void get() throws IOException {
		final Path file = Paths.get("C:\\Users\\shailesh\\Downloads\\filedownloder.jpg");
		final UserDefinedFileAttributeView view = Files.getFileAttributeView(
				file, UserDefinedFileAttributeView.class);
		// The file attribute
		final String findername = "Reciver";
		// Read the property
		final ByteBuffer readBuffer = ByteBuffer
				.allocate(view.size(findername));
		view.read(findername, readBuffer);
		readBuffer.flip();
		final String valueFromAttributes = new String(readBuffer.array(),
				"UTF-8");
		System.out.println("File Attribute: " + valueFromAttributes);
	}

}
