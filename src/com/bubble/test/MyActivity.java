package com.pdsu.beforenight;

import com.pdsu.beforenight.adapter.BrowseApplicationInfoAdapter;
import com.pdsu.beforenight.bean.AppInfo;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    public static final int FILTER_ALL_APP = 0; // 所有应用程序
    public static final int FILTER_SYSTEM_APP = 1; // 系统程序
    public static final int FILTER_THIRD_APP = 2; // 第三方应用程序
    public static final int FILTER_SDCARD_APP = 3; // 安装在SDCard的应用程序

    private ListView listview = null;

    private PackageManager pm;
    private int filter = FILTER_ALL_APP;
    private List<AppInfo> mlistAppInfo ;
    private BrowseApplicationInfoAdapter browseAppAdapter = null ;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = (ListView) findViewById(R.id.listviewApp);
        if(getIntent()!=null){
            filter = getIntent().getIntExtra("filter", 0) ;
        }
        mlistAppInfo = queryFilterAppInfo(filter); // 查询所有应用程序信息
        // 构建适配器，并且注册到listView
        browseAppAdapter = new BrowseApplicationInfoAdapter(this, mlistAppInfo);
        listview.setAdapter(browseAppAdapter);
    }
    // 根据查询条件，查询特定的ApplicationInfo
    private List<AppInfo> queryFilterAppInfo(int filter) {
        pm = this.getPackageManager();
        // 查询所有已经安装的应用程序
        List<ApplicationInfo> listAppcations = pm
                .getInstalledApplications(PackageManager.GET_UNINSTALLED_PACKAGES);
        Collections.sort(listAppcations,
                new ApplicationInfo.DisplayNameComparator(pm));// 排序
        List<AppInfo> appInfos = new ArrayList<AppInfo>(); // 保存过滤查到的AppInfo
        // 根据条件来过滤
        switch (filter) {
            case FILTER_ALL_APP: // 所有应用程序
                appInfos.clear();
                for (ApplicationInfo app : listAppcations) {
                    appInfos.add(getAppInfo(app));
                }
                return appInfos;
            case FILTER_SYSTEM_APP: // 系统程序
                appInfos.clear();
                for (ApplicationInfo app : listAppcations) {
                    if ((app.flags & ApplicationInfo.FLAG_SYSTEM) != 0) {
                        appInfos.add(getAppInfo(app));
                    }
                }
                return appInfos;
            case FILTER_THIRD_APP: // 第三方应用程序
                appInfos.clear();
                for (ApplicationInfo app : listAppcations) {
                    //非系统程序
                    if ((app.flags & ApplicationInfo.FLAG_SYSTEM) <= 0) {
                        appInfos.add(getAppInfo(app));
                    }
                    //本来是系统程序，被用户手动更新后，该系统程序也成为第三方应用程序了
                    else if ((app.flags & ApplicationInfo.FLAG_UPDATED_SYSTEM_APP) != 0){
                        appInfos.add(getAppInfo(app));
                    }
                }
                break;
            case FILTER_SDCARD_APP: // 安装在SDCard的应用程序
                appInfos.clear();
                for (ApplicationInfo app : listAppcations) {
                    if ((app.flags & ApplicationInfo.FLAG_EXTERNAL_STORAGE) != 0) {
                        appInfos.add(getAppInfo(app));
                    }
                }
                return appInfos;
            default:
                return null;
        }
        return appInfos;
    }
    // 构造一个AppInfo对象 ，并赋值
    private AppInfo getAppInfo(ApplicationInfo app) {
        AppInfo appInfo = new AppInfo();
        appInfo.setAppLabel((String) app.loadLabel(pm));
        appInfo.setAppIcon(app.loadIcon(pm));
        appInfo.setPkgName(app.packageName);
        return appInfo;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.all_app_item:
                mlistAppInfo = queryFilterAppInfo(FILTER_ALL_APP);
                break;
            case R.id.system_app_item:
                mlistAppInfo = queryFilterAppInfo(FILTER_SYSTEM_APP);
                break;
            case R.id.other_app_item:
                mlistAppInfo = queryFilterAppInfo(FILTER_THIRD_APP);
                break;
            case R.id.sdcard_app_item:
                mlistAppInfo = queryFilterAppInfo(FILTER_SDCARD_APP);
                break;
            case R.id.help:
                Toast.makeText(this, "帮助信息",0).show();
                break;
            case R.id.exit:
                finish();
                break;

            default:
                break;
        }
        browseAppAdapter.notifyDataSetChanged();
        // 构建适配器，并且注册到listView
        browseAppAdapter = new BrowseApplicationInfoAdapter(this, mlistAppInfo);
        listview.setAdapter(browseAppAdapter);
        return super.onOptionsItemSelected(item);
    }


}

