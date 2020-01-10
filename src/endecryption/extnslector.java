package endecryption;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;

public class extnslector {

	public static String extnslector(String extension) {

		String exten = null;

		String path = "D://java software//zip Tool'S//eclipse//p//CloudStorage//WebContent//PNG//";

		String files;
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {

			if (listOfFiles[i].isFile()) {
				files = listOfFiles[i].getName();
				if (files.endsWith(".png") || files.endsWith(".PNG")) {

					String fileNameWithOutExt = FilenameUtils
							.removeExtension(files);
				//	System.out.println(fileNameWithOutExt);
					if (fileNameWithOutExt.equals(extension))
						;
					{
						exten = "PNG//" + extension + ".png";
					}

				}
			}

		}
		return exten;
	}
}
