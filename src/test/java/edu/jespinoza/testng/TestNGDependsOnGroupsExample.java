package edu.jespinoza.testng;

import org.apache.log4j.Logger;
import org.testng.annotations.*;

public class TestNGDependsOnGroupsExample {
    private static final Logger logger = Logger.getLogger(TestNGDependsOnGroupsExample.class);

    @BeforeGroups(groups = {"security"})
    public void setUpSecurity() {
        logger.info("En setUpSecurity");
    }

    @AfterGroups(groups = {"security"})
    public void tearDownSecurity() {
        logger.info("En tearDownSecurity");
    }

    @BeforeGroups(groups = {"database"})
    public void setUpDatabase() {
        logger.info("En setUpDatabase del Grupo database");
    }

    @AfterGroups(groups = {"database"})
    public void tearDownDatabase() {
        logger.info("En tearDownDatabase del Grupo database");
    }

    @BeforeGroups(groups = {"ui"})
    public void setUpUI() {
        logger.info("En setUpUI del Grupo ui");
    }

    @AfterGroups(groups = {"ui"})
    public void tearDownUI() {
        logger.info("En tearDownUI del Grupo ui");
    }

    @Test(groups = {"database"})
    public void testInsert() {
        logger.info("En la prueba Insert del Grupo database");
    }

    @Test(groups = {"database"})
    public void testUpdate() {
        logger.info("En la prueba Update del Grupo database");
    }

    @Test(groups = {"database"})
    public void testDelete() {
        logger.info("En la prueba Delete del Grupo database");
    }

    @Test(groups = {"security"})
    public void accessHomePage() {
        logger.info("En la prueba accessHomePage del Grupo security");
    }

    @Test(groups = {"security"})
    public void accessAdminPage() {
        logger.info("En la prueba accessAdminPage - Va a lanzar una excepción no esperada");
        throw new RuntimeException();
    }

    @Test(groups = {"ui"})
    public void openConfirmationDialog() {
        logger.info("En la prueba openConfirmationDialog del Grupo ui");
    }

    @Test(groups = {"ui"})
    public void openFileDialog() {
        logger.info("En la prueba openFileDialog del Grupo ui");
    }

    @Test(dependsOnGroups = {"ui"})
    public void uiGroupDependentTest() {
        logger.info("En uiGroupDependentTest");
    }


    @Test(dependsOnGroups = {"security", "database"})
    public void backendGroupDependentTest1() {
        logger.info("En backendGroupDependentTest1");
    }

    @Test(dependsOnGroups = {"security", "database"}, alwaysRun = true)
    public void backendGroupDependentTest2() {
        logger.info("En backendGroupDependentTest2");
    }
}
