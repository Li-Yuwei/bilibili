package com.hotbitmapgg.ohmybilibili.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.base.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.model.home.Body;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hcc on 16/8/4 14:12
 * 100332338@qq.com
 */
public class HomeRecommendedGridAdapter extends AbsRecyclerViewAdapter
{

    List<Body> bodys = new ArrayList<>();

    public HomeRecommendedGridAdapter(RecyclerView recyclerView, List<Body> bodys)
    {

        super(recyclerView);
        this.bodys = bodys;
    }

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.item_home_recommended_grid, parent, false));
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position)
    {

        if (holder instanceof ItemViewHolder)
        {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            Body body = bodys.get(position);
            Picasso.with(getContext())
                    .load(Uri.parse(body.getCover()))
                    .placeholder(R.drawable.bili_default_image_tv)
                    .into(itemViewHolder.mVideoImg);
            itemViewHolder.mVideoTitle.setText(body.getTitle());
            itemViewHolder.mVideoPlayNum.setText(body.getPlay());
            itemViewHolder.mVideoReviewCount.setText(body.getDanmaku());
        }
        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount()
    {

        return bodys.size();
    }

    public class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder
    {

        public ImageView mVideoImg;

        public TextView mVideoTitle;

        public TextView mVideoPlayNum;

        public TextView mVideoReviewCount;

        public ItemViewHolder(View itemView)
        {

            super(itemView);
            mVideoImg = $(R.id.video_preview);
            mVideoTitle = $(R.id.video_title);
            mVideoPlayNum = $(R.id.video_play_num);
            mVideoReviewCount = $(R.id.video_review_count);
        }
    }
}