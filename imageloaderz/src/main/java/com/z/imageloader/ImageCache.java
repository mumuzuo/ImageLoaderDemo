package com.z.imageloader;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * 图片缓存类
 *
 * @author zuo
 * @date 2019/7/17 15:16
 */
public class ImageCache {
    //图片缓存
    private LruCache<String, Bitmap> mImageCache;

    public ImageCache() {
        initImageCache();
    }

    /**
     * 初始化图片缓存，创建LruCache对象，设置缓存大小，获取缓存图片大小
     */
    private void initImageCache() {
        //计算可使用的最大内存
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        //取四分之一的可用内存作为缓存
        final int cacheSize = maxMemory / 8;
        /**
         * ①设置LruCache缓存的大小，一般为当前进程可用容量的1/8。
         * ②重写sizeOf方法，计算出要缓存的每张图片的大小。
         */
        mImageCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight() / 1024;
            }
        };
    }

    public void put(String url, Bitmap bitmap) {
        if (mImageCache == null) {
            initImageCache();
        }
        mImageCache.put(url, bitmap);
    }

    public Bitmap get(String url) {
        Bitmap bitmap = null;
        if (mImageCache != null) {
            bitmap = mImageCache.get(url);
        }
        return bitmap;
    }

}
