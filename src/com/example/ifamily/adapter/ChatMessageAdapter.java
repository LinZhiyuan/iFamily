package com.example.ifamily.adapter;

import java.util.List;

import com.example.ifamily.R;
import com.example.ifamily.bean.ChatMessage;
import com.example.ifamily.mywidget.RoundImageView;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ChatMessageAdapter extends BaseAdapter
{
	private LayoutInflater mInflater;
	private List<ChatMessage> mDatas;

	public ChatMessageAdapter(Context context, List<ChatMessage> datas)
	{
		mInflater = LayoutInflater.from(context);
		mDatas = datas;
	}

	@Override
	public int getCount()
	{
		return mDatas.size();
	}

	@Override
	public Object getItem(int position)
	{
		return mDatas.get(position);
	}

	@Override
	public long getItemId(int position)
	{
		return position;
	}

	@Override
	public int getItemViewType(int position)
	{
		ChatMessage msg = mDatas.get(position);
		return msg.isComing() ? 1 : 0;
	}

	@Override
	public int getViewTypeCount()
	{
		return 2;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		ChatMessage chatMessage = mDatas.get(position);

		ViewHolder viewHolder = null;

		if (convertView == null)
		{
			viewHolder = new ViewHolder();
			if (chatMessage.isComing())
			{
				convertView = mInflater.inflate(R.layout.main_chat_from_msg,
						parent, false);
				viewHolder.createDate = (TextView) convertView
						.findViewById(R.id.chat_from_createDate);
				viewHolder.content = (TextView) convertView
						.findViewById(R.id.chat_from_content);
				viewHolder.nickname = (TextView) convertView
						.findViewById(R.id.chat_from_name);
				viewHolder.headIcon = (RoundImageView) convertView
						.findViewById(R.id.chat_from_icon);
				
				convertView.setTag(viewHolder);
			} else
			{
				convertView = mInflater.inflate(R.layout.main_chat_send_msg,
						null);
				viewHolder.createDate = (TextView) convertView
						.findViewById(R.id.chat_send_createDate);
				viewHolder.content = (TextView) convertView
						.findViewById(R.id.chat_send_content);
				viewHolder.nickname = (TextView) convertView
						.findViewById(R.id.chat_send_name);
				viewHolder.headIcon = (RoundImageView) convertView
						.findViewById(R.id.chat_send_icon);
				convertView.setTag(viewHolder);
			}

		} else
		{
			viewHolder = (ViewHolder) convertView.getTag();
		}
//		Date date = chatMessage.getDate();
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		viewHolder.content.setText(chatMessage.getMessage());
		viewHolder.createDate.setText(chatMessage.getDateStr());
		viewHolder.nickname.setText(chatMessage.getNickname());
		viewHolder.headIcon.setImageBitmap((Bitmap)chatMessage.getIcon());
	//	viewHolder.headIcon.setidandtype(mDatas.get(position-1).getid(),1);
		//////////////����id

		return convertView;
	}

	private class ViewHolder
	{
		public TextView createDate;
		public TextView nickname;
		public TextView content;
		public RoundImageView headIcon;
	}

}
