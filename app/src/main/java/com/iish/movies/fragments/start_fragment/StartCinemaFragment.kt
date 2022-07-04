package com.iish.movies.fragments.start_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.iish.movies.databinding.FragmentStartCinemaBinding
import com.iish.movies.recyclerview.CinemaListAdapter
import com.iish.movies.recyclerview.ItemListener
import com.iish.movies.recyclerview.decorators.CustomItemDecorator
import com.iish.movies.utils.CustomView

class StartCinemaFragment : Fragment(), ItemListener {
    private lateinit var startCinemaViewModel: StartCinemaViewModel
    private var cinemaAdapter: CinemaListAdapter = CinemaListAdapter(this)
    private lateinit var binding: FragmentStartCinemaBinding
    private var customItemDecorator: CustomItemDecorator = CustomItemDecorator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartCinemaBinding.inflate(layoutInflater)
        startCinemaViewModel = ViewModelProvider(this)[StartCinemaViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initRecyclerView()
//        initToolBar()
    }

//    private fun initToolBar() {
//        setSupportActionBar(binding.toolbar)
//        binding.searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                mainActivityViewModel.findCinemaByName(query!!)
//                mainActivityViewModel.foundedCinema?.observe(this@MainActivity) { cinemaList ->
//                    cinemaAdapter.updData(cinemaList)
//                    cinemaAdapter.submitList(cinemaList.toMutableList())
//                    contentHasLoaded = true
//                }
//                return false
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                return false
//            }
//        })
//        binding.searchView.setOnCloseListener {
//            mainActivityViewModel.response.observe(this@MainActivity) { cinemaList ->
//                cinemaAdapter.updData(cinemaList)
//                cinemaAdapter.submitList(cinemaList.toMutableList())
//                contentHasLoaded = true
//            }
//            false
//        }
//    }


    private fun initRecyclerView() {
        initializeCustomView(binding.viewNewCinema, "Новые Фильмы")
        initializeCustomView(binding.viewLastAdded, "Последние добавленные")
        initializeCustomView(binding.viewLastUpdates, "Последние обновления")
        initializeCustomView(binding.viewShowNow, "Смотрят сейчас")
    }

    private fun initViewModel() {
        startCinemaViewModel.response.observe(viewLifecycleOwner) { cinemaList ->
            cinemaAdapter.updData(cinemaList)
            cinemaAdapter.submitList(cinemaList.toMutableList())
            startCinemaViewModel.contentHasLoaded()
        }
    }

    override fun onClick(position: Int) {
        cinemaAdapter.currentList[position]?.let {

        }
    }

    private fun initializeCustomView(customView: CustomView, name: String) {
        customView.setRv(cinemaAdapter, customItemDecorator)
        customView.setSectorName(name)
        customView.setClickableSpan()
    }

}