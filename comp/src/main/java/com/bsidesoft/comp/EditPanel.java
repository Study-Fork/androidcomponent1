package com.bsidesoft.comp;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.bsidesoft.comp.databinding.EditPanelBinding;

public class EditPanel extends LinearLayout implements Runnable {
    private Model model;
    private OnClickListener click;
    private EditPanelBinding binding;

    public EditPanel(Context context) {
        super(context);
    }
    public EditPanel(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public EditPanel(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    static LayoutInflater inflater(@NonNull View v){
        return (LayoutInflater) v.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    private void model(Model m) {
        binding = DataBindingUtil.inflate(inflater(this), R.layout.edit_panel, this, false);
        addView(binding.getRoot());

        if(model != null) model.removeListener(this);
        model = m;
        model.addListener(this);
        binding.setClick(v->{
            model.title(binding.edit.getText().toString());
            run();
        });
        run();
    }
    @Override
    public void run() {
        binding.setModel(model);
        binding.executePendingBindings();

    }

    @BindingAdapter(value = {"app:model"})
    public static void setModel(EditPanel v, Model model){
        v.model(model);
    }
}
