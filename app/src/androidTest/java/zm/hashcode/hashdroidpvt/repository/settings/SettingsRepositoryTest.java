package zm.hashcode.hashdroidpvt.repository.settings;

import android.test.AndroidTestCase;
import junit.framework.Assert;


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
        // CREATE
        Settings createEntity = new Settings.Builder()
                .code("FDCD")
                .password("test12")
                .username("fc89b@test.com")
                .build();
        Settings insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<Settings> settings = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",settings.size()>0);

        //READ ENTITY
        Settings entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        Settings updateEntity = new Settings.Builder()
                .copy(entity)
                .password("TEST47")
                .build();
        repo.update(updateEntity);
        Settings newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","TEST47",newEntity.getPassword());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Settings deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }

}
