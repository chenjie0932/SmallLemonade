package com.explem.smalllemonade;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.utils.Log;

public class InviteActivity extends AppCompatActivity {

    private LinearLayout share_qqzone;
    private LinearLayout share_qq;
    private LinearLayout share_wechat;
    private LinearLayout share_friend;
    private LinearLayout share_weibo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite);
        share_qqzone = (LinearLayout) findViewById(R.id.share_qqzone);
        share_qq = (LinearLayout) findViewById(R.id.share_qq);
        share_wechat = (LinearLayout) findViewById(R.id.share_wechat);
        share_friend = (LinearLayout) findViewById(R.id.share_friend);
        share_weibo = (LinearLayout) findViewById(R.id.share_weibo);
        share_qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShareAction(InviteActivity.this).setPlatform(SHARE_MEDIA.QQ)
                        .withText("hello")
                        .setCallback(umShareListener)
                        .share();
                /*new ShareAction(InviteActivity.this).withText("hello")
                        .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
                        .setCallback(umShareListener).open();*/
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }
    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Log.d("plat","platform"+platform);

            Toast.makeText(InviteActivity.this, platform + " 分享成功啦", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(InviteActivity.this,platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
            if(t!=null){
                Log.d("throw","throw:"+t.getMessage());
            }
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(InviteActivity.this,platform + " 分享取消了", Toast.LENGTH_SHORT).show();
        }
    };
}
