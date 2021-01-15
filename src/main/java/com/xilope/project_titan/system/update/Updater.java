package com.xilope.project_titan.system.update;

import java.util.ArrayList;
import java.util.List;

public class Updater {
    private static final String DEFAULT_NAME = "@New Updater";
    private final String name;
    private final List<Updatable> updateList;

    public Updater() {
        this(DEFAULT_NAME);
    }

    public Updater(String name) {
        this.name = name;
        updateList = new ArrayList<>();
    }

    public void updateAll() {
        updateList.forEach(Updatable::update);
    }
    public void addUpdatable(Updatable updatable) {
        //만약 Updatable 이 우선순위 업테이터블 클래스일경우
        if(updatable instanceof PriorityUpdatable) {
            PriorityUpdatable target = (PriorityUpdatable) updatable;
        } else { //일반적인 updatable 일경우
            updateList.add(updatable);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
