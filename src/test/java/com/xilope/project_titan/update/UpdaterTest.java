package com.xilope.project_titan.update;

import com.xilope.project_titan.system.update.PriorityUpdatable;
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

        //add Updatable and PriorityUpdatable in updater_
        int[] testPriority = {1, 2, 1, 3, 4, 6, 5, 0, -1};
        for(int i = 0; i < testPriority.length; i++) {
            updater_.addUpdatable(new PriorityUpdatable(testPriority[i]) {
                @Override
                public void update() {
                    System.out.println(toString());
                }
            });
        }
        //숫자 중복시 순서 테스트를 위함
        updater_.addUpdatable(new PriorityUpdatable(4) {
            @Override
            public void update() {
                System.out.println("가장 마지막에 넣은" + toString());
            }
        });
    }

    @Test
    public void testUpdaterName() {
        System.out.println("업데이터블 테스트->업데이터 이름 출력 테스트를 시작합니다");
        assertEquals(updater.toString(), "@Test Updater");
        assertEquals(updater_.toString(), "@New Updater");
    }

    @Test
    public void testUpdaterUpdate() {
        System.out.println("업데이터블 테스트->업데이트 테스트를 시작합니다");
        updater.updateAll();
    }

    @Test
    public void testUpdaterPriorityUpdate() {
        System.out.println("업데이터블 테스트->우선순위 업데이트 테스트를 시작합니다");
        updater_.updateAll();
    }

    /*
    테스트 성공시 로그
    ----------------------------------------------------------------------
    업데이터블 테스트->업데이터 이름 출력 테스트를 시작합니다
    업데이터블 테스트->업데이트 테스트를 시작합니다
    Update1
    Update2
    Update3
    업데이터블 테스트->우선순위 업데이트 테스트를 시작합니다
    우선순위가 6인 업데이터블입니다
    우선순위가 5인 업데이터블입니다
    우선순위가 4인 업데이터블입니다
    가장 마지막에 넣은우선순위가 4인 업데이터블입니다
    우선순위가 3인 업데이터블입니다
    우선순위가 2인 업데이터블입니다
    우선순위가 1인 업데이터블입니다
    우선순위가 1인 업데이터블입니다
    우선순위가 0인 업데이터블입니다
    우선순위가 -1인 업데이터블입니다

    Process finished with exit code 0
     */
}
