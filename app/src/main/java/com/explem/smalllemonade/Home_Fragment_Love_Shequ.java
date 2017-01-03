package com.explem.smalllemonade;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class Home_Fragment_Love_Shequ extends AppCompatActivity implements View.OnClickListener {

    private CheckBox home_fragment_love_shequ_che;
    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__fragment__love__shequ);
        final ImageView fanhui = (ImageView) findViewById(R.id.fanhui);
        home_fragment_love_shequ_che = (CheckBox) findViewById(R.id.home_fragment_love_shequ_che);
        home_fragment_love_shequ_che.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            private LinearLayout home_fragment_pop_jubao;
            private PopupWindow popupWindow;
            private TextView home_fragment_pop_tv;
            private CheckBox home_fragment_pop_che;

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                View v = View.inflate(Home_Fragment_Love_Shequ.this, R.layout.home_fragment_tiezi_xiangqing_pop, null);
                LinearLayout home_fragment_pop_lin = (LinearLayout) v.findViewById(R.id.home_fragment_pop_lin);
                home_fragment_pop_che = (CheckBox) v.findViewById(R.id.home_fragment_pop_che);
                home_fragment_pop_tv = (TextView) v.findViewById(R.id.home_fragment_pop_tv);
                home_fragment_pop_jubao = (LinearLayout) v.findViewById(R.id.home_fragment_pop_jubao);
                LinearLayout home_fragment_pop_louzhu = (LinearLayout) v.findViewById(R.id.home_fragment_pop_louzhu);
                popupWindow = new PopupWindow(v, 400, 450);
                popupWindow.setBackgroundDrawable(new BitmapDrawable());
                popupWindow.setOutsideTouchable(true);
                popupWindow.showAsDropDown(home_fragment_love_shequ_che, 10, 10);
                //取消
                home_fragment_pop_lin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        PanDuan();

                    }

                    private void PanDuan() {
                        if (!flag) {
                            home_fragment_pop_tv.setText("取消");
                            popupWindow.dismiss();
                        } else {
                            home_fragment_pop_tv.setText("倒叙排序");
                            popupWindow.dismiss();

                        }
                    }
                });
                //看楼主
                home_fragment_pop_louzhu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(Home_Fragment_Love_Shequ.this, "该楼主没跟帖哦··", Toast.LENGTH_SHORT).show();
                        popupWindow.dismiss();
                    }
                });
                //举报
                home_fragment_pop_jubao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                        View vv = View.inflate(Home_Fragment_Love_Shequ.this, R.layout.home_fragment_tishi_pop, null);
                        PopupWindow popupWindow1 = new PopupWindow(vv, 1000, 600);
                        popupWindow1.setOutsideTouchable(true);
                        popupWindow1.setBackgroundDrawable(new BitmapDrawable());
                        if (popupWindow1.isShowing()) {
                            // 关闭
                            popupWindow1.dismiss();
                        } else {
                            popupWindow1.showAtLocation(vv, Gravity.CENTER | Gravity.CENTER, 0, 0);
                            backgroundAlpha(0.3f);
                        }
                        popupWindow1.setOnDismissListener(new PopupWindow.OnDismissListener() {
                            @Override
                            public void onDismiss() {
                                //popupwindow消失的时候恢复成原来的透明度
                                backgroundAlpha(1f);
                            }
                        });
                    }
                });
            }
        });
        fanhui.setOnClickListener(this);
    }

    //popupWindow背景
    public void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = Home_Fragment_Love_Shequ.this.getWindow().getAttributes();
        lp.alpha = bgAlpha;
        Home_Fragment_Love_Shequ.this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        Home_Fragment_Love_Shequ.this.getWindow().setAttributes(lp);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fanhui:
                finish();
                break;
        }
    }

}
