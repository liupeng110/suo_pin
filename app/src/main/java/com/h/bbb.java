package com.h;

import android.content.*;

public class bbb extends BroadcastReceiver
{

	@Override
	public void onReceive(Context p1, Intent p2)
	{
		if(p2.getAction().equals("android.intent.action.BOOT_COMPLETED"))
		{
			abortBroadcast();
			Intent intt=new Intent(p1,s.class);
			intt.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			
			p1.startService(intt);
			
		}
	}

}
