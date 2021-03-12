package com.wordcount;

import com.wordcount.domain.enums.ActionType;
import com.wordcount.reader.InputReader;
import com.wordcount.reader.impl.FileReaderImpl;

import java.util.LinkedList;
import java.util.Queue;

public final class ActionQueue {

    private static ActionQueue instance;

    private static final Queue<ActionQueueMember> _queue = new LinkedList<>();

    private ActionQueue() {
    }

    public static ActionQueue getInstance() {
        if (instance == null) {
            instance = new ActionQueue();
        }
        return instance;
    }

    public void add(InputReader invoker) {
        if (!(invoker instanceof FileReaderImpl)) return;
        _queue.add(new ActionQueueMember(ActionType.CONTINUE));
        _queue.add(new ActionQueueMember(ActionType.TERMINATE));

    }

    public void add(InputReader invoker, int inputTextLength) {
        if (!(invoker instanceof FileReaderImpl)) return;
        switch (inputTextLength) {
            case 0:
                _queue.add(new ActionQueueMember(ActionType.TERMINATE));
                break;

            default:
                _queue.add(new ActionQueueMember(ActionType.CONTINUE));
                _queue.add(new ActionQueueMember(ActionType.READ, invoker));

        }
    }

    public void executeFirstAction() {
        ActionQueueMember member = _queue.poll();
        executeAction(member);
    }

    public boolean isNotEmpty() {
        return _queue.size() > 0;
    }

    private void executeAction(ActionQueueMember member) {
        switch (member.getAction()) {
            case TERMINATE:
                System.exit(0);
                break;

            case CONTINUE:
                break;

            case READ:
                member.getReader().read();
                break;
        }
    }
}

class ActionQueueMember {
    private ActionType _action;

    public ActionType getAction() {
        return _action;
    }

    private InputReader _reader;

    public InputReader getReader() {
        return _reader;
    }

    public ActionQueueMember(ActionType action) {
        _action = action;
    }

    public ActionQueueMember(ActionType action, InputReader reader) {
        _action = action;
        _reader = reader;
    }
}