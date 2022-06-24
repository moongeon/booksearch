👀BookSearch App
=================

BookSearch은 도서관 검색 앱입니다.

🙌소개
------------
사용된 라이브러리
* Android Jetpack : 훌륭한 Android 앱을 만들기 위한 구성요소, 도구 라이브러리 입니다.
  * Foundation : 핵심 시스템 기능, Kotlin 확장 및 multdex 및 자동 테스트 지원을 위한 구성요소입니다.
  * Architecture : 강력하고 테스트가능하며 유지 관리 가능한 앱을 설계하는데 필요한 라이브러리 모음입니다.
    * DataBinding : 관찰 가능한 데이터를 UI요소에 바인딩합니다.
    * Lifecycles : 수명 주기 이벤트에 자동으로 응답하는 UI를 만듭니다.
    * LiveData : 수명주기를 고려한 관찰가능한 데이터 개체를 빌드합니다.
    * Navigation : 앱 안의 여러가지 탐색을 구현하도록 도와줍니다.
    * ViewModel : 앱 회전 시 소멸되지 않는 UI 관련 데이터를 저장 합니다. 
  * UI : 앱에서 UI구성요소
    * Layout : 다양한 위젯을 배치합니다.
    * Fragment : 구성 가능한 UI 기본 단위입니다.
![Android Jetpack](screenshots/jetpack_donut.png "Android Jetpack Components")
* Coroutine : 비동기 작업들의 코드를 간소화하고 메모리 릭을 줄이기 위해 사용합니다.
* Retrofit & Okhttp : 네트워크 통신을 위해 사용하였습니다.
* Dagger hilt : 의존성 주입을 위해 쉽고 불필요한 dagger 코드를 줄여주는 hilt를 사용하였습니다.
* Gilde : 이미지를 빠르고 효율적으로 불러오기 위해 사용합니다.

🤷‍♀️시작하기
------------
이 프로젝트는 Gradle Build 시스템을 사용합니다. 프로젝트를 빌드하려면 Android Studio에서 "Import Project"를 사용하세요.

👍스크린샷
-----------
![화면1](screenshots/snapShot_01.png "화면1")
![화면2](screenshots/snapShot_02.png "화면2")
![화면3](screenshots/snapShot_03.png "화면3")
![화면4](screenshots/snapShot_04.png "화면4")
![화면5](screenshots/snapShot_05.png "화면5")
![화면6](screenshots/snapShot_06.png "화면6")
![화면7](screenshots/snapShot_07.png "화면7")
