package com.example.ifamily.utils;

import java.util.Set;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePreferenceUtil
{
	public static final String MESSAGE_NOTIFY_KEY = "message_notify";
	public static final String MESSAGE_SOUND_KEY = "message_sound";
	public static final String SHOW_HEAD_KEY = "show_head";
	public static final String PULLREFRESH_SOUND_KEY = "pullrefresh_sound";
	private SharedPreferences sp;
	private SharedPreferences.Editor editor;

	public SharePreferenceUtil(Context context, String file)
	{
		sp = context.getSharedPreferences(file, Context.MODE_PRIVATE);
		editor = sp.edit();
	}

	// appid
	public void setAppId(String appid)
	{
		// TODO Auto-generated method stub
		editor.putString("appid", appid);
		editor.commit();
	}

	public String getAppId()
	{
		return sp.getString("appid", "");
	}

	public void setGroupId(Set<String> set)
	{
		editor.putStringSet("GroupIds", set);
		editor.commit();
	}
	
	public Set<String> getGroupId()
	{
		return sp.getStringSet("GroupIds", null);
	}
	
	// user_id
	public void setUserId(String userId)
	{
		editor.putString("userId", userId);
		editor.commit();
	}

	public String getUserId()
	{
		return sp.getString("userId", "");
	}

	// channel_id
	public void setChannelId(String ChannelId)
	{
		editor.putString("ChannelId", ChannelId);
		editor.commit();
	}

	public String getChannelId()
	{
		return sp.getString("ChannelId", "");
	}

	// nick
	public void setNick(String nick)
	{
		editor.putString("nick", nick);
		editor.commit();
	}

	public String getNick()
	{
		return sp.getString("nick", "");
	}

	// ͷ��ͼ��
	public int getHeadIcon()
	{
		return sp.getInt("headIcon", 0);
	}

	public void setHeadIcon(int icon)
	{
		editor.putInt("headIcon", icon);
		editor.commit();
	}

	// ����Tag
	public void setTag(String tag)
	{
		editor.putString("tag", tag);
		editor.commit();
	}

	public String getTag()
	{
		return sp.getString("tag", "");
	}

	// �Ƿ�֪ͨ
	public boolean getMsgNotify()
	{
		return sp.getBoolean(MESSAGE_NOTIFY_KEY, true);
	}

	public void setMsgNotify(boolean isChecked)
	{
		editor.putBoolean(MESSAGE_NOTIFY_KEY, isChecked);
		editor.commit();
	}

	// ����Ϣ�Ƿ�������
	public boolean getMsgSound()
	{
		return sp.getBoolean(MESSAGE_SOUND_KEY, true);
	}

	public void setMsgSound(boolean isChecked)
	{
		editor.putBoolean(MESSAGE_SOUND_KEY, isChecked);
		editor.commit();
	}

	// ˢ���Ƿ�������
	public boolean getPullRefreshSound()
	{
		return sp.getBoolean(PULLREFRESH_SOUND_KEY, true);
	}

	public void setPullRefreshSound(boolean isChecked)
	{
		editor.putBoolean(PULLREFRESH_SOUND_KEY, isChecked);
		editor.commit();
	}

	// �Ƿ���ʾ�Լ�ͷ��
	public boolean getShowHead()
	{
		return sp.getBoolean(SHOW_HEAD_KEY, true);
	}

	public void setShowHead(boolean isChecked)
	{
		editor.putBoolean(SHOW_HEAD_KEY, isChecked);
		editor.commit();
	}

	// ���鷭ҳЧ��
	public int getFaceEffect()
	{
		return sp.getInt("face_effects", 3);
	}

	public void setFaceEffect(int effect)
	{
		if (effect < 0 || effect > 11)
			effect = 3;
		editor.putInt("face_effects", effect);
		editor.commit();
	}
}
