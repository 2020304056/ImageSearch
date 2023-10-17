package com.example.imagesearch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.imagesearch.databinding.ActivityMainBinding
import com.example.imagesearch.feature.bookmark.BookmarkFragment
import com.example.imagesearch.feature.search.SearchFragment
import com.example.imagesearch.model.SearchItemModel

class MainActivity : AppCompatActivity() {

    // ActivityMainBinding은 MainActivity의 레이아웃 바인딩 객체입니다.
    private lateinit var binding: ActivityMainBinding

    // 좋아요를 눌러 선택된 아이템을 저장하는 리스트
    var likedItems: ArrayList<SearchItemModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ActivityMainBinding 객체를 초기화하고 이를 사용하여 레이아웃을 설정합니다.
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 버튼의 클릭 리스너를 설정합니다.
        // SearchFragment와 BookmarkFragment 간의 전환을 합니다.
        binding.run {
            mainSearchfragmentButton.setOnClickListener{
                setFragment(SearchFragment())
            }
            mainBookmarkfragmentButton.setOnClickListener {
                setFragment(BookmarkFragment())
            }
        }

        // 앱 시작 시 기본적으로 SearchFragment를 표시합니다.
        setFragment(SearchFragment())
    }

    /**
     * 주어진 프래그먼트를 화면에 표시하는 함수입니다.
     * @param frag 화면에 표시할 프래그먼트
     */
    private fun setFragment(frag : Fragment) {
        supportFragmentManager.commit {
            replace(R.id.main_framelayout, frag)
            setReorderingAllowed(true)
            addToBackStack(null)
        }
    }

    /**
     * 좋아요가 눌린 아이템을 likedItems 리스트에 추가하는 함수입니다.
     * @param item 좋아요가 눌린 아이템
     */
    fun addLikedItem(item: SearchItemModel) {
        if(!likedItems.contains(item)) {
            likedItems.add(item)
        }
    }

    /**
     * 좋아요가 취소된 아이템을 likedItems 리스트에서 제거하는 함수입니다.
     * @param item 좋아요가 취소된 아이템
     */
    fun removeLikedItem(item: SearchItemModel) {
        likedItems.remove(item)
    }
}