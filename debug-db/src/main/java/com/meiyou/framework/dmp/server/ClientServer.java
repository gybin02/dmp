
package com.meiyou.framework.dmp.server;


import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
/**
 * Socket 服务器
 * @author zhengxiaobin@xiaoyouzi.com
 * @since  17/11/10 上午9:22
 */
public class ClientServer implements Runnable {

    private static final String TAG = "ClientServer";

    private final int mPort;

    private boolean mIsRunning;

    private ServerSocket mServerSocket;

    private final RequestHandler mRequestHandler;

    public ClientServer(Context context, int port) {
        mRequestHandler = new RequestHandler(context);
        mPort = port;
    }

    public void start() {
        mIsRunning = true;
        new Thread(this).start();
    }

    public void stop() {
        try {
            mIsRunning = false;
            if (null != mServerSocket) {
                mServerSocket.close();
                mServerSocket = null;
            }
        } catch (Exception e) {
            Log.e(TAG, "Error closing the server socket.", e);
        }
    }

    @Override
    public void run() {
        try {
            mServerSocket = new ServerSocket(mPort);
            while (mIsRunning) {
                Socket socket = mServerSocket.accept();
                mRequestHandler.handle(socket);
                socket.close();
            }
        } catch (SocketException e) {
            // The server was stopped; ignore.
            Log.e(TAG, "SocketException server error.", e);
        } catch (IOException e) {
            Log.e(TAG, "Web server error.", e);
        } catch (Exception e) {
            Log.e(TAG, "OtherException server error.", e);
        }
    }

    public void setCustomDatabaseFiles(HashMap<String, File> customDatabaseFiles){
            mRequestHandler.setCustomDatabaseFiles(customDatabaseFiles);
    }

    public boolean isRunning() {
        return mIsRunning;
    }
}
