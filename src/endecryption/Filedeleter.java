package endecryption;

import java.io.File;

public class Filedeleter {
	public static void detete (String pathtoformat) {
        String path= pathtoformat; 
        File file = new File(path);
        File[] files = file.listFiles(); 
        for (File f:files) 
        {
        	if (f.isFile() && f.exists()) 
            { 
        		f.delete();
        		System.out.println("successfully deleted");
        		}
        	else
        	{
        		System.out.println("cant delete a file due to open or error");
        		} 
        	}  
        }
	}


