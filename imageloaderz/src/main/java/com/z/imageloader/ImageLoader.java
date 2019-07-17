package com.z.imageloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 图片加载类
 *
 * @author zuo
 * @date 2018/12/6 16:37
 */
public class ImageLoader {

    //图片缓存
    private ImageCache mImageCache = new ImageCache();
    //线程池，线程数量为cpu的核数
    ExecutorService mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    /**
     * 展示网络图片,同时异步去下载
     *
     * @param url
     * @param imageView
     */
    public void displayImage(final String url, final ImageView imageView) {
        imageView.setTag(url);
        if (mImageCache != null && mImageCache.get(url) != null) {
            imageView.setImageBitmap(mImageCache.get(url));
            return;
        }
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = downloadImage(url);
                if (bitmap == null) {
                    return;
                }
                if (imageView.getTag().equals(url)) {
                    imageView.setImageBitmap(bitmap);
                }
                mImageCache.put(url, bitmap);
            }
        });
    }

    /**
     * 下载图片
     *
     * @param imageUrl
     * @return
     */
    public Bitmap downloadImage(String imageUrl) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            InputStream inputStream = conn.getInputStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
