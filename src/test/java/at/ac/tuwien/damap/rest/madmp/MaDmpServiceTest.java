package at.ac.tuwien.damap.rest.madmp;

import at.ac.tuwien.damap.r3data.RepositoriesService;
import at.ac.tuwien.damap.rest.madmp.dto.Dmp;
import at.ac.tuwien.damap.rest.madmp.mapper.MaDmpMapper;
import at.ac.tuwien.damap.util.TestDOFactory;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class MaDmpServiceTest {


    @Inject
    TestDOFactory testDOFactory;

    @Inject
    RepositoriesService repositoriesService;

    @Test
    @TestSecurity(authorizationEnabled = false)
    void getByIdTest() {
        Dmp dmp = MaDmpMapper.mapToMaDmp(testDOFactory.getOrCreateTestDmpDO(), new Dmp(), repositoriesService);
        Assertions.assertNotNull(dmp);
    }

    @Test
    @TestSecurity(authorizationEnabled = false)
    void getByIdEmptyTest() {
        Dmp dmp = MaDmpMapper.mapToMaDmp(testDOFactory.getOrCreateTestDmpDOEmpty(), new Dmp(), repositoriesService);
        Assertions.assertNotNull(dmp);
    }
}