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

	//�ӻ����ļ��ж�ȡͼƬ
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
	//���ļ����浽���浽�ļ����С�
	public static void saveImageToCache(String imageName, InputStream imageStream,Context context){
		
		// �齨�����ļ�������·��
				File fullFile = getFileFromFullPath(imageName,context);

				try {

					//�����ļ�д����
					FileOutputStream fos = new FileOutputStream(fullFile);
					byte[] bytes = new byte[1024];
					
					int len = 0;
					
					while((len = imageStream.read(bytes)) != -1){
						System.out.println(len);
						fos.write(bytes);
					}

					//�رն�ȡ��
					imageStream.close();
					//�ر��ļ�д����
					fos.close();

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

	}
	//��·����ȡ·������
	public static File getFileFromFullPath(String imageName,Context context) {
		// ���Ӧ�ó�����µ�CacheĿ¼
				File file = context.getCacheDir();
				String fullFilePath = file.getPath() + "/" + imageName;
				// �齨�����ļ�������·��
				File fullFile = new File(fullFilePath);

				return fullFile;
		
	}
	//�ж�ͼƬ�ڱ��ػ����ļ����Ƿ����
	public static boolean isImageExistedInLocalCache(String imageName,Context context) {
		File fullFile = getFileFromFullPath(imageName,context);
		// �жϷ���
		return fullFile.exists();
		
	}
	
}
