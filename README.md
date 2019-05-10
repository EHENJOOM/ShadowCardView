# 自定义阴影颜色的CardView

今天用CardView做卡片式设计的时候，给出的UI让做一个蓝色的阴影效果，我找遍了CardView的接口都没有发现修改阴影颜色的方法，于是看了一下源码，发现谷歌把CardView的阴影颜色给写死了。因此写了一个能自定义颜色、阴影宽度、模糊度的CardView，感觉效果还不错，便封装起来做成依赖库发布了。

一个简单的效果图：

![](https://img-blog.csdnimg.cn/20190510185644636.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzE4NDc5NjUz,size_16,color_FFFFFF,t_70)

## 使用方法：

### 1.添加依赖

首先，在build.gradle文件下加入 maven {url 'https://jitpack.io'}

```javascript
allprojects {
	repositories {
		google()
		jcenter()
		maven {url "https://jitpack.io"}
	}
}
```

然后在dependencies下加入依赖

```js
implementation 'com.github.EHENJOOM:ShadowCardView:1.1.0'
```

### 2.在布局文件中添加ShadowCardView

```xml
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

   <com.zhk.shadowcardview.ShadowCardView
       android:layout_width="match_parent"
       android:layout_height="200dp"
       android:layout_centerInParent="true"
       android:layout_marginLeft="40dp"
       android:layout_marginRight="40dp"
       app:cornersRadius="15dp"
       app:shadowColor="@color/red" />

</RelativeLayout>
```

### 3.在java代码里修改对应的属性值

```java
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ShadowCardView shadowCardView=findViewById(R.id.shadowCardView);
        shadowCardView.setCornersRadius(ShadowCardView.dp2px(this,15))
                .setShadowColor(getResources().getColor(R.color.red))
                .setShadowOffsetY(ShadowCardView.dp2px(this,5));
    }
}
```

### 4.xml标签属性表

加入命名空间才能使用下面的属性

```xml
xmlns:app="http://schemas.android.com/apk/res-auto"
```

|       标签名       |         对应属性         |
| :----------------: | :----------------------: |
|   cornersRadius    |       CardView圆角       |
|  shadowLeftHeight  |       左侧阴影宽度       |
|  shadowTopHeight   |       顶部阴影宽度       |
| shadowRightHeight  |       右侧阴影宽度       |
| shadowBottomHeight |       底部阴影宽度       |
|   shadowOffsetX    |     X轴的阴影偏离度      |
|   shadowOffsetY    |     Y轴的阴影偏离度      |
|     cardColor      |      CardView的颜色      |
|    shadowColor     |         阴影颜色         |
|    shadowRadius    | 阴影模糊度，值越大越模糊 |

### 5.java代码方法表

|           方法名           |           对应属性           |
| :------------------------: | :--------------------------: |
|   setCornersRadius(int)    |       设置CardView圆角       |
|  setShadowLeftHeight(int)  |       设置左侧阴影宽度       |
|  setShadowTopHeight(int)   |       设置顶部阴影宽度       |
| setShadowRightHeight(int)  |       设置右侧阴影宽度       |
| setShadowBottomHeight(int) |       设置底部阴影宽度       |
|   setShadowOffsetX(int)    |     设置X轴的阴影偏离度      |
|   setShadowOffsetY(int)    |     设置Y轴的阴影偏离度      |
|     setCardColor(int)      |      设置CardView的颜色      |
|    setShadowColor(int)     |         设置阴影颜色         |
|    setShadowRadius(int)    | 设置阴影模糊度，值越大越模糊 |

##### 需要注意的是，这里宽度的单位为px，如果想使用dp为单位，可以调用dp2px(Context,float)函数将dp转化为px值再传入参数。

后续将会更新更多的属性和方法，有什么想法的小伙伴可以留言。觉得这个控件不错的小伙伴动动手指点个赞呗，也欢迎去[项目地址](https://github.com/EHENJOOM/ShadowCardView)Star。

