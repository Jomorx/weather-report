package com.hch.weather_report;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.platform.app.InstrumentationRegistry;

import com.hch.weather_report.database.AppDatabase;
import com.hch.weather_report.database.mapper.CityMapper;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)
public class ExampleUnitTest {
    private AppDatabase db;
    private CityMapper cityMapper;
    @Test
    public void addition_isCorrect() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        db = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(),
            AppDatabase.class).build();
        cityMapper = db.cityMapper();

        System.out.println(cityMapper);
        cityMapper.deleteAllCity();
    }

}