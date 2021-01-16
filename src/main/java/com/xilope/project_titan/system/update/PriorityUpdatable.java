package com.xilope.project_titan.system.update;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public abstract class PriorityUpdatable implements Updatable{
    public static final int DEFAULT_PRIORITY = 0; //기본 우선순위값 설정

    public PriorityUpdatable() {
        this(DEFAULT_PRIORITY); //기본 우선순위값으로 우선순위를 초기화한다.
    }

    @Getter
    private final int priority;

    @Override
    public String toString() {
        return String.format("우선순위가 %d인 업데이터블입니다", priority);
    }
}
