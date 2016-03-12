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
	//Activity����ʱ����
	@SuppressLint("InlinedApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.i(TAG,"onCreate valled");
		setContentView(R.layout.activity_main);
		//setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//����
		//setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER_LANDSCAPE);//��������
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
	//Activity�������ߴӺ�̨���»ص�ǰ̨�Ǳ�����
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.i(TAG,"onStart called");
	}
	//Activity�������߱����ǣ���̨���»ص�ǰ̨�Ǳ�����
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i(TAG, "OnResume called");
	}
	//Activity���ڻ��ʧȥ�����Ǳ����ã���onResume֮���onPause֮��
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		// TODO Auto-generated method stub
		super.onWindowFocusChanged(hasFocus);
		Log.i(TAG,"onWindowfocusChanged called");
	}
	//Activity�����ǵ������ֵ����ʱ������
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.i(TAG, "onPause calleed");
		 //�п�����ִ����onPause��onStop��,ϵͳ��Դ���Ž�Activityɱ��,�����б�Ҫ�ڴ˱���־���
	}
	//�˳���ǰActivity������ת����Activity�Ǳ�����
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.i(TAG,"onStop called");
	}
	//�˳���ǰActivityʱ�����ã�����֮��Activity�ͽ�����
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.i(TAG, "OnDestory called");
	}
	/** 
     * Activity��ϵͳɱ��ʱ������. 
     * ����:��Ļ����ı�ʱ,Activity���������ؽ�;��ǰActivity���ں�̨,ϵͳ��Դ���Ž���ɱ��. 
     * ����,����ת������Activity���߰�Home���ص�����ʱ�÷���Ҳ�ᱻ����,ϵͳ��Ϊ�˱��浱ǰView�����״̬. 
     * ��onPause֮ǰ������. 
     */  
    @Override  
    protected void onSaveInstanceState(Bundle outState) {  
        outState.putInt("param", param);  
        Log.i(TAG, "onSaveInstanceState called. put param: " + param);  
        super.onSaveInstanceState(outState);  
    }  
      
	/*
	 * Activity ��ϵͳɱ�����ؽ�ʱ������
	 * ������Ļ����ı�ʱActivity���������ؽ�����ǰActivity���ں�̨ϵͳ��������
	 * ����ɱ�����û���������Activity
	 * �����������onRestoreInstanceState���ᱻ����,��onStart֮��
	 * 
	 * */
    @Override  
    protected void onRestoreInstanceState(Bundle savedInstanceState) {  
        param = savedInstanceState.getInt("param");  
        Log.i(TAG, "onRestoreInstanceState called. get param: " + param);  
        super.onRestoreInstanceState(savedInstanceState);  
    }  
	
	
	
	
	
}
