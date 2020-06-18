package com.example.alodoktermobiletest.profile.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.alodoktermobiletest.databinding.FragmentProfileBinding
import com.example.alodoktermobiletest.login.model.UserModelView

class ProfileFragment : Fragment(),
    ProfileInterface {

    private var binding: FragmentProfileBinding? = null
    private var presenter =
        ProfilePresenter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.initData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onDataSet(userModelView: UserModelView?) {
        userModelView?.image?.let { binding?.imageViewProfile?.setImageResource(it) }
        binding?.textViewName?.text = userModelView?.name.orEmpty()
        binding?.textViewGender?.text = userModelView?.gender.orEmpty()
        binding?.textViewPhoneNumber?.text = userModelView?.phoneNumber.orEmpty()
    }
}