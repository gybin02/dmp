
package com.meiyou.framework.dmp;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.util.HashMap;

/**
 * 
 * @author zhengxiaobin@xiaoyouzi.com
 * @since  17/11/10 上午9:20
 */
public class DmpHelper {

    private static final String TAG = DmpHelper.class.getSimpleName();
    private static final int DEFAULT_PORT = 8080;
    //    private static ClientServer clientServer;
    private static String addressLog = "not available";

    private DmpHelper() {
        // This class in not publicly instantiable
    }

    public static void initialize(Context context) {
        int portNumber;
//
//        try {
//            portNumber = Integer.valueOf(context.getString(R.string.PORT_NUMBER));
//        } catch (NumberFormatException ex) {
//            Log.e(TAG, "PORT_NUMBER should be integer", ex);
//            portNumber = DEFAULT_PORT;
//            Log.i(TAG, "Using Default port : " + DEFAULT_PORT);
//        }
//
//        clientServer = new ClientServer(context, portNumber);
//        clientServer.start();
//        addressLog = NetworkUtils.getAddressLog(context, portNumber);
        Log.d(TAG, "initialize");
    }

    public static String getAddressLog() {
//        Log.d(TAG, addressLog);
        return addressLog;
    }

    public static void shutDown() {
        Log.d(TAG, "shutDown");
//        if (clientServer != null) {
//            clientServer.stop();
//            clientServer = null;
//        }
    }

    public static void setCustomDatabaseFiles(HashMap<String, File> customDatabaseFiles) {
//        if(clientServer!=null){
//            clientServer.setCustomDatabaseFiles(customDatabaseFiles);
//        }

        Log.d(TAG, "setCustomDatabaseFiles");
    }

    public static boolean isServerRunning() {
        Log.d(TAG, "isServerRunning");
//        return clientServer != null && clientServer.isRunning();  
        return false;
    }

}
