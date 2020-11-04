package com.hellohasan.fragment_navigation_drawer.feature.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.hellohasan.fragment_navigation_drawer.R
import com.hellohasan.fragment_navigation_drawer.feature.home.model.CourseInfoResponse
import com.hellohasan.fragment_navigation_drawer.feature.home.presenter.HomePresenter
import com.hellohasan.fragment_navigation_drawer.feature.home.presenter.HomePresenterImpl
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeView {

    private lateinit var presenter: HomePresenter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = HomePresenterImpl(this)

        presenter.getCourseInformation()
    }

    override fun setProgressBarVisibility(isVisible: Boolean) {
        progress_bar?.visibility = if(isVisible) View.VISIBLE else View.GONE
    }

    override fun onDataFetchSuccess(data: CourseInfoResponse.Data) {
        Glide.with(iv_course_photo)
            .load(data.image)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.placeholder)
            .into(iv_course_photo)

        tv_course_name.text = data.name
    }

    override fun onDataFetchFailure(errorMessage: String) {
        Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_LONG).show()
    }
}