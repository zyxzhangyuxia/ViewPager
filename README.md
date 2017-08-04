# ViewPager
 a demo of viewPager+Tablayout+fragment to implement like wechat page 
1.xml布局中：

    <?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <android.support.v4.view.ViewPager
        android:id="@+id/viewpager"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />

    <!--底部的tab-->
    <android.support.design.widget.TabLayout
        android:id="@+id/tabLayout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:paddingTop="5dp"
        android:paddingBottom="5dp"
        android:layout_weight="8"
        app:tabIndicatorHeight="0dp"
        app:tabSelectedTextColor="@color/colorPrimary"
        app:tabTextColor="@color/white"
        android:background="@color/colorAccent"
        android:textAllCaps="false"
        app:tabMode="scrollable" />

</RelativeLayout>

2.MainActivity.java

      private ViewPager viewpager;
    private TabLayout tabLayout;
    private HomeAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_layout);
        ButterKnife.bind(this);
        initView();
    }

    /**
     * UI 初始化
     */
    private void initView(){
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        List<Pair<String,Integer,Fragment>> pairList = initData();
        adapter = new HomeAdapter(getSupportFragmentManager(),this, pairList);
        viewpager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewpager);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(adapter.getTabView(i));
        }
      }
3.HomeAdaper.java

    public class HomeAdapter extends FragmentStatePagerAdapter {
    private Context context;
    private List<Pair<String,Integer,Fragment>> pairList;

    public HomeAdapter(FragmentManager fm) {
        super(fm);
    }

    public HomeAdapter(FragmentManager fm, Context context, List<Pair<String,Integer,Fragment>> pairList){
        super(fm);
        this.context = context;
        this.pairList = pairList;
    }

    @Override
    public Fragment getItem(int position) {
        return pairList.get(position).fragment;
    }

    @Override
    public int getCount() {
        return pairList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pairList.get(position).title;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return super.isViewFromObject(view, object);
    }

    public View getTabView(int position){
        View view = LayoutInflater.from(context).inflate(com.bsky.utilkit.lib.R.layout.item_tab_layout, null);
        TextView tv= (TextView) view.findViewById(com.bsky.utilkit.lib.R.id.tv_tab);
        ImageView img = (ImageView) view.findViewById(com.bsky.utilkit.lib.R.id.iv_tab);
        tv.setText(pairList.get(position).title);
        img.setImageResource(pairList.get(position).icon);
        return view;
    }
}


    
