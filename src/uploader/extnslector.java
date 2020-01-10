package uploader;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;

public class extnslector {
	
	
	
	public String extnslector(String extension) {

		String exten = null;

		

		String files;
		File folder = new File(path.path+"//PNG");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {

			if (listOfFiles[i].isFile()) {
				files = listOfFiles[i].getName();
				if (files.endsWith(".png") || files.endsWith(".PNG")) {

					String fileNameWithOutExt = FilenameUtils
							.removeExtension(files);
				//	System.out.println(fileNameWithOutExt);
					if (extension.toLowerCase().endsWith(fileNameWithOutExt.toLowerCase()))
					{
						exten = "PNG//" + fileNameWithOutExt + ".png";
					}

				}
			}

		}
		return exten;
	}

}
