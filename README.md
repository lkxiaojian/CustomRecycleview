# CustomRecycleview
  ##引用

      	allprojects {
    		repositories {
    			...
    			maven { url 'https://jitpack.io' }
    		}
    	}

Add the dependency

	dependencies {
	        implementation 'com.github.lkxiaojian:CustomRecycleview:1.0'
	}

  ##使用

    <com.example.recycleviewlibrary.YRecycleView
        android:layout_width="match_parent"
        android:layout_height="match_parent">
    </com.example.recycleviewlibrary.YRecycleView>

  ##监听

    yRecycleView.setRefreshAndLoadMoreListener(new YRecycleView.OnRefreshAndLoadMoreListener() {
            @Override
            public void onRefresh() {
      
                yRecycleView.setReFreshComplete();

            }

            @Override
            public void onLoadMore() {
      
                yRecycleView.setloadMoreComplete();
            }
        });
