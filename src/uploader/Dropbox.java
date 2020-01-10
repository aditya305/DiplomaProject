package uploader;

import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.files.UploadErrorException;
import com.dropbox.core.v2.users.FullAccount;

import java.util.List;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;

public class Dropbox {
	private static final String ACCESS_TOKEN = "-sirKJwMg5AAAAAAAAAA24XwyqKgJQCk_j1TAJaGmjD3XW8jof8WLSKQsE8uVuvE";

	public static void main(String args[]) throws DbxException, IOException {
	}

	public static void fileUpload_to_dropbox(String src, String des) {
		DbxRequestConfig config = new DbxRequestConfig("dropbox/java-tutorial",
				"en_US");
		DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

		try (InputStream in = new FileInputStream(src)) {
			FileMetadata metadata = client.files().uploadBuilder(des)
					.uploadAndFinish(in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UploadErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DbxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void fileDownalod_from_dropbox(String src, String des) {

		try {
			DbxRequestConfig config = new DbxRequestConfig(
					"dropbox/java-tutorial", "en_US");
			DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
			DbxDownloader<FileMetadata> downloader = client.files().download(src);
			FileOutputStream out = new FileOutputStream(des);
			downloader.download(out);
			out.close();
		} catch (DbxException ex) {
			System.out.println(ex.getMessage());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
