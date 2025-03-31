1. MVVM ( Model - View - ViewModel )
2. 추가 사항 ( 아내 내용 추가 해야 import 가능 )
 - build.gradle.kts(:app) 추가
    - implementation(libs.androidx.lifecycle.viewmodel.ktx)
    - implementation(libs.androidx.lifecycle.livedata.ktx)
3. LiveData
   - DATA의 변동사항이 있을 때 LiveData를 활용하여 변동사항이 생겼을 때 UI업데이트를 시도 한다. ( viewModel.observe를 사용 )
   - LiveData를 활용하면 기존의 UI업데이트시 runOnUiThread를 활용하지 않고 사용 가능하다. 그러므로 ANR에러의 확률이 많이 낮아 진다.
    
4. REST API
 - Retrofit 라이브러리를 사용하여 특정 웹사이트 ( 랜덤 값 생성 ) 접근하여 해당 값을 가져와 UI 업데이트 ( LiveData )
 - 인터넷 설정 필수 ( https ) : <uses-permission android:name="android.permission.INTERNET"/>  만약에 권한 사용하지 않으면 permission error발생.
 - build.gradle.kts(:app)
   - implementation(libs.retrofit)
   - implementation(libs.converter.gson)
