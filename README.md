# Android 客户端数据库管理后台， DMP

## DMP 是一个 强大的辅助安卓查看数据库 和 shared preferences的工具。使用Web界面管理。

### DMP 允许你 直接通过 浏览器查看，编辑，删除 数据库和 shared preferences



### Using Android Debug Database Library in your application
Add this to your app's build.gradle
```groovy
debugCompile 'com.amitshekhar.android:debug-db:1.0.1'
```

Use `debugCompile` so that it will only compile in your debug build and not in your release build.

That’s all, just start the application, you will see in the logcat an entry like follows :

* D/DebugDB: Open http://XXX.XXX.X.XXX:8080 in your browser

* You can also always get the debug address url from your code by calling the method `DebugDB.getAddressLog();`

Now open the provided link in your browser.

Important:
- Your Android phone and laptop should be connected to the same Network (Wifi or LAN).
- If you are using it over usb, run `adb forward tcp:8080 tcp:8080`

Note      : If you want use different port other than 8080. 
            In the app build.gradle file under buildTypes do the following change

```groovy
debug {
    resValue("string", "PORT_NUMBER", "8081")
}
```




You will see something like this :

### Seeing values
<img src=https://raw.githubusercontent.com/amitshekhariitbhu/Android-Debug-Database/master/assets/debugdb.png >

### Editing values
<img src=https://raw.githubusercontent.com/amitshekhariitbhu/Android-Debug-Database/master/assets/debugdb_edit.png >

### Working with emulator
- Android Default Emulator: Run the command in the terminal - `adb forward tcp:8080 tcp:8080` and open http://localhost:8080
- Genymotion Emulator: Enable bridge from configure virtual device (option available in genymotion)

### Getting address with toast, in case you missed the address log in logcat
As this library is auto-initialize, if you want to get the address log, add the following method and call (we have to do like this to avoid build error in release build as this library will not be included in the release build) using reflection.
```java
public static void showDebugDBAddressLogToast(Context context) {
    if (BuildConfig.DEBUG) {
       try {
            Class<?> debugDB = Class.forName("com.amitshekhar.DebugDB");
            Method getAddressLog = debugDB.getMethod("getAddressLog");
            Object value = getAddressLog.invoke(null);
            Toast.makeText(context, (String) value, Toast.LENGTH_LONG).show();
       } catch (Exception ignore) {

       }
    }
}
```

### Adding custom database files
As this library is auto-initialize, if you want to add custom database files, add the following method and call
```java
public static void setCustomDatabaseFiles(Context context) {
    if (BuildConfig.DEBUG) {
        try {
            Class<?> debugDB = Class.forName("com.amitshekhar.DebugDB");
            Class[] argTypes = new Class[]{HashMap.class};
            Method setCustomDatabaseFiles = debugDB.getMethod("setCustomDatabaseFiles", argTypes);
            HashMap<String, File> customDatabaseFiles = new HashMap<>();
            // set your custom database files
            customDatabaseFiles.put(ExtTestDBHelper.DATABASE_NAME,
                    new File(context.getFilesDir() + "/" + ExtTestDBHelper.DIR_NAME +
                            "/" + ExtTestDBHelper.DATABASE_NAME));
            setCustomDatabaseFiles.invoke(null, customDatabaseFiles);
        } catch (Exception ignore) {

        }
    }
}
```

#### 引用 
* https://github.com/amitshekhariitbhu/Android-Debug-Database
* Android Web Server
