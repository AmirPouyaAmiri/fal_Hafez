package com.amiri.faleHafez.repo;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.amiri.faleHafez.dataBase.FalDatabase;
import com.amiri.faleHafez.entity.Fal;
import com.amiri.faleHafez.service.FalDao;

import java.util.List;

public class FalRepository {

        private FalDao poemDao;
        private LiveData<List<Fal>> AllPoems;

        FalRepository(Application application) {
            FalDatabase db = FalDatabase.getDatabase(application);
            poemDao = db.falDao();
            AllPoems = poemDao.getRandomPoems();

        }
        LiveData<List<Fal>> getAllPoems(){
            return AllPoems;
        }
        void insert(Fal fal) {
            FalDatabase.databaseWriteExecutor.execute(() -> {
                poemDao.insert(fal);
            });
        }
    }
