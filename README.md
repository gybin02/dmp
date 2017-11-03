# Android 客户端数据库管理后台， DMP
<img src="http://ckhub.b0.upaiyun.com/dmp/head.jpg" width="100%">ç
## DMP 是一个 强大的辅助安卓查看数据库 和 shared preferences的工具。使用Web界面管理客户端数据，方便查看和测试。


### DMP 允许你 直接通过 浏览器查看，编辑，删除 数据库和 shared preferences
  * 原来查看数据库，必须安卓手机USB连接电脑，然后到 应用的data/data/db目录下吧数据库手动导出来，很消耗时间。
  * 导出来 a.db文件后，还需要电脑上安装 NaviCat 之类的数据库管理工具，才能打开；
  * 更重要的是，因为是导出数据库的方式，因此应用数据无法新增和修改；
  * 还有SharedPreference 的 也查看和修改不了。

### 使用
Add this to your app's build.gradle
```groovy
debugCompile 'com.meiyou.framework:dmp:0.0.1-SNAPSHOT'
```

使用 `debugCompile` 这样只有编译的时候代码才会发布，release包就不包含这些代码，可也减少包的方法数。

最后启动应用，会在LogCat打印出 访问地址：

* D/DebugDB: Open http://XXX.XXX.X.XXX:8080 in your browser


重要:
- 安卓手机和电脑需要连接统一网络(Wifi or LAN).
- 如果是你是通过 usb连接，额可以执行：run `adb forward tcp:8080 tcp:8080`

#### 额外配置

支持修改端口号：    在应用的 build.gradle 文件buildTypes区域内新增：
```groovy
debug {
    resValue("string", "PORT_NUMBER", "8081")
}
```
### 截图

### 查看数据
<img src=/image/query2.png >
<img src=/image/query.png >

### 编辑数据。
<img src=/image/edit.png >

### 模拟器配置
- Android 原生模拟器 Emulator: Run the command in the terminal - `adb forward tcp:8080 tcp:8080` and open http://localhost:8080
- Genymotion Emulator: 需要开启 `Enable bridge from configure virtual device` (option available in genymotion)

### Change Log

### TODO
* 文件管理后台
* ADB管理后台： 比如清除缓存，adb 执行等；
* 应用管理后台： 使用网页后台测试打开URI，测试进入LoginActivity等；
* LogCat 后台查看等；ç

#### 引用 
* [安卓架构组件(6)-Room持久化类库](http://www.jianshu.com/p/587f48dccf0a)
* [借助Stetho在Chrome上调试Android网络&数据库](http://www.jianshu.com/p/03da9f91f41f)
* https://github.com/amitshekhariitbhu/Android-Debug-Database
* Android Web Server
