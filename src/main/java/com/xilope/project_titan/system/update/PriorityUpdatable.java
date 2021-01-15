package com.xilope.project_titan.system.update;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public abstract class PriorityUpdatable implements Updatable{
    @Getter
    private int priority;
}
