package com.example.discountcalculate.ui.Lainnya
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.discountcalculate.R
import com.example.discountcalculate.databinding.FragmentLainnyaBinding
import com.example.discountcalculate.network.DiskonApi


class LainnyaFragment : Fragment() {

    private val viewModel: LainnyaViewModel by lazy {
        ViewModelProvider(this).get(LainnyaViewModel::class.java)
    }

    private lateinit var myAdapter: LainnyaAdapter
    private lateinit var binding: FragmentLainnyaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLainnyaBinding.inflate(layoutInflater, container, false)
        myAdapter = LainnyaAdapter()
        with(binding.recyclerView) {
            addItemDecoration(
                DividerItemDecoration(
                    context,
                    RecyclerView.VERTICAL
                )
            )
            adapter = myAdapter
            setHasFixedSize(true)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getDiskon().observe(viewLifecycleOwner, {
            myAdapter.updateData(it)
        })
        viewModel.getStatus().observe(viewLifecycleOwner, {
            updateProgress(it)
        })
        viewModel.scheduleUpdater(requireActivity().application)
    }
    private fun updateProgress(status: DiskonApi.ApiStatus) {
        when (status) {
            DiskonApi.ApiStatus.LOADING -> {
                binding.progressBar.visibility = View.VISIBLE
            }
            DiskonApi.ApiStatus.SUCCESS -> {
                binding.progressBar.visibility = View.GONE }
            DiskonApi.ApiStatus.FAILED -> {
                binding.progressBar.visibility = View.GONE
                binding.networkError.visibility = View.VISIBLE
            }
        }
    }
}