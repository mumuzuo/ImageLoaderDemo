package com.z.imageloader;

import android.graphics.Bitmap;

/**
 * 图片缓存接口
 *
 * @author zuo
 * @date 2019/7/17 15:16
 */
public interface ImageCache {
    void put(String url, Bitmap bitmap);

    Bitmap get(String url);
}
