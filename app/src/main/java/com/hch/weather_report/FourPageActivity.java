package com.hch.weather_report;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.hch.weather_report.Adapter.FourAdapter;
import com.hch.weather_report.databinding.ActivityFourPageBinding;
import com.hch.weather_report.model.FourItem;

import java.util.ArrayList;
import java.util.List;

public class FourPageActivity extends AppCompatActivity {
    private List<FourItem> fourItemList=new ArrayList<>();
    private ActivityFourPageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFourPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        initList();
//        RecyclerView recyclerView = findViewById(R.id.list);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//        FourAdapter adapter = new FourAdapter(fourItemList);
//        recyclerView.setAdapter(adapter);
    }
    public void initList(){
//        fourItemList.add(new FourItem(R.drawable.user,"个人资料"));
//        fourItemList.add(new FourItem(R.drawable.eye,"阅读记录"));
//        fourItemList.add(new FourItem(R.drawable.setting,"设置"));
//        fourItemList.add(new FourItem(R.drawable.question,"帮助与反馈"));
//        fourItemList.add(new FourItem(R.drawable.info,"关于我们"));
    }
}
