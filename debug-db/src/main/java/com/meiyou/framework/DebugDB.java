package com.meiyou.framework;

import android.content.Context;
import android.util.Log;

import com.framework.R;
import com.meiyou.framework.server.ClientServer;
import com.meiyou.framework.utils.NetworkUtils;

import java.io.File;
import java.util.HashMap;

/**
 * 数据库查看，需要先初始化：initialize(Context)
 *
 * @author zhengxiaobin@xiaoyouzi.com
 * @since 17/11/7 上午10:58
 */
public class DebugDB {

    private static final String TAG = DebugDB.class.getSimpleName();
    private static final int DEFAULT_PORT = 8080;
    private static ClientServer clientServer;
    private static String addressLog = "not available";

    private DebugDB() {
        // This class in not publicly instantiable
    }

    /**
     * 初始化
     *
     * @param context
     */
    public static void initialize(Context context) {
        int portNumber;

        try {
            portNumber = Integer.valueOf(context.getString(R.string.PORT_NUMBER));
        } catch (NumberFormatException ex) {
            Log.e(TAG, "PORT_NUMBER should be integer", ex);
            portNumber = DEFAULT_PORT;
            Log.i(TAG, "Using Default port : " + DEFAULT_PORT);
        }

        clientServer = new ClientServer(context, portNumber);
        clientServer.start();
        addressLog = NetworkUtils.getAddressLog(context, portNumber);
        Log.d(TAG, addressLog);
    }

    /**
     * 获取 Web 服务器地址
     *
     * @return
     */
    public static String getAddressLog() {
        Log.d(TAG, addressLog);
        return addressLog;
    }

    /**
     * 关闭Socket服务器
     */
    public static void shutDown() {
        if (clientServer != null) {
            clientServer.stop();
            clientServer = null;
        }
    }

    /**
     * 手动设置外部数据库
     *
     * @param customDatabaseFiles
     */
    public static void setCustomDatabaseFiles(HashMap<String, File> customDatabaseFiles) {
        if (clientServer != null) {
            clientServer.setCustomDatabaseFiles(customDatabaseFiles);
        }
    }

    /**
     * 服务器是否运行
     *
     * @return
     */
    public static boolean isServerRunning() {
        return clientServer != null && clientServer.isRunning();
    }

}
