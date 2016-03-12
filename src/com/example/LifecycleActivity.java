package com.example;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LifecycleActivity extends Activity {
	
	private static final String TAG="LifeCycleActivity";
	private Context context=this;
	private int param=1;
	//Activity创建时调用
	@SuppressLint("InlinedApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.i(TAG,"onCreate valled");
		setContentView(R.layout.activity_main);
		//setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//竖屏
		//setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER_LANDSCAPE);//横屏设置
		Button btn=(Button)findViewById(R.id.btn);
		btn.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(context,TargetActivity.class);
				startActivity(intent);
			}
		});
	}
	//Activity创建或者从后台重新回到前台是被调用
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.i(TAG,"onStart called");
	}
	//Activity创建或者被覆盖，后台重新回到前台是被调用
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i(TAG, "OnResume called");
	}
	//Activity窗口获得失去焦点是被调用，在onResume之后或onPause之后
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		// TODO Auto-generated method stub
		super.onWindowFocusChanged(hasFocus);
		Log.i(TAG,"onWindowfocusChanged called");
	}
	//Activity被覆盖到下面货值锁屏时被调用
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.i(TAG, "onPause calleed");
		 //有可能在执行完onPause或onStop后,系统资源紧张将Activity杀死,所以有必要在此保存持久数
	}
	//退出当前Activity或者跳转到新Activity是被调用
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.i(TAG,"onStop called");
	}
	//退出当前Activity时被调用，调用之后Activity就结束了
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.i(TAG, "OnDestory called");
	}
	/** 
     * Activity被系统杀死时被调用. 
     * 例如:屏幕方向改变时,Activity被销毁再重建;当前Activity处于后台,系统资源紧张将其杀死. 
     * 另外,当跳转到其他Activity或者按Home键回到主屏时该方法也会被调用,系统是为了保存当前View组件的状态. 
     * 在onPause之前被调用. 
     */  
    @Override  
    protected void onSaveInstanceState(Bundle outState) {  
        outState.putInt("param", param);  
        Log.i(TAG, "onSaveInstanceState called. put param: " + param);  
        super.onSaveInstanceState(outState);  
    }  
      
	/*
	 * Activity 被系统杀死后重建时被调用
	 * 例如屏幕方向改变时Activity被销毁在重建，当前Activity处于后台系统自愈紧张
	 * 将其杀死，用户有启动该Activity
	 * 这两种情况下onRestoreInstanceState都会被调用,在onStart之后
	 * 
	 * */
    @Override  
    protected void onRestoreInstanceState(Bundle savedInstanceState) {  
        param = savedInstanceState.getInt("param");  
        Log.i(TAG, "onRestoreInstanceState called. get param: " + param);  
        super.onRestoreInstanceState(savedInstanceState);  
    }  
	
	
	
	
	
}
