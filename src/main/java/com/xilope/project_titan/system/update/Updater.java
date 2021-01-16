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
    public void addUpdatable(Updatable target) {
        int targetPriority = PriorityUpdatable.DEFAULT_PRIORITY; //타겟이 일반 업데이터블 클래스일경우 기본 우선순위값으로 설정한다.
        //만약 타겟 이 우선순위 업테이터블 클래스일경우
        if(target instanceof PriorityUpdatable) {
            targetPriority = ((PriorityUpdatable) target).getPriority(); //타겟의 우선순위를 가져와 타겟 우선순위 변수에 저장한다.
        }
        for(int i = 0; i < updateList.size(); i++) {
            Updatable attr = updateList.get(i); //updateList 의 모든 요소를 차례차례 저장한다.
            int attrPriority = PriorityUpdatable.DEFAULT_PRIORITY; //요소가 일반 업데이터블 클래스의경우 기본 우선순위값으로 설정한다.
            if(attr instanceof PriorityUpdatable) //만약 updateList 내 요소가 우선순위 업데이터블 클래스일경우
                attrPriority = ((PriorityUpdatable) attr).getPriority(); //해당 요소의 우선순위를 가져와 요소 우선순위 변수에 저장한다.
            if(attrPriority < targetPriority) { //추가할 업데이터의 우선순위가 요소보다 더 크다면
                updateList.add(i, target); //해당 요소 뒤에 타겟을 추가한다.
                return; //업데이터 추가작업이 완료되었으므로, 메소드를 종료한다.
            }
        }
        updateList.add(target); //만약 타겟의 우선순위가 가장 낮다면 리스트의 마지막에 타겟을 추가한다.
    }

    @Override
    public String toString() {
        return name;
    }
}
