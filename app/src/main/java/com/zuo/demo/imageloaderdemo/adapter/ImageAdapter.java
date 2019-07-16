package com.zuo.demo.imageloaderdemo.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.z.imageloader.ImageLoader;
import com.zuo.demo.imageloaderdemo.R;
import com.zuo.demo.imageloaderdemo.databinding.ItemImageViewBinding;

import java.util.List;

/**
 * 首页图片适配器
 *
 * @author zuo
 * @date 2019/7/16 15:14
 */
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    private Context context;
    private List<String> imageList;
    private ImageLoader imageLoader;

    public ImageAdapter(Context context, List<String> imageList, ImageLoader imageLoader) {
        this.context = context;
        this.imageList = imageList;
        this.imageLoader = imageLoader;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_image_view, parent, false);
        binding.getRoot().setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        ViewHolder viewHolder = new ViewHolder(binding.getRoot());
        viewHolder.setBinding(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String path = imageList.get(position);
        ViewDataBinding binding = holder.getBinding();
        ((ItemImageViewBinding) binding).imageText.setText(path);
        imageLoader.displayImage(path, ((ItemImageViewBinding) binding).imageView);
        binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return imageList == null ? 0 : imageList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ViewDataBinding binding;

        ViewDataBinding getBinding() {
            return binding;
        }

        void setBinding(ViewDataBinding binding) {
            this.binding = binding;
        }

        ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
