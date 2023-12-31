package com.example.imagesearch

/**
 * 앱 전체에서 사용되는 상수들을 저장하는 객체입니다.
 */
object Constants {

    // Kakao Image Search API의 기본 URL입니다.
    const val BASE_URL = "https://dapi.kakao.com"

    // Kakao API를 사용하기 위한 인증 헤더입니다.
    const val AUTH_HEADER = "KakaoAK 3fa953962ea37d38b1c5fde88b4313a0"

    // 앱의 Shared Preferences 파일 이름입니다.
    const val PREFS_NAME = "com.example.imagesearch.prefs"

    // 마지막 검색어를 저장하기 위한 키 값입니다.
    const val PREF_KEY = "IMAGE_SEARCH_PREF"
}