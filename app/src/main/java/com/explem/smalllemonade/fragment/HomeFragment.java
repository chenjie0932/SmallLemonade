package com.explem.smalllemonade.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.explem.smalllemonade.R;
import com.explem.smalllemonade.base.BaseFragment;
import com.explem.smalllemonade.view.Home_Fragemnt_Note;
import com.explem.smalllemonade.sql.Dao;
import com.explem.smalllemonade.utils.BaseDate;
import com.explem.smalllemonade.view.ShowingPage;

/**主页Fragment
 * @auto  XuJiaJian
 * Created by Pooh on 2016/12/27.
 */

public class HomeFragment extends BaseFragment implements View.OnClickListener {

    private View v;
    private TextView home_fragment_period;
    private ImageView home_fragment_note;
    private  boolean flag=false;
    private  boolean flag2=false;
    private CheckBox home_fragment_pop_che_two;
    private CheckBox home_fragment_pop_che_one;
    int a=0;
    private SharedPreferences.Editor edit;

public class HomeFragment extends BaseFragment{
    public static String path="http://www.yulin520.com/a2a/impressApi/news/mergeList?sign=C7548DE604BCB8A17592EFB9006F9265&pageSize=10&gender=2&ts=1871746850";
    public static Dao dao;
    public static String data;
    @Override
    protected void onload() {
        //设置布局
        HomeFragment.this.showCurrentPage(ShowingPage.StateType.STATE_LOAD_SUCCESS);
    }

    @Override
    protected View createSuccessView() {
        v = View.inflate(getActivity(), R.layout.home_fragment, null);
        initView();
        return v;
    }

    private void initView() {
        //恋爱期
        home_fragment_period = (TextView) v.findViewById(R.id.home_fragment_period);
        //短信
        home_fragment_note = (ImageView) v.findViewById(R.id.home_fragment_note);
        home_fragment_period.setOnClickListener(this);
        home_fragment_note.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.home_fragment_period:
                //选择时期
                Peroid();
                break;
            case R.id.home_fragment_note:
                    enterIntent(Home_Fragemnt_Note.class);
                break;
            default:
                break;
        }

    }

            void Peroid() {
        View vv = View.inflate(getActivity(), R.layout.home_fragment_period_pop, null);
        //确定按钮
        Button home_fragment_pop_true = (Button) vv.findViewById(R.id.home_fragment_pop_true);
        //恋爱期
        home_fragment_pop_che_two = (CheckBox) vv.findViewById(R.id.home_fragment_pop_che_two);
        //单身期
        home_fragment_pop_che_one = (CheckBox) vv.findViewById(R.id.home_fragment_pop_che_one);
        final PopupWindow pop = new PopupWindow(vv, ViewGroup.LayoutParams.MATCH_PARENT, 800);
        pop.setBackgroundDrawable(new BitmapDrawable());
        pop.setOutsideTouchable(true);
        pop.setAnimationStyle(R.style.Popupwindow);
        int height = pop.getHeight();
        int width = pop.getWidth();
        //点击popWindow后背景变暗
        if (pop.isShowing()) {
            // 关闭
            pop.dismiss();
        } else {
            pop.showAtLocation(v, Gravity.LEFT | Gravity.TOP, v.getWidth() / 2 - width / 2, v.getHeight() / 2 - height / 2);
            backgroundAlpha(0.3f);
        }
        pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                //popupwindow消失的时候恢复成原来的透明度
                backgroundAlpha(1f);
            }
        });
        //确定按钮
        home_fragment_pop_true.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pop.dismiss();
            }
        });
        if(a==0){
            home_fragment_pop_che_two.setChecked(true);
            Love();
            Single();
        }
    }

    void Single() {
        home_fragment_pop_che_one.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(!flag2){
                    home_fragment_pop_che_one.setChecked(true);
                    home_fragment_pop_che_two.setChecked(false);
                    home_fragment_period.setText("单身期");
                    flag2=true;
                }else {
                   home_fragment_pop_che_one.setChecked(false);
                    home_fragment_pop_che_two.setChecked(true);
                    home_fragment_period.setText("恋爱期");
                    flag2=false;
                }

            }
        });
    }

    void Love() {

        home_fragment_pop_che_two.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(!flag){
                    home_fragment_pop_che_two.setChecked(true);
                    home_fragment_pop_che_one.setChecked(false);
                    home_fragment_period.setText("恋爱期");
                    flag=true;
                }else {
                   home_fragment_pop_che_two.setChecked(false);
                    home_fragment_pop_che_one.setChecked(true);
                    home_fragment_period.setText("单身期");
                    flag=false;
                }

            }
        });
    }

    public void enterIntent(Class c){
        Intent intent=new Intent(getActivity(),c);
        startActivity(intent);
    }

    //popupWindow背景
    public void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
        lp.alpha = bgAlpha;
        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        getActivity().getWindow().setAttributes(lp);
        TextView tv=new TextView(getActivity());
        tv.setText("主页....");
        //请求数据
        getData();
        return tv;
    }
    //请求数据的方法
    public void getData(){
        new BaseDate(getActivity()) {


            @Override
            protected void setResultError(ShowingPage.StateType stateLoadError) {

            }

            @Override
            public void setResultData(String data) {

            }
        }.getDate(path,"&page=1",1,BaseDate.NOMALTIME);
    }
}
