package com.xilope.project_titan.update;

import com.xilope.project_titan.system.update.Updater;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UpdaterTest {
    private Updater updater_;
    private Updater updater;

    @Before
    public void initialUpdater() {
        //initialize updaters to Constructor of Updater
        updater_ = new Updater();
        updater = new Updater("@Test Updater");

        //add Updatable in updater
        updater.addUpdatable(()-> System.out.println("Update1"));
        updater.addUpdatable(()-> System.out.println("Update2"));
        updater.addUpdatable(()-> System.out.println("Update3"));
    }

    @Test
    public void testUpdaterName() {
        assertEquals(updater_.toString(), "@New Updater"); //업데이터의 기본
        assertEquals(updater_.toString(), "@New Updater");
    }

    @Test
    public void testUpdaterUpdate() {
        updater.updateAll();
    }
}
