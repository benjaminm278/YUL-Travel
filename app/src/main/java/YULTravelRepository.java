import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.yultravel.Profile;
import com.example.yultravel.ProfileDAO;
import com.example.yultravel.YULTravelDatabase;

import java.util.List;

public class YULTravelRepository {

    private ProfileDAO mProfileDao;
    private LiveData<List<Profile>> mAllProfiles;

    public YULTravelRepository(Application application){
        YULTravelDatabase db = YULTravelDatabase.getDatabase(application);
        mProfileDao = db.ProfileDAO();
        mAllProfiles = mProfileDao.getAllProfiles();
    }

    LiveData<List<Profile>> getAllWords() {
        return mAllProfiles;
    }


}
