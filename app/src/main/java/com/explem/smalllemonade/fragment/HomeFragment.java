package com.explem.smalllemonade.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.explem.smalllemonade.R;
import com.explem.smalllemonade.base.BaseFragment;
import com.explem.smalllemonade.community.bean.CommunityContent;
import com.explem.smalllemonade.view.Home_Fragemnt_Note;
import com.explem.smalllemonade.bean.Home_Fragment_LunBo_Bean;
import com.explem.smalllemonade.sql.Dao;
import com.explem.smalllemonade.utils.BaseDate;
import com.explem.smalllemonade.view.Home_Fragemnt_Note;
import com.explem.smalllemonade.view.ShowingPage;
import com.google.gson.Gson;
import com.zhy.magicviewpager.transformer.AlphaPageTransformer;
import com.zhy.magicviewpager.transformer.ScaleInTransformer;

import java.util.ArrayList;

import static com.android.volley.VolleyLog.TAG;

/**
 * 主页Fragment
 *
 * @auto XuJiaJian
 * Created by Pooh on 2016/12/27.
 */

public class HomeFragment extends BaseFragment implements View.OnClickListener {
    //请求网络----轮播图
    int tag_lunbo=0;
    private View v;
    private TextView home_fragment_period;
    private ImageView home_fragment_note;
    private boolean flag = false;
    private boolean flag2 = false;
    private CheckBox home_fragment_pop_che_two;
    private CheckBox home_fragment_pop_che_one;
    private Home_Fragment_LunBo_Bean home_fragment_lunBo_bean;
    int a = 0;
    private SharedPreferences.Editor edit;
    private ArrayList<String> pathList = new ArrayList<>();
    public static String path_lunbo = "http://www.yulin520.com/a2a/broadcast/files";
    public static String args_lunbo = "sign=7442C54B6DAFB81CEB01588164F3CCA8&ts=1482907765&pageSize=9&page=1";

    public static Dao dao;
    public static String data;
    private ViewPager home_fragment_viewPager;
    private LinearLayout home_fragment_lin;

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.arg1==tag_lunbo){
                Home_Fragment_LunBo_Bean home_fragment_lunBo_bean= (Home_Fragment_LunBo_Bean) msg.obj;
                //拿圆点
                getDoc(home_fragment_lunBo_bean);
                //轮播图的数据适配器
                setMyAdapter(home_fragment_lunBo_bean);
            }
        }
    };
    private ImageView home_fragment_snow_people;


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
//        //短信
        home_fragment_note = (ImageView) v.findViewById(R.id.home_fragment_note);
//        //轮播图
//        home_fragment_viewPager = (ViewPager) v.findViewById(R.id.home_fragment_viewPager);
//        home_fragment_lin = (LinearLayout) v.findViewById(R.id.home_fragment_lin);
//        //雪人图片
//        home_fragment_snow_people = (ImageView) v.findViewById(R.id.home_fragment_snow_people);
        //请求网络
        //getData(path_lunbo,args_lunbo,tag_lunbo);
        //设置轮播图动画
        //getLunBoAnim();

        home_fragment_period.setOnClickListener(this);
        home_fragment_note.setOnClickListener(this);
    }

    //添加圆点
    ArrayList<ImageView> docList = new ArrayList<>();

    private void getDoc(Home_Fragment_LunBo_Bean home_fragment_lunBo_bean) {
//        Log.i(TAG, "getDoc: ***"+home_fragment_lunBo_bean.getData().size());
        for (int i = 0; i < home_fragment_lunBo_bean.getData().size(); i++) {
            ImageView imageView = new ImageView(getActivity());
            if (i == 0) {
                // 如果是第一张，默认给一个亮的小点
                //imageView.setImageResource(R.drawable.dot_focuse);
            } else {
                // 如果不是滴一个，默认给一个暗的小点
                //imageView.setImageResource(R.drawable.dot_normal);
            }
            // 设置小点的默认宽高为20dp
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20, 20);
            // 设置小点的间距
            params.setMargins(5, 0, 5, 0);
            home_fragment_lin.addView(imageView, params);
            // 往小点集合中添加view
            docList.add(imageView);
        }
    }

    //设置轮播图动画
    private void getLunBoAnim() {
        home_fragment_viewPager.setOffscreenPageLimit(3);
        home_fragment_viewPager.setPageMargin(50);
        home_fragment_viewPager.setCurrentItem(5000);
        //给轮播图设置动画
        home_fragment_viewPager.setPageTransformer(true,
                new AlphaPageTransformer(new AlphaPageTransformer(new ScaleInTransformer())));
        //添加圆点
        home_fragment_viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // 遍历小点的集合
                for (int i = 0; i < docList.size(); i++) {
                    // 如果当前的索引值和i相等
                    if (position % docList.size() == i) {
                        // 设置小点为亮色
                        //docList.get(i).setImageResource(R.drawable.dot_focuse);
                    } else {
                        // 否则暗色
                        //docList.get(i).setImageResource(R.drawable.dot_normal);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

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

    //选择时期
    void Peroid() {
        View vv = View.inflate(getActivity(), R.layout.home_fragment_period_pop, null);
        //确定按钮
        Button home_fragment_pop_true = (Button) vv.findViewById(R.id.home_fragment_pop_true);
        //恋爱期
        home_fragment_pop_che_two = (CheckBox) vv.findViewById(R.id.home_fragment_pop_che_two);
        //单身期
        home_fragment_pop_che_one = (CheckBox) vv.findViewById(R.id.home_fragment_pop_che_one);
        final PopupWindow pop = new PopupWindow(vv, 800, 1000);
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
        if (a == 0) {
            home_fragment_pop_che_two.setChecked(true);
            Love();
            Single();
        }
    }

    //单身期
    void Single() {
        home_fragment_pop_che_one.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (!flag2) {
                    home_fragment_pop_che_one.setChecked(true);
                    home_fragment_pop_che_two.setChecked(false);
                    home_fragment_period.setText("单身期");
                    flag2 = true;
                } else {
                    home_fragment_pop_che_one.setChecked(false);
                    home_fragment_pop_che_two.setChecked(true);
                    home_fragment_period.setText("恋爱期");
                    flag2 = false;
                }

            }
        });
    }

    //恋爱期
    void Love() {

        home_fragment_pop_che_two.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (!flag) {
                    home_fragment_pop_che_two.setChecked(true);
                    home_fragment_pop_che_one.setChecked(false);
                    home_fragment_period.setText("恋爱期");
                    flag = true;
                } else {
                    home_fragment_pop_che_two.setChecked(false);
                    home_fragment_pop_che_one.setChecked(true);
                    home_fragment_period.setText("单身期");
                    flag = false;
                }

            }
        });
    }

    //枢纽 / 意图
    public void enterIntent(Class c) {
        Intent intent = new Intent(getActivity(), c);
        startActivity(intent);
    }

    //popupWindow背景
    public void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
        lp.alpha = bgAlpha;
        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        getActivity().getWindow().setAttributes(lp);
    }

    //请求数据的方法
    public void getData(String path, String args, final int tag) {
        new BaseDate(getActivity()) {
            @Override
            protected void setResultError(ShowingPage.StateType stateLoadError) {
            }

                @Override
                public CommunityContent setResultData(String data) {
            @Override
            public void setResultData(String data) {
                HomeFragment.this.data = data;
                Gson gson = new Gson();

                    return null;
                if(tag_lunbo==tag){
                    home_fragment_lunBo_bean = gson.fromJson(data, Home_Fragment_LunBo_Bean.class);
                    //发送到Handler中
                    Message msg=new Message();
                    msg.obj=home_fragment_lunBo_bean;
                    msg.arg1=tag;
                    handler.sendMessage(msg);
                }
            }
        }.getDate(path, args, 1, BaseDate.NOMALTIME);
    }


    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ******");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ***");
    }

    //轮播图的适配器
    public void setMyAdapter(final Home_Fragment_LunBo_Bean home_fragment_lunBo_bean){
        home_fragment_viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return home_fragment_lunBo_bean.getData().size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView img = new ImageView(getActivity());
                if (position % home_fragment_lunBo_bean.getData().size() == position) {
                    Glide.with(getActivity()).load(home_fragment_lunBo_bean.getData().get(position).getImg()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(img);
                    //ImageLoader.getInstance().displayImage(home_fragment_lunBo_bean.getData().get(position).getImg(), img, ImageLoaderUtils.initOptions());
                }
                container.addView(img);
                return img;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }
        });
    }
}
