package zm.hashcode.hashdroidpvt.repository.settings;

import android.test.AndroidTestCase;
import android.util.Log;

import junit.framework.Assert;

import org.testng.annotations.Test;

import java.util.Set;

import zm.hashcode.hashdroidpvt.domain.settings.Settings;
import zm.hashcode.hashdroidpvt.respository.settings.Impl.SettingsRespositoryImpl;
import zm.hashcode.hashdroidpvt.respository.settings.SettingsRespository;

/**
 * Created by hashcode on 2016/04/09.
 */
public class SettingsRepositoryTest  extends AndroidTestCase {
    private static final String TAG="SETTINGS TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        SettingsRespository repo = new SettingsRespositoryImpl(this.getContext());
        Settings createEntity = new Settings.Builder()
                .code("FDC")
                .password("test12")
                .username("fcb@test.com")
                .build();
        Settings insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        Set<Settings> settings = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",settings.size()>0);

        Settings entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        Settings updateEntity = new Settings.Builder()
                .copy(entity)
                .password("TEST47")
                .build();
        repo.update(updateEntity);
        Settings newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","TEST47",newEntity.getPassword());

        repo.delete(updateEntity);
        Settings deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }

}
