package com.example.ifamily.activity;

import java.util.ArrayList;
import java.util.List;

import com.example.ifamily.R;
import com.example.ifamily.SelectPicPopupWindow;
import com.example.ifamily.mywidget.BadgeView;
import com.example.ifamily.utils.FontManager;
import com.example.ifamily.utils.MyApplication;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class HolesMain extends FragmentActivity {
	private Button btnadd;
	private ViewPager mViewPager;
	private FragmentPagerAdapter mAdapter;
	private TextView title;
	private Button back;
	
	  private LinearLayout ll;
	  private PopupWindow  popupWindow;
	private List<Fragment> mFragments = new ArrayList<Fragment>();
	
	
	
	
	
	private Button atme;
	/**
	 * 顶部三个LinearLayout
	 */
	private LinearLayout mTabLiaotian;

	/**
	 * 顶部的三个TextView
	 */
	private TextView mLiaotian;
	private TextView mFaxian;

	/**
	 * 分别为每个TabIndicator创建一个BadgeView
	 */
	private BadgeView mBadgeViewforLiaotian;
	/**
	 * Tab的那个引导线
	 */
	private ImageView mTabLine;
	/**
	 * ViewPager的当前选中页
	 */
	private int currentIndex;
	/**
	 * 屏幕的宽度
	 */
	private int screenWidth;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.holes);
		MyApplication.getInstance().addActivity(this);
		initView();
		initTabLine();
		/**
		 * 初始化Adapter
		 */
		mAdapter = new FragmentPagerAdapter(getSupportFragmentManager())
		{
			@Override
			public int getCount()
			{
				return mFragments.size();
			}

			@Override
			public Fragment getItem(int arg0)
			{
				return mFragments.get(arg0);
			}
		};
		mViewPager.setAdapter(mAdapter);

		/**
		 * 设置监听
		 */
		mViewPager.setOnPageChangeListener(new OnPageChangeListener()
		{

			@Override
			public void onPageSelected(int position)
			{
				// 重置所有TextView的字体颜色
				resetTextView();
				switch (position)
				{
				case 0:

					mLiaotian.setTextColor(getResources().getColor(
							R.color.purple));
					break;
				case 1:
					mFaxian.setTextColor(getResources().getColor(R.color.purple));
					break;

				}

				currentIndex = position;
			}

			@Override
			public void onPageScrolled(int position, float positionOffset,
					int positionOffsetPixels)
			{
				LinearLayout.LayoutParams lp = (android.widget.LinearLayout.LayoutParams) mTabLine
						.getLayoutParams();
				/**
				 * 利用position和currentIndex判断用户的操作是哪一页往哪一页滑动
				 * 然后改变根据positionOffset动态改变TabLine的leftMargin
				 */
				if (currentIndex == 0 && position == 0)// 0->1
				{
					lp.leftMargin = (int) (positionOffset
							* (screenWidth * 1.0 / 2) + currentIndex
							* (screenWidth / 2));

				} else if (currentIndex == 1 && position == 0) // 1->0
				{
					lp.leftMargin = (int) (-(1 - positionOffset)
							* (screenWidth * 1.0 / 2) + currentIndex
							* (screenWidth / 2));

				} else if (currentIndex == 1 && position == 1) // 1->2
				{

					lp.leftMargin = (int) (positionOffset
							* (screenWidth * 1.0 / 2) + currentIndex
							* (screenWidth / 2));
				} else if (currentIndex == 2 && position == 1) // 2->1
				{
					lp.leftMargin = (int) (-(1 - positionOffset)
							* (screenWidth * 1.0 / 2) + currentIndex
							* (screenWidth / 2));
				}
				mTabLine.setLayoutParams(lp);

			}

			@Override
			public void onPageScrollStateChanged(int state)
			{
			}
		});

		mViewPager.setCurrentItem(0);
	}

	/**
	 * 根据屏幕的宽度，初始化引导线的宽度
	 */
	private void initTabLine()
	{
		mTabLine = (ImageView) findViewById(R.id.id_tab_line);
		DisplayMetrics outMetrics = new DisplayMetrics();
		getWindow().getWindowManager().getDefaultDisplay()
				.getMetrics(outMetrics);
		screenWidth = outMetrics.widthPixels;
		LinearLayout.LayoutParams lp = (android.widget.LinearLayout.LayoutParams) mTabLine
				.getLayoutParams();
		lp.width = screenWidth / 2;
		mTabLine.setLayoutParams(lp);
	}

	/**
	 * 重置颜色
	 */
	protected void resetTextView()
	{
		mLiaotian.setTextColor(getResources().getColor(R.color.black));
		mFaxian.setTextColor(getResources().getColor(R.color.black));

	}

	/**
	 * 初始化控件，初始化Fragment
	 */
	private void initView()
	{
		LinearLayout all=(LinearLayout)findViewById(R.id.all);//整个界面
		FontManager.changeFonts(all,this);
		atme=(Button)findViewById(R.id.btnatme);
		
		 atme.setOnClickListener(new OnClickListener()
		 {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(HolesMain.this,AtMeActivity.class);
				 startActivity(intent);
			
			}
			 
		 });
		
		
		 ll=(LinearLayout)findViewById(R.id.ll);
		btnadd=(Button)findViewById(R.id.btnAdd);
		 title = (TextView)findViewById(R.id.title);
		 back = (Button)findViewById(R.id.back);
		 title.setText("家庭树洞");
		 back.setOnClickListener(new OnClickListener()
		 {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				/*Intent intent=new Intent(OldObjectMain.this,Iguide.class);
				 startActivity(intent);
				 OldObjectMain.this.finish();*/
				HolesMain.this.finish();
			}
			 
		 });
		 btnadd.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub添加加号点击事件

					showwindow();
					
				}
				
			});
		
		
		mViewPager = (ViewPager) findViewById(R.id.vp_hole);

		mTabLiaotian = (LinearLayout) findViewById(R.id.id_tab_liaotian_ly);

		mLiaotian = (TextView) findViewById(R.id.id_liaotian);
		mLiaotian.setTextColor(getResources().getColor(
				R.color.purple));
		LinearLayout lm=(LinearLayout) findViewById(R.id.id_tab_liaotian_ly);
		lm.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mViewPager.setCurrentItem(0);
			}
			
		});
		mFaxian = (TextView) findViewById(R.id.id_faxian);
		LinearLayout lf=(LinearLayout) findViewById(R.id.id_tab_faxian_ly);
		lf.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mViewPager.setCurrentItem(1);
			}
			
		});

		Holeswish hm = new Holeswish();
		HolesSpeak hs = new HolesSpeak();
		mFragments.add(hm);
		mFragments.add(hs);

		mBadgeViewforLiaotian = new BadgeView(this);
		mTabLiaotian.addView(mBadgeViewforLiaotian);
		mBadgeViewforLiaotian.setVisibility(View.GONE);
	}		
	
	private void showwindow()
	{
		 if (popupWindow != null && popupWindow.isShowing()) {
				popupWindow.dismiss();
				popupWindow = null;

				}
		 RelativeLayout  layout = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.holes_add_item, null);  
			   popupWindow = new PopupWindow(ll);
			   LinearLayout addwish = (LinearLayout) layout
						.findViewById(R.id.add_wish);
				LinearLayout addtc = (LinearLayout) layout
						.findViewById(R.id.add_tc);
				addwish.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						Intent intent = new Intent(HolesMain.this,HolesAddWish.class);
				        startActivity(intent);
						popupWindow.dismiss();
						
						}
					
				});

				addtc.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						Intent intent = new Intent(HolesMain.this,HolesAddTc.class);
				        startActivity(intent);
						popupWindow.dismiss();
					}
				});
						   
		        popupWindow.setWidth(LayoutParams.WRAP_CONTENT);  
		        popupWindow.setHeight(LayoutParams.WRAP_CONTENT);  		    
		        popupWindow.setBackgroundDrawable(new BitmapDrawable());  
		        popupWindow.setOutsideTouchable(true);  
		        popupWindow.setFocusable(true);  
		        popupWindow.setContentView(layout);  
		        popupWindow.showAsDropDown(ll, 0, 0);  
	}
}
