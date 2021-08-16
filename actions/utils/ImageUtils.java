package utils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;

public class ImageUtils {

	public static String getBase64StringFromImage(String fileSource) throws IOException{
		byte[] fileContent = FileUtils.readFileToByteArray(new File(fileSource));
		return Base64.getEncoder().encodeToString(fileContent);
	}
}
