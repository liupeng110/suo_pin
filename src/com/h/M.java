package com.h;

import android.app.*;
import android.app.admin.*;
import android.content.*;
import android.os.*;

public class M extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
		activiteDevice();
		}

	private void activiteDevice() {
		// 创建一个意图 , 动作 名称 ACTION_ADD_DEVICE_ADMIN
		Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
		ComponentName myadimin = new ComponentName(this, MyAdmin.class);
		intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, myadimin);
		//intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION,
						//"获取设备管理器,以便及时清理内存!");
		startActivityForResult(intent, 0);
	}
	
}
