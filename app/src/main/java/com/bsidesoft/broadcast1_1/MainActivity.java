package com.bsidesoft.broadcast1_1;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bsidesoft.broadcast1_1.databinding.ActivityMainBinding;
import com.bsidesoft.comp.Model;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        Model model0 = new Model();
        Model model1 = new Model();
        model0.title("테스트 타이틀0");
        model1.title("테스트 타이틀1");
        binding.setModel(new Model[]{model0, model1});
        binding.executePendingBindings();
    }
}
