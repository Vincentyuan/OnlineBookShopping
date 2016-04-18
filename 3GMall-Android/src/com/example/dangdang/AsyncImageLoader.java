package com.example.dangdang;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;

public class AsyncImageLoader {

	 private HashMap<String, SoftReference<Drawable>> imageCache;
	  
	     public AsyncImageLoader() {
	    	 imageCache = new HashMap<String, SoftReference<Drawable>>();
	     }
	  
	     public Drawable loadDrawable(final String localurl,final String weburl, final ImageCallback imageCallback) {
	         if (imageCache.containsKey(localurl)) {
	             SoftReference<Drawable> softReference = imageCache.get(localurl);
	             Drawable drawable = softReference.get();
	             if(new File(localurl).exists())
	             {
	            	 //»Ù¥Ê‘⁄
	            	 
	             }else
	             {
	            	 //»Ù≤ª¥Ê‘⁄
	             }
	             if (drawable != null) {
	                 return drawable;
	             }
	         }
	         final Handler handler = new Handler() {
	             public void handleMessage(Message message) {
	                 imageCallback.imageLoaded((Drawable) message.obj, localurl);
	             }
	         };
	         new Thread() {
	             @Override
	             public void run() {
	                 Drawable drawable = loadImageFromUrl(localurl);
	                 imageCache.put(localurl, new SoftReference<Drawable>(drawable));
	                 Message message = handler.obtainMessage(0, drawable);
	                 handler.sendMessage(message);
	             }
	         }.start();
	         return null;
	     }
	  
		public static Drawable loadImageFromUrl(String url) {
			URL m;
			InputStream i = null;
			try {
				m = new URL(url);
				i = (InputStream) m.getContent();
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Drawable d = Drawable.createFromStream(i, "src");
			return d;
		}
	  
	     public interface ImageCallback {
	         public void imageLoaded(Drawable imageDrawable, String imageUrl);
	     }

}

