package com.wordcount;

import com.wordcount.domain.enums.ActionType;

import java.util.LinkedList;
import java.util.Queue;

public final class ActionQueue {

    private static ActionQueue instance;

    private final Queue<ActionType> _queue = new LinkedList<>();

    private ActionQueue() {
    }

    public static ActionQueue getInstance() {
        if (instance == null) {
            instance = new ActionQueue();
        }
        return instance;
    }

    public void add(ActionType actionType) {
        _queue.add(actionType);
    }

    public void add(int inputTextLength) {
        switch (inputTextLength) {
            case 0:
                add(ActionType.TERMINATE);
                break;

            default:
                add(ActionType.EXECUTE);
                break;
        }
    }

    public void executeAction() {
        ActionType actionType = _queue.poll();
        if (actionType != null)
            executeAction(actionType);
    }

    public void executeActionIfEqualsTo(ActionType action) {
        if (_queue.peek() == action)
            executeAction();
    }

    public boolean isNotEmpty() {
        return _queue.size() > 0;
    }

    private void executeAction(ActionType actionType) {
        switch (actionType) {
            case TERMINATE:
                System.exit(0);
                break;
            case EXECUTE:
                break;
        }
    }
}