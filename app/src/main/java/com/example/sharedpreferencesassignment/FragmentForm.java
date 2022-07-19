package com.example.sharedpreferencesassignment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.sharedpreferencesassignment.databinding.FragmentFormBinding;
import com.example.sharedpreferencesassignment.model.Data;
import com.example.sharedpreferencesassignment.viewmodel.FormViewModel;

public class FragmentForm extends Fragment {

    FragmentFormBinding binding;
    FormViewModel viewModel;

    public FragmentForm() {
    }

    public static FragmentForm newInstance() {
        FragmentForm fragment = new FragmentForm();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFormBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        viewModel = new ViewModelProvider(requireActivity()).get(FormViewModel.class);
        viewModel = new ViewModelProvider.AndroidViewModelFactory(this.requireActivity().getApplication())
                .create(FormViewModel.class);
        binding.setViewModel(viewModel);
        Data data = new Data();
        binding.setModel(data);
        binding.setLifecycleOwner(this);
    }
}