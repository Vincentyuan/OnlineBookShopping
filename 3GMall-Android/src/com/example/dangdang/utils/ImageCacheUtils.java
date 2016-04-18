package com.example.dangdang.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class ImageCacheUtils {

	//从缓存文件中读取图片
	public static Bitmap getBitmapFromCache(String imageName,Context context){
		File fullFile = getFileFromFullPath(imageName,context);

		try {
			InputStream is = new FileInputStream(fullFile);
			Bitmap bitmap = BitmapFactory.decodeStream(is);
			is.close();
			return bitmap;
		} catch (FileNotFoundException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
		
	}
	//将文件保存到缓存到文件夹中。
	public static void saveImageToCache(String imageName, InputStream imageStream,Context context){
		
		// 组建包含文件的完整路径
				File fullFile = getFileFromFullPath(imageName,context);

				try {

					//创建文件写入流
					FileOutputStream fos = new FileOutputStream(fullFile);
					byte[] bytes = new byte[1024];
					
					int len = 0;
					
					while((len = imageStream.read(bytes)) != -1){
						System.out.println(len);
						fos.write(bytes);
					}

					//关闭读取流
					imageStream.close();
					//关闭文件写入流
					fos.close();

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

	}
	//按路径获取路径对象
	public static File getFileFromFullPath(String imageName,Context context) {
		// 获得应用程序的下的Cache目录
				File file = context.getCacheDir();
				String fullFilePath = file.getPath() + "/" + imageName;
				// 组建包含文件的完整路径
				File fullFile = new File(fullFilePath);

				return fullFile;
		
	}
	//判断图片在本地缓存文件夹是否存在
	public static boolean isImageExistedInLocalCache(String imageName,Context context) {
		File fullFile = getFileFromFullPath(imageName,context);
		// 判断发挥
		return fullFile.exists();
		
	}
	
}
